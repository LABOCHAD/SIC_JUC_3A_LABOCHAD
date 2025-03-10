package _20241125AbstractClass.TaskAninmal.Solution;

// Subclass Dog, which extends Animal
/**
 * The Dog class extends the Animal class and represents a dog.
 * It provides implementations for the abstract methods makeNoise and move.
 */
class Dog extends Animal {

    /**
     * Constructor for the Dog class.
     *
     * @param name The name of the dog.
     */
    public Dog(String name) {
        super(name);
    }

    /**
     * Implementation of the makeNoise method for the dog.
     * Prints a message indicating the dog is barking.
     */
    @Override
    public void makeNoise() {
        System.out.println(name + " barks!");
    }

    /**
     * Implementation of the move method for the dog.
     * Prints a message indicating the dog is running.
     */
    @Override
    public void move() {
        System.out.println(name + " runs!");
    }
}
