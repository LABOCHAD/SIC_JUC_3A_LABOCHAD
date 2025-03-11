package _20250311TaskManager;

import myTools.UserInputScanner;

import java.util.Scanner;

public class MenuSystem {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MenuSystem menuSystem = new MenuSystem();

        scanner.nextLine();
    }

    int menu(){
        System.out.print("%nTask Manager Main Menu:" +
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
                         "%nPlease mak a choice between 0 and 9: ");
        return UserInputScanner.getIntOnlyPosRanged(scanner,1,10);
    }
}
