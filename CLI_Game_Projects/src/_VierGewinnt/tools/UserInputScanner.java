package _VierGewinnt.tools;

import java.util.Scanner;

public class UserInputScanner {

    public static void pressReturnToContinue(Scanner scanner) {
        System.out.println("Press return to continue...");
        scanner.nextLine();
        scanner.reset();
    }

    /**
     * Takes user input by scanner to get a ranged number.
     * If input is not numeric or out of range, it repeats.
     * @param scanner for input.
     * @param from first bound of range (inclusive).
     * @param to ending bound of range (exclusive, because of usual convention).
     * @return a valid integer within the given range.
     */
    public static int getIntOnlyPosRanged(Scanner scanner, int from, int to) {
        int n = 0;
        boolean isInt = false;
        boolean isInRange = false;

        do {
            if (scanner.hasNextInt()) {
                isInt = true;
                n = scanner.nextInt();
            } else {
                System.err.println("Invalid value!");
                System.err.println("Please enter an integer number!");
                scanner.reset();
            }

            if (n < from || n >= to) {
                System.err.println("Value is out of range. Please try again.");
                scanner.reset();
            } else {
                isInRange = true;
            }

            scanner.nextLine();
        } while (!isInt || !isInRange);

        return n;
    }

    //Only Positives
    public static int getIntOnlyPos(Scanner scanner) {
        int n = -1;
        do {
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
            }
            if (n < 0) {
                System.err.println("Invalid value!");
                System.err.println("Please enter a natural number!");
                scanner.reset();
            }
            scanner.nextLine();
        } while (n < 0);
        return n;
    }

    public static double getDoubleOnlyPos(Scanner scanner) {
        double d = -1;
        do {
            if (scanner.hasNextDouble()) {
                d = scanner.nextDouble();
            }
            if (d < 0) {
                System.err.println("Invalid value!");
                System.err.println("Please enter a positive decimal number!");
                scanner.reset();
            }
            scanner.nextLine();
        } while (d < 0);
        return d;
    }

    public static float getFloatOnlyPos(Scanner scanner) {
        float f = -1;
        do {
            if (scanner.hasNextFloat()) {
                f = scanner.nextFloat();
            }
            if (f < 0) {
                System.err.println("Invalid value!");
                System.err.println("Please enter a positive decimal number!");
                scanner.reset();
            }
            scanner.nextLine();
        } while (f < 0);
        return f;
    }

    //Also negatives allowed
    public static int getInt(Scanner scanner) {
        int n = 0;
        boolean isInt = false;

        do {
            if (scanner.hasNextInt()) {
                isInt = true;
                n = scanner.nextInt();
            } else {
                System.err.println("Invalid value!");
                System.err.println("Please enter an integer number!");
                scanner.reset();
            }
            scanner.nextLine();
        } while (!isInt);

        return n;
    }

    public static double getDouble(Scanner scanner) {
        double d = 0;
        boolean isDouble = false;
        do {
            if (scanner.hasNextDouble()) {
                d = scanner.nextDouble();
                isDouble = true;
            } else {
                System.err.println("Invalid value!");
                System.err.println("Please enter a decimal number!");
                scanner.reset(); //try to avoid stack overflow
            }
            scanner.nextLine(); //get rid of excessive line break from nextInt()
        } while (!isDouble);
        return d;
    }

    public static float getFloat(Scanner scanner) {
        float f = 0;
        boolean isFloat = false;
        do {
            if (scanner.hasNextFloat()) {
                f = scanner.nextFloat();
                isFloat = true;
            } else {
                System.err.println("Invalid value!");
                System.err.println("Please enter a decimal number!");
                scanner.reset(); //try to avoid stack overflow
            }
            scanner.nextLine(); //get rid of excessive line break from nextInt()
        } while (!isFloat);
        return f;
    }
}
