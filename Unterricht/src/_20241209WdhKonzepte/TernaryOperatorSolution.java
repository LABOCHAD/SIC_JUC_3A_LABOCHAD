package _20241209WdhKonzepte;

public class TernaryOperatorSolution {
    public static void main(String[] args) {
        int number = 7;  // Beispielzahl

        // Using the ternary operator
        System.out.println("Using ternary operator:");
        checkEvenOddTernary(number);

        // Using if statement
        System.out.println("Using if statement:");
        checkEvenOddIf(number);
    }

    // Method using the ternary operator
    public static void checkEvenOddTernary(int num) {
        // The ternary operator checks if the number is even or odd
        String result = (num % 2 == 0) ? "even" : "odd";
        System.out.println("The number " + num + " is " + result + ".");
    }

    // Method using the if statement
    public static void checkEvenOddIf(int num) {
        // Using if-else statement to check even or odd
        if (num % 2 == 0) {
            System.out.println("The number " + num + " is even.");
        } else {
            System.out.println("The number " + num + " is odd.");
        }
    }
}
