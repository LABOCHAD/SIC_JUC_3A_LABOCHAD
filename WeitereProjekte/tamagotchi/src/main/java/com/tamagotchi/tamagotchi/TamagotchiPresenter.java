package com.tamagotchi.tamagotchi;

import com.tamagotchi.tamagotchi.Exceptions.InvalidFoodTypeException;
import com.tamagotchi.tamagotchi.Exceptions.InvalidPetStatusException;
import com.tamagotchi.tamagotchi.Exceptions.InvalidPetTypeException;
import com.tamagotchi.tamagotchi.Pets.Cat;
import com.tamagotchi.tamagotchi.Pets.Dog;
import com.tamagotchi.tamagotchi.Pets.Fish;
import javafx.scene.paint.Color;

import java.util.Random;

public class TamagotchiPresenter {
private Random rd = new Random();
    private TamagotchiModel model;
    private TamagotchiView view;

    /**
     * Constructor to initialize the TamagotchiPresenter with a specific model and view.
     * @param model The model to be used by the presenter.
     */
    public TamagotchiPresenter(TamagotchiModel model) {
        this.model = model;
    }

    /**
     * Sets the view for the presenter. This allows the presenter to update the view.
     * @param view The view to be used by the presenter.
     */
    public void setView(TamagotchiView view) {
        this.view = view;
    }

    /**
     * Makes the pet sleep.
     * @param pet The value of pet.
     */
    public void sleepAction(String pet, Random rd) throws InvalidPetStatusException {
        model.sleep();
        view.setHealth(rd.nextInt(40));
        view.setPlay(rd.nextInt(20)-40);
        updateView(pet + " is sleeping.", Color.GRAY);
    }

    /**
     * Makes the pet wake up.
     * @param pet The value of pet.
     */
    public void wakeUpAction(String pet) {
        Color petColor = model.wakeUp();
        updateView(pet + " is awake.", petColor);
    }

    /**
     * Feeds the pet with a specific food.
     * @param food The food to feed the pet.
     */
    public void feedAction(String food, Random rd) throws InvalidPetStatusException,  InvalidFoodTypeException {
        model.feed(food);
        view.setHealth(rd.nextInt(25));
        //Wir benötigen eine Methode updateView(String message),
        // die es uns ermöglicht ohne eine Farbe die view zu updaten.
        // Was müssen wir in TamagotchiView dann ebenfalls ergänzen?
        updateView("Feeding: " + food);
    }

    /**
     * Changes the pet type.
     * @param pet The new pet type to be used.
     */
    public void changePet(String pet) throws InvalidPetTypeException, InvalidPetStatusException {
        switch (pet) {
            case "Cat":
                Cat cat = new Cat(pet);
                model.setPet(cat);
                updateView("Switched to Cat. \n Miaaaauuu", cat.getColor());
                break;
            case "Dog":
               Dog dog = new Dog(pet);
                model.setPet(dog);
                updateView("Switched to Dog. \n Wuff wuff", dog.getColor());
                break;
            case "Fish":
                Fish fish = new Fish(pet);
                model.setPet(fish);
                updateView("Switched to Dog. \n Blubb blubb", fish.getColor());
                break;
            // Ergänze hier die anderen Tiere analog zur Katze
            default:
                throw new InvalidPetTypeException();
        }
        view.setHealth(-50);
        view.setPlay(-20);
    }

    /**
     * Updates the view with the latest pet information.
     * @param message The message to display (e.g., pet's sound).
     * @param petColor The color representing the pet.
     */
    private void updateView(String message, Color petColor) {
        view.updateView(message, petColor);
    }
    private void updateView(String message) {
        updateView(message, model.getPet().getColor());
    }
}
