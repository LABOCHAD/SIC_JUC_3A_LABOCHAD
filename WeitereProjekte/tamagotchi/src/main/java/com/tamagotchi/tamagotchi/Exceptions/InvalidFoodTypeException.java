package com.tamagotchi.tamagotchi.Exceptions;

public class InvalidFoodTypeException extends RuntimeException {
    public InvalidFoodTypeException(String message) {
        super(message);
    }

    public InvalidFoodTypeException () {

        super("Food not Found");
    }
}
