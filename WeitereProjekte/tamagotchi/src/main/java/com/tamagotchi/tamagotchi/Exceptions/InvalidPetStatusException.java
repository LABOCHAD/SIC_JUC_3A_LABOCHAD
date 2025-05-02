package com.tamagotchi.tamagotchi.Exceptions;

public class InvalidPetStatusException extends Exception {
    public InvalidPetStatusException(String message) {
        super(message);
    }

    public InvalidPetStatusException() {
        super("Invalid status!");
    }
}