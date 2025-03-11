package _20250311TaskManager;

import myTools.UserInputScanner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MenuSystem {
    Scanner scanner = new Scanner(System.in);
    List<Task> tasks = new ArrayList<>();
    int idCount;

    public static void main(String[] args) {
        MenuSystem ms = new MenuSystem();
        ms.showMenu();
        ms.scanner.close();
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
                          "%n(7) Search for a task (by property)" +
                          "%n(8) Show statistical info about tasks" +
                          "%n(9) Exit the programm" +
                          "%n" +
                          "%nPlease make a choice between 0 and 9: ");

        return UserInputScanner.getIntOnlyPosRanged(scanner, 1, 10);
    }

    void navigate() {
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
            case 9:
                return;
            default:
                System.err.println("Something must have gone horribly wrong here. Exiting...");
        }
    }

    void addTask() {
        System.out.println("Enter task name: ");
        String name = scanner.nextLine();
        System.out.println("Enter task description: ");
        String description = scanner.nextLine();
        System.out.println("Enter task priority: ");
        int priority = UserInputScanner.getIntOnlyPosRanged(scanner, 1, 6);
        tasks.add(new Task(++idCount, name, description, priority));
        //TODO consider later to test for lower id available in case a task has been deleted and reassign lower instead
    }

    void showAllTasks() {
        ArrayList<Task> openTasks = new ArrayList<>();
        ArrayList<Task> completedTasks = new ArrayList<>();

        for (Task task : tasks) { //we were supposed to do this without streams/filters
            if (!task.isDone())
                openTasks.add(task);
            else
                completedTasks.add(task);
        }

        Comparator<Task> compareTaskByPriority = Comparator.comparing(Task::getPriority);
        openTasks.sort(compareTaskByPriority);
        completedTasks.sort(compareTaskByPriority);

        System.out.println("List of still open tasks:");
        openTasks.forEach(System.out::println);//diesmal selbst geschrieben :D
        System.out.println();
        System.out.println("List of completed tasks:");
        completedTasks.forEach(System.out::println);
    }

    void markTaskAsDone() throws TaskNotFoundException {
        System.out.println("Enter task id: ");
        int id = UserInputScanner.getIntOnlyPos(scanner);
        try {
            Task task = getTaskById(id);
            task.markAsDone();
            System.out.println("Task Marked as done:");
            System.out.println(task);
        } catch (IllegalStateException | TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    Task getTaskById(int id) throws TaskNotFoundException {
        //I wanted to do this with lambdas first, but that became too complicated.
        for (Task task : tasks) {
            if (task.getId() == id)
                return task;
        }
        throw new TaskNotFoundException("Task with id " + id + " not found");
    }


}
