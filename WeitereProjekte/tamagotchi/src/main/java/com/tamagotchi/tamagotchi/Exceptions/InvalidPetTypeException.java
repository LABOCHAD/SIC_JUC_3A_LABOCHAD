package com.tamagotchi.tamagotchi.Exceptions;

public class InvalidPetTypeException extends Exception {
    public InvalidPetTypeException(String message) {
        super(message);
    }

    public InvalidPetTypeException() {
        super("Invalid pet!");
    }
}
