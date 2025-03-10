package _20250211WdhExceptions;

import myTools.Color;
import myTools.UserInputScanner;

import java.util.Scanner;

public class Nulldivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //could also be looped with an InputMismatchException (not castable as int)
        //(or IllegalArgumentException, if radix is invalid) - got from scanner docs

        System.out.print("\nType in a dividend(x): ");
        int x = UserInputScanner.getInt(scanner);

        System.out.print("\nType in a divisor(y): ");
        int y = UserInputScanner.getInt(scanner);

        try{ //could also wrap input to catch input mismatch additionally
            System.out.printf("%n%d / %d = %d %n", x, y, (x/y));
        } catch (ArithmeticException e){
            System.out.println(Color.RED + "Nulldivision! " + e.getMessage() + Color.RESET);
        } finally {
            System.out.println("Done anyway");
            scanner.close();
        }


    }
}
