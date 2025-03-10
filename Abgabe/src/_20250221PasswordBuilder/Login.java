package _20250221PasswordBuilder;

import myTools.UserInputScanner;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Login {
    static PasswordBuilder passwordBuilder;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //get user input here! - // make sure int will be just int // catch argument exception and force repetition
        createPasswordBuilderByUserInput();

        System.out.println("Password: " + passwordBuilder.getPassword());

        //ask the user to enter PW after successfully created the PW
        System.out.print("\nNow try it out and enter it: ");
        boolean isMatch = passwordBuilder.checkPassword(scanner.nextLine());
        System.out.println("You have entered it " + (isMatch ? "correctly" : "incorrectly"));

        //use all methods created in PasswordBuilder, and print the result
        System.out.println("Password reserved: " + passwordBuilder.reversePassword());
        System.out.println("Password last char cut off: " + passwordBuilder.removeLastChar());
        //The rest have been already invoked above
        scanner.close();
    }

    static void createPasswordBuilderByUserInput(){
        boolean failed;
        do {
            try {
                System.out.print("\nEnter your first and last name: ");
                String name = scanner.nextLine();

                System.out.print("\nEnter your favorite animal: ");
                String animal = scanner.nextLine();

                System.out.print("\nEnter your year of birth: ");
                int year = UserInputScanner.getIntOnlyPos(scanner);

                passwordBuilder = new PasswordBuilder(name, animal, year);
                failed = false;

            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                failed = true;
            }
        } while (failed);
    }
}
