package com.tamagotchi.tamagotchi;

import com.tamagotchi.tamagotchi.Exceptions.InvalidFoodTypeException;
import com.tamagotchi.tamagotchi.Food.Bone;
import com.tamagotchi.tamagotchi.Food.Fish;
import com.tamagotchi.tamagotchi.Food.Food;
import com.tamagotchi.tamagotchi.Food.Milk;
import com.tamagotchi.tamagotchi.Pets.Pet;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class TamagotchiModel {



    private Pet pet;
    private Map<String, Food> foodList;

    public TamagotchiModel(Pet pet) {
        this.pet = pet;
        this.foodList = new HashMap<>();

        // Add different food items using inheritance
        // Hier müssen die anderen Foods hinzugefügt werden. Das vordere ist der Key, das zweite das Value.
        foodList.put("Fish", new Fish());
        foodList.put("Bone", new Bone());
        foodList.put("Milk", new Milk());
    }

    // Implement Action interface methods

    public void sleep() {
        pet.sleep();
    }

    public Color wakeUp() {
        return pet.wakeUp();
    }

    public void feed(String foodName) throws  InvalidFoodTypeException{
        //Dies kann auch mit einer Exception gelöst werden. Wie?
        Food food = foodList.get(foodName);
        if (food != null) {
            pet.feed(food);
        } else {
            throw new InvalidFoodTypeException();
        }

    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }
}
