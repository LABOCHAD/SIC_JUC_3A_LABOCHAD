package _20241121MethodenOOP;

public class MatheAufgabe {
    public static void main(String[] args) {

        double num1 = 5.0;
        System.out.println(num1);

        double num2 = 3.0;
        System.out.println(num2);

        System.out.println(add(num1, num2));
        System.out.println(subtract(num1, num2));
        System.out.println(multiply(num1, num2));
        System.out.println(divide(num1, num2));
        System.out.println(modulo(num1, num2));
    }

    static double add(double x, double y) {
        return x + y;
    }

    static double subtract(double x, double y) {
        return x - y;
    }

    static double multiply(double x, double y) {
        return x * y;
    }

    static double divide(double x, double y) {
        if (y == 0) {
            System.out.println("Division with zero! Return Zero (instead of infinite).");
            return 0;
        } else {
            return x / y;
        }

    }

    static double modulo(double x, double y) {
        return x % y;
    }


}
