package _20241125AbstractClass.TaskAninmal.Solution;

// Abstract class Animal
/**
 * Abstract class representing an animal.
 * This class defines the basic structure for all animal types.
 */
abstract class Animal {
    String name;

    /**
     * Constructor for the Animal class.
     *
     * @param name The name of the animal.
     */
    public Animal(String name) {
        this.name = name;
    }

    /**
     * Abstract method for making noise.
     * Subclasses must implement this method to define the sound an animal makes.
     */
    public abstract void makeNoise();

    /**
     * Abstract method for moving.
     * Subclasses must implement this method to define how the animal moves.
     */
    public abstract void move();
}

