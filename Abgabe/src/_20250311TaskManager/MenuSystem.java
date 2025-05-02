package _20250311TaskManager;

import myTools.UserInputScanner;

import java.util.*;

// optional additions:
// consider adding persistence later with BufferedWriter/Reader (file saving/loading)

public class MenuSystem {
    Scanner scanner = new Scanner(System.in);

    List<Task> tasks = new ArrayList<>();
    ArrayList<Task> openTasks = new ArrayList<>();
    ArrayList<Task> completedTasks = new ArrayList<>();

    Comparator<Task> compareTaskByName = Comparator.comparing(Task::getName);
    Comparator<Task> compareTaskByDescription = Comparator.comparing(Task::getDescription);
    Comparator<Task> compareTaskByPriority = Comparator.comparing(Task::getPriority);
    Comparator<Task> compareTaskById = Comparator.comparing(Task::getId);


    public static void main(String[] args) {
        MenuSystem ms = new MenuSystem();
        System.out.println("\nWelcome to the menu system of this task manager.");
        ms.tasks = TaskFileHandler.loadTasksFromFile(); //stays empty, if not successful.
        ms.navigate();
        ms.scanner.close();
    }

    void navigate() {
        while (true) {

            while (tasks.isEmpty()) { // I placed it here, so it won't be necessary to test everywhere
                System.out.println("\nSeems like we have no tasks, please enter a task first.");
                addTask();
            }

            switch (showMenu()) {
                case 0:
                    TaskFileHandler.saveTasksToFile(tasks);
                    break;
                case 1:
                    addTask();
                    break;
                case 2:
                    showAllTasks();
                    break;
                case 3:
                    markTaskAsDone();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    prioritize();
                    break;
                case 6:
                    sortAndDisplayByPropertyOrder();
                    break;
                case 7:
                    searchTaskByNameOrDescriptionAndShow();
                    break;
                case 8:
                    showStatistics();
                    break;
                case 9:
                    changeNameAndDescription();
                    break;
                case 10:
                    return;
                default:
                    System.err.println("Oops. Something went wrong here.");
            }
        }
    }

    int showMenu() {
        UserInputScanner.pressReturnToContinue(scanner);

        System.out.printf("%nTask Manager Main Menu:" +
                          "%n-----------------------" +
                          "%n(0) Save changes to file" +
                          "%n(1) Add new task" +
                          "%n(2) Show all task (open/done seperated)" +
                          "%n(3) Mark task as done" +
                          "%n(4) Delete a task" +
                          "%n(5) Prioritize task" +
                          "%n(6) Sort and display by a property's order" +
                          "%n(7) Search for a task (by name and description)" +
                          "%n(8) Show statistical info about tasks" +
                          "%n(9) Change name and description of a task" +
                          "%n(10) Exit the programm" +
                          "%n" +
                          "%nPlease make a choice between 0 and 9: ");

        return UserInputScanner.getIntOnlyPosRanged(scanner, 0, 11);
    }

    void addTask() {
        System.out.println("Enter task name: ");
        String name = scanner.nextLine();
        System.out.println("Enter task description: ");
        String description = scanner.nextLine();
        System.out.println("Enter task priority: ");
        int priority = UserInputScanner.getIntOnlyPosRanged(scanner, 1, 6);
        try {
            tasks.add(new Task(getNextFreeId(), name, description, priority));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    void showAllTasks() {
        distinguishTasksByStatus();
        openTasks.sort(compareTaskByPriority);
        completedTasks.sort(compareTaskByPriority);

        System.out.println("List of still open tasks:");
        openTasks.forEach(System.out::println);
        if (openTasks.isEmpty()) {
            System.out.println("No open tasks found.");
        }
        System.out.println();
        System.out.println("List of completed tasks:");
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks found.");
        }
        completedTasks.forEach(System.out::println);
    }

    void markTaskAsDone() {
        try {
            Task task = getTaskById();
            task.markAsDone();
            System.out.println("Task Marked as done:");
            System.out.println(task);
        } catch (IllegalStateException | TaskNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    void deleteTask() {
        try {
            Task task = getTaskById();
            tasks.remove(task);
            System.out.println("Task deleted: " + task);
        } catch (TaskNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    void sortAndDisplayByPropertyOrder() {
        System.out.println("\nWhich property do you want to sort the task by?" +
                           "\n(1) Name" +
                           "\n(2) Description" +
                           "\n(3) Priority" +
                           "\n(4) ID" +
                           "\n(5) not at all" +
                           "\nPlease make a choice: ");
        int choice = UserInputScanner.getIntOnlyPosRanged(scanner, 1, 5);

        switch (choice) {
            case 1:
                tasks.sort(compareTaskByName);
                break;
            case 2:
                tasks.sort(compareTaskByDescription);
                break;
            case 3:
                tasks.sort(compareTaskByPriority);
                break;
            case 4:
                tasks.sort(compareTaskById);
                break;
            default:
                System.out.println("No changes have been applied.");
                return;
        }

        tasks.forEach(System.out::println);
    }

    void prioritize() {
        try {
            Task task = getTaskById();
            System.out.println("Choose new priority for the task (1-5): ");
            int newPriority = UserInputScanner.getIntOnlyPosRanged(scanner, 1, 6);
            task.setPriority(newPriority);
            System.out.println("Task (re-)prioritized: " + task);
        } catch (IllegalArgumentException | TaskNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    void searchTaskByNameOrDescriptionAndShow() {
        System.out.println("Enter the name or description or a part of one of them:");
        String searchKey = scanner.nextLine();
        ArrayList<Task> foundTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getName().toLowerCase().contains(searchKey.toLowerCase()) ||
                task.getDescription().toLowerCase().contains(searchKey.toLowerCase()))
                foundTasks.add(task);
        }
        if (foundTasks.isEmpty()) {
            System.out.println("No task found with that name or description has been found.");
        } else {
            System.out.println("Found " + foundTasks.size() + " task(s).");
            foundTasks.forEach(System.out::println);
        }
    }

    void showStatistics() {
        System.out.println("\nStatistics:");
        System.out.println("Total count of tasks: \t" + tasks.size());
        distinguishTasksByStatus();
        System.out.println("Tasks still in progress: \t" + openTasks.size());
        System.out.println("Tasks already completed: \t" + completedTasks.size());
    }

    void changeNameAndDescription() {
        try {
            Task task = getTaskById();
            System.out.println("You picked the following task: " + task);
            System.out.println("Now you can change its name and its description.");
            System.out.println("Type in the new value, if wanted or leave it empty for not changing.");

            System.out.println("New name: ");
            String name = scanner.nextLine();
            System.out.println("New Description");
            String description = scanner.nextLine();

            if (!name.isEmpty()) task.setName(name);
            if (!description.isEmpty()) task.setDescription(description);

        } catch (TaskNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    void distinguishTasksByStatus() {
        openTasks.clear();
        completedTasks.clear();
        for (Task task : tasks) { //we were supposed to do this without streams/filters
            if (!task.isDone())
                openTasks.add(task);
            else
                completedTasks.add(task);
        }
    }

    Task getTaskById() throws TaskNotFoundException {
        System.out.print("Enter task id: ");
        int id = UserInputScanner.getIntOnlyPos(scanner);
        //I wanted to do this with lambdas first, but that became too complicated.
        for (Task task : tasks) {
            if (task.getId() == id)
                return task;
        }
        throw new TaskNotFoundException("Task with id " + id + " not found");
    }

    int getNextFreeId() {
        if (tasks.isEmpty()) return 0;

        List<Task> tempTasks = new ArrayList<>(tasks); //internally uses: Arrays.copyOf(array, size, dataType);
        //Why? Because this way it won't make an unwanted re-sorting on the original list.
        tempTasks.sort(compareTaskById);

        int idCount = 0;
        for (Task task : tempTasks) {
            if (task.getId() == idCount) idCount++;
            else break;
        }
        return idCount;
    }

}
