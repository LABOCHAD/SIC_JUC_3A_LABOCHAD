package com.tamagotchi.tamagotchi.Food;

public class Milk extends Food{
    /**
     * Constructor to create a Food.Milk object with name and nutritional value.
     */
    public Milk() {
        super("Food.Milk");
    }

    /**
     * Describes the milk.
     * Prints a description of the milk.
     */
    @Override
    public void describeFood() {
        System.out.println("This is a healthy Food.Milk, rich in potassium.");
    }
}