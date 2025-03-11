package _20250311TaskManager;

import myTools.UserInputScanner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// optional additions:
// consider adding persistence later with BufferedWriter/Reader (file saving/loading)
// add another method for (re-)sorting by ID (back again) or other terms like name or description or extend the existing
// consider later to test for lower id available in case a task has been deleted and reassign lower first instead

public class MenuSystem {
    Scanner scanner = new Scanner(System.in);
    List<Task> tasks = new ArrayList<>();
    ArrayList<Task> openTasks = new ArrayList<>();
    ArrayList<Task> completedTasks = new ArrayList<>();
    Comparator<Task> compareTaskByPriority = Comparator.comparing(Task::getPriority);
    int idCount;

    public static void main(String[] args) {
        MenuSystem ms = new MenuSystem();
        ms.navigate();
        ms.scanner.close();
    }

    void navigate() {
        while (true) {
            while (tasks.isEmpty()) {
                System.out.println("\nSeems like we have no tasks, please enter a task first.");
                addTask();
            }
            switch (showMenu()) {
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
                    displaySortedByPriority();
                    break;
                case 7:
                    searchTaskByNameOrDescriptionAndShow();
                    break;
                case 8:
                    showStatistics();
                    break;
                case 9:
                    return;
                default:
                    System.err.println("Oops. Something went wrong here.");
            }
        }
    }

    int showMenu() {
        System.out.printf("%nTask Manager Main Menu:" +
                          "%n-----------------------" +
                          "%n(1) Add new task" +
                          "%n(2) Show all task" +
                          "%n(3) Mark task as done" +
                          "%n(4) Delete a task" +
                          "%n(5) Prioritize task" +
                          "%n(6) Display all sorted by priority" +
                          "%n(7) Search for a task (by name and description)" +
                          "%n(8) Show statistical info about tasks" +
                          "%n(9) Exit the programm" +
                          "%n" +
                          "%nPlease make a choice between 0 and 9: ");

        return UserInputScanner.getIntOnlyPosRanged(scanner, 1, 10);
    }

    void addTask() {
        System.out.println("Enter task name: ");
        String name = scanner.nextLine();
        System.out.println("Enter task description: ");
        String description = scanner.nextLine();
        System.out.println("Enter task priority: ");
        int priority = UserInputScanner.getIntOnlyPosRanged(scanner, 1, 6);
        try {
            tasks.add(new Task(++idCount, name, description, priority));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    void showAllTasks() {
        distinguishTasksByStatus();
        openTasks.sort(compareTaskByPriority);
        completedTasks.sort(compareTaskByPriority);

        System.out.println("List of still open tasks:");
        openTasks.forEach(System.out::println);//diesmal selbst geschrieben :D
        System.out.println();
        System.out.println("List of completed tasks:");
        completedTasks.forEach(System.out::println);
    }

    void markTaskAsDone() throws TaskNotFoundException {
        try {
            Task task = getTaskById();
            task.markAsDone();
            System.out.println("Task Marked as done:");
            System.out.println(task);
        } catch (IllegalStateException | TaskNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    void deleteTask() throws TaskNotFoundException {
        try {
            Task task = getTaskById();
            tasks.remove(task);
            System.out.println("Task deleted: " + task);
        } catch (TaskNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    void displaySortedByPriority() {
        tasks.sort(compareTaskByPriority);
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
        }
        else {
            System.out.println("Found " + foundTasks.size() + " task(s).");
            foundTasks.forEach(System.out::println);
        }
    }

    void showStatistics(){
        System.out.println("\nStatistics:");
        System.out.println("Total count of tasks: \t" + tasks.size());
        distinguishTasksByStatus();
        System.out.println("Tasks still in progress: \t" + openTasks.size());
        System.out.println("Tasks already completed: \t" + completedTasks.size());
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

}
