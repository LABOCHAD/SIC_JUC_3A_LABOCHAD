package com.tamagotchi.tamagotchi.Pets;

import javafx.scene.paint.Color;

public class Fish extends Pet {
    /**
     * Constructor to create a Pet object.
     *
     */
    public Fish(String petName) {
        super(petName);
    }

    @Override
    public Color getColor() {
        return Color.DODGERBLUE;
    }

    @Override
    public void makeSound() {
        System.out.println("Blubb blubb!");
    }
}
