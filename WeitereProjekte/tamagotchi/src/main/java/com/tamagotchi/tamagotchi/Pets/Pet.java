package com.tamagotchi.tamagotchi.Pets;

import com.tamagotchi.tamagotchi.Food.Food;
import javafx.scene.paint.Color;
//Implementiere die anderen Tiere Dog und Fish analog zur Katze
/**
 * The Pet class represents a generic pet. All specific pet types (Cat, Dog, Rabbit) will inherit from this class.
 */
public abstract class Pet {
    protected boolean isSleeping;
    public String lastMeal;
    protected String petName;

    /**
     * Constructor to create a Pet object.
     */
    public Pet(String petName) {
        this.petName = petName;
        this.isSleeping = false;
        this.lastMeal = "";
    }

    /**
     * Get the color of the pet.
     * @return Pet color.
     */
    public abstract Color getColor();

    /**
     * Makes the pet sleep.
     */
    public void sleep() {
        isSleeping = true;
        System.out.println(this.getPetName() + " is sleeping.");
    }

    /**
     * Makes the pet wake up.
     * @return Returns the color of the pet.
     */
    public Color  wakeUp() {
        isSleeping = false;
        System.out.println(getPetName() + " is awake.");
        return getColor();
    }

    public void feed(Food food) {
        this.lastMeal = food.toString();
    }

    /**
     * Makes the pet produce a sound (meow, woof, etc.).
     */
    public abstract void makeSound();

    /**
     * Gets the name of the pet.
     * @return The name of the pet.
     */
    public String getPetName() {
        return petName;
    }
}
