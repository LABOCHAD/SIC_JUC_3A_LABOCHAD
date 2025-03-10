package _20241125AbstractClass.TaskAninmal.Solution;

// Subclass Bird, which extends Animal
/**
 * The Bird class extends the Animal class and represents a bird.
 * It provides implementations for the abstract methods makeNoise and move.
 */
class Bird extends Animal {

    /**
     * Constructor for the Bird class.
     *
     * @param name The name of the bird.
     */
    public Bird(String name) {
        super(name);
    }

    /**
     * Implementation of the makeNoise method for the bird.
     * Prints a message indicating the bird is singing.
     */
    @Override
    public void makeNoise() {
        System.out.println(name + " sings!");
    }

    /**
     * Implementation of the move method for the bird.
     * Prints a message indicating the bird is flying.
     */
    @Override
    public void move() {
        System.out.println(name + " flies!");
    }
}
