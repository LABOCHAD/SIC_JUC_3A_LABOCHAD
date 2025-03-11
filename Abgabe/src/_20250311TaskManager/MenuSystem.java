package _20250311TaskManager;

import myTools.UserInputScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuSystem {
    Scanner scanner = new Scanner(System.in);
    List<Task> tasks = new ArrayList<>();
    int id;

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

    void addTask() {
        System.out.println("Enter task name: ");
        String name = scanner.nextLine();
        System.out.println("Enter task description: ");
        String description = scanner.nextLine();
        System.out.println("Enter task priority: ");
        int priority = UserInputScanner.getIntOnlyPosRanged(scanner, 1, 6);
        tasks.add(new Task(id, name, description, priority));
    }


}
