package _20250131BackToDinos;

public class Triceratops extends Dinosaur{

    @Override
    public void hunt() {
        System.out.println("Triceratops hunts.");
    }

    @Override
    public void makeSound() {
        System.out.println("Triceratops roars.");

    }

    public void calcWeightAndSize(){
        System.out.println("Calculating and returning weight and size....");
    }


}
