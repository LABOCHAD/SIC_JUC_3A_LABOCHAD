package _20241205AufgabeExceptions;

import myOwnExceptions.NoNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TemperaturUmrechner {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        tryCelsiusZuFahrenheit();

        tryCelsiusZuKelvin();

        tryFahrenheitZuCelsius();

        scanner.close();
    }

    public static double getUserInput() throws NoNumberException {
        double d;
        try { //scanner not here as ressource, because makes trouble when been closed once.
            d = scanner.nextDouble();
        } catch (InputMismatchException e) {
            throw new NoNumberException("Keine gültige Zahl!");
        } finally {
            scanner.nextLine();
        }
        return d;
    }

    public static double celsiusZuFahrenheit(double celsius) throws UngueltigeTemperaturException {
        if (celsius < -273.15)
            throw new UngueltigeTemperaturException();
        //Formel: (x °C × 9/5) + 32 = y °F
        return (celsius * 9 / 5) + 32;
    }

    public static void tryCelsiusZuFahrenheit() {
        System.out.printf("%nUmrechnung von Celsius in Fahrenheit");
        try {
            System.out.printf("%nGib eine Temperatur in Celsius an: ");
            double celsius = getUserInput();
            double fahrenheit = celsiusZuFahrenheit(celsius);
            System.out.printf("%n%.2f °C sind %.2f° Fahrenheit.%n", celsius, fahrenheit);

        } catch (NoNumberException | UngueltigeTemperaturException e) {
            System.err.println(e.getMessage());
        }
    }

    public static double celsiusZuKelvin(double celsius) throws UngueltigeTemperaturException {
        if (celsius < -273.15)
            throw new UngueltigeTemperaturException();
        //Formel: x °C + 273,15 = y K
        return celsius + 273.15;
    }

    public static void tryCelsiusZuKelvin() {
        System.out.printf("%nUmrechnung von Celsius in Kelvin");
        try {
            System.out.printf("%nGib eine Temperatur in Celsius an: ");
            double celsius = getUserInput();
            double kelvin = celsiusZuKelvin(celsius);
            System.out.printf("%n%.2f °C sind %.2f Kelvin.%n", celsius, kelvin);

        } catch (NoNumberException | UngueltigeTemperaturException e) {
            System.err.println(e.getMessage());
        }
    }

    public static double fahrenheitZuCelsius(double fahrenheit) throws UngueltigeTemperaturException {
        if (fahrenheit < -459.67)
            throw new UngueltigeTemperaturException("Temperatur unter absolutem Nullpunkt von -459,67° Fahrenheit!");
        //Formel: (x °F − 32) × 5/9 = y °C
        return (fahrenheit - 32) * 5/9;
    }

    public static void tryFahrenheitZuCelsius() {
        System.out.printf("%nUmrechnung von Fahrenheit in Celsius");
        try {
            System.out.printf("%nGib eine Temperatur in Fahrenheit an: ");
            double fahrenheit = getUserInput();
            double celsius = fahrenheitZuCelsius(fahrenheit);
            System.out.printf("%n%.2f °F sind %.2f °C.%n", fahrenheit, celsius);

        } catch (NoNumberException | UngueltigeTemperaturException e) {
            System.err.println(e.getMessage());
        }
    }

}

