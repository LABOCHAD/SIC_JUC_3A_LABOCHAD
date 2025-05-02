package com.tamagotchi.tamagotchi.Food;

public class Bone extends Food{
    /**
     * Constructor to create a Food.Bone object with name and nutritional value.
     */
    public Bone() {
        super("Food.Bone");
    }

    /**
     * Describes the bone.
     * Prints a description of the bone.
     */
    @Override
    public void describeFood() {
        System.out.println("This is a healthy Food.Bone, rich in calcium.");
    }
}