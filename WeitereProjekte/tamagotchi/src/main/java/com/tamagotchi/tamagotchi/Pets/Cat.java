package com.tamagotchi.tamagotchi.Pets;

import javafx.scene.paint.Color;

public class Cat extends Pet {
    /**
     * Constructor to create a Pet object.
     *
     */
    public Cat(String petName) {
        super(petName);
    }

    @Override
    public Color getColor() {
        return Color.PLUM;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}
