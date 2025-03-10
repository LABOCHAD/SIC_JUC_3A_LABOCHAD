package _20250131BackToDinos;

public class Pterodactylus extends Dinosaur implements FlyingAbility{
    @Override
    public void hunt() {
        System.out.println("Pterodactylus hunts");
    }

    @Override
    public void fly() {
        System.out.println("Pterodactylus flies.");
    }
}
