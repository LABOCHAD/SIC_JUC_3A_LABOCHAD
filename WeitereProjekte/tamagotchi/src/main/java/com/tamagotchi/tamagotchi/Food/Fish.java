package com.tamagotchi.tamagotchi.Food;

public class Fish extends Food{
    /**
     * Constructor to create a Food.Fish object with name and nutritional value.
     */
    public Fish() {
        super("Food.Fish"); // Food.Fish has 8 nutritional value
    }

    /**
     * Describes the fish.
     * Prints a description of the fish.
     */
    @Override
    public void describeFood() {
        System.out.println("This is a healthy Food.Fish, rich in Omega-3.");
    }
}
