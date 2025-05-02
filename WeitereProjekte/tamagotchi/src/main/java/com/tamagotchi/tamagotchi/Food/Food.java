package com.tamagotchi.tamagotchi.Food;
//TImplementiere das andere Food analog zum Fish. Es fehlen Bone und Milk
public abstract class Food {
    protected String name;

    /**
     * Constructor to create a Food.Food object.
     * @param name The name of the food.
     */
    public Food(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the food.
     * @return The name of the food.
     */
    public String getName() {
        return name;
    }

    /**
     * Abstract method to describe the food.
     * This will be implemented in specific food types.
     */
    public abstract void describeFood();

    @Override
    public String toString() {
        return name;
    }
}
