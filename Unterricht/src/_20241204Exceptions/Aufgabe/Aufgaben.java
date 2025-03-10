package _20241204Exceptions.Aufgabe;

import myOwnExceptions.*;

import java.util.Random;
import java.util.Scanner;

public class Aufgaben {
    public static void main(String[] args) {
        aufgabe1();
        aufgabe2();
        aufgabe3();
        aufgabe4();
    }

    public static void aufgabe1() {
        System.out.printf("%nAufgabe 1:%n");
        int[] arr5 = new int[5];
        try {
            for (int i = 0; i < 6; i++) { //built in wrong condition intentionally, must be i < 5
                arr5[i] = i;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        } finally {
            for (int i : arr5) {
                System.out.println(i);
            }
        }
    }

    public static void aufgabe2() {
        System.out.printf("%n%nAufgabe 2:%n");
        Random random = new Random();
        int a;
        int b;

        for (int i = 1; i <= 100; i++) {
            a = random.nextInt(0, 11);
            b = random.nextInt(0, 11);
            try {
                int ergebnis = divisionInAufgabe2(a, b);
                System.out.println(i + ". Ergebnis: " + ergebnis);
            } catch (DivisionByZeroException | NotAnIntegerException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static int divisionInAufgabe2(int a, int b) throws DivisionByZeroException, NotAnIntegerException {
        if (b == 0)
            throw new DivisionByZeroException();

        double result = (double) a / b;
        if (result % 1.0 != 0) {
            //throw new IsNotIntegerException();
            throw new NotAnIntegerException("Number is not an Integer! --> " + a + "/" + b + " = " + result); //for testing
        }
        return (int) result;
    }

    public static void aufgabe3() {
        System.out.printf("%n%nAufgabe 3:%n");

        //suggestion by IDE: try with ressource, so ...finally {scanner.close} won't be needed
        try (Scanner scanner3 = new Scanner(System.in)) {
            int n1_5 = eingabeInAufgabe3(scanner3, 1, 5);
            System.out.println(n1_5);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static int eingabeInAufgabe3(Scanner scanner, int from, int to)
            throws NoNumberException, NothingEnteredException, NumberIsNegativeException, OutOfRangeException {
        System.out.print("Gib eine Zahl von 1 bis 5 ein: ");
        String input = scanner.nextLine();

        //if is empty
        if (input.isEmpty())
            throw new NothingEnteredException();

        //if is not a number
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new NoNumberException();
        }

        //if number negative
        int number = Integer.parseInt(input);
        if (number < 0)
            throw new NumberIsNegativeException();

        //if number out of range
        if (number < from || number > to)
            throw new OutOfRangeException();

        return number;
    }

    public static void aufgabe4() {
        System.out.printf("%n%nAufgabe 4:%n");

        //suggestion by IDE: try with ressource, so ...finally {scanner.close} won't be needed
        try (Scanner scanner4 = new Scanner(System.in)) {
            int n = eingabeInAufgabe4(scanner4);
            System.out.println(n);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static int eingabeInAufgabe4(Scanner scanner)
            throws NoNumberException, NotAnIntegerException, NothingEnteredException {
        System.out.print("Gib eine Zahl von 1 bis 5 ein: ");
        String input = scanner.nextLine();

        //if is empty
        if (input.isEmpty())
            throw new NothingEnteredException();

        //if is not a number / make it a double
        double d;
        try {
            d = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new NoNumberException();
        }

        if (d % 1.0 != 0)
            throw new NotAnIntegerException();

        return (int) d;
    }
}
