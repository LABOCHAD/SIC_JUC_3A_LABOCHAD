package _20250211WdhExceptions;

import java.util.Scanner;

public class AgeValidation {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter age (0-120): ");
            //easy way, but away from way of the task, because makes age validation obsolete
            //validateAge(UserInputScanner.getIntOnlyPosRanged(sc, 0, 121));

            //auch möglich statt NumberFormatException
            //validateAge(UserInputScanner.getInt(sc)); //verhindert kein ungültiges Alter, aber garantiert einen Integer

            validateAge(Integer.parseInt(sc.nextLine()));
        } catch (NumberFormatException | InvalidAgeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException();
        }
        System.out.println(age + " is a valid age.");
    }


    static class InvalidAgeException extends Exception {
        InvalidAgeException() {
            super("Invalid age!");
        }
    }
}

