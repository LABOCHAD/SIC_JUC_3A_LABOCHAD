package _20241209WdhKonzepte;

public class LoopsSolutions {
    public static void main(String[] args) {
        // Calling the method for the head-controlled loop (for loop)
        System.out.println("Head-controlled loop:");
        headControlledLoop();

        // Calling the method for the foot-controlled loop (do-while loop)
        System.out.println("Foot-controlled loop:");
        footControlledLoop();
    }

    // Method for head-controlled loop (using a for loop)
    public static void headControlledLoop() {
        // The condition is checked before each iteration
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println(); // Line break after the loop
    }

    // Method for foot-controlled loop (using a do-while loop)
    public static void footControlledLoop() {
        int j = 1;
        // The loop is executed at least once before checking the condition
        do {
            System.out.print(j + " ");
            j++;
        } while (j <= 10);
        System.out.println(); // Line break after the loop
    }
}
