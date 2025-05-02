package com.tamagotchi.tamagotchi.Pets;

import javafx.scene.paint.Color;

public class Dog extends Pet {
    /**
     * Constructor to create a Pet object.
     *
     */
    public Dog(String petName) {
        super(petName);
    }

    @Override
    public Color getColor() {
        return Color.ORANGERED;
    }

    @Override
    public void makeSound() {
        System.out.println("Wuff!");
    }
}