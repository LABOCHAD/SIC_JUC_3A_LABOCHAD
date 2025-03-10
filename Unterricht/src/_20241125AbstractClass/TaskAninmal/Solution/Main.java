package _20241125AbstractClass.TaskAninmal.Solution;

// Main class to test the Animal, Dog, and Bird classes
/**
 * Main class to test the functionality of the Animal, Dog, and Bird classes.
 */
public class Main {
    public static void main(String[] args) {
        // Create instances of Dog and Bird
        Animal dog = new Dog("Bello");
        Animal bird = new Bird("Tweety");

        // Call methods on the Dog object
        dog.makeNoise();   // Output: Bello barks!
        dog.move();        // Output: Bello runs!

        // Call methods on the Bird object
        bird.makeNoise();  // Output: Tweety sings!
        bird.move();       // Output: Tweety flies!
    }
}
