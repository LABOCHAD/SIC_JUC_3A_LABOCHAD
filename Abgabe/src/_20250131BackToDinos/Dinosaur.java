package _20250131BackToDinos;

public abstract class Dinosaur implements Creature {
    private int weight;
    private int size;

    public int getWeight() {
        return weight;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void eat() {
        System.out.println("Dinosaur eats.");
    }

    @Override
    public void sleep() {
        System.out.println("Dinosaur sleeps.");
    }

    @Override
    public void move() {
        System.out.println("Dinosaur moves.");
    }

    @Override
    public void makeSound() {
        System.out.println("Dinosaur roars.");
    }

    public abstract void hunt();

    public void calcWeightAndSize(){
        //could better put be here, then in every subclass.
        //I addressed my confusion about this subtask in the tutorium and got told to use a simple textoutput
        System.out.println("Calculating and returning weight and size....");
    }

    public void describe(){
        System.out.println("Description: "+ this.getClass().getName().split("\\.")[1]);
    }
}
