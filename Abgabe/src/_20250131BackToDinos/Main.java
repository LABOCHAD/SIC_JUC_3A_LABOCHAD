package _20250131BackToDinos;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Dinosaur> dinos = new ArrayList<>();
        dinos.add(new Pterodactylus());
        dinos.add(new Tyrannosaurus());
        dinos.add(new Triceratops());
        dinos.add(new Velociraptor());

        for (Dinosaur d : dinos){
            System.out.println("\n____________________________");
            d.describe();
            d.hunt();
            d.makeSound();
            d.eat();
            d.sleep();
            d.move();
        }
    }
}
