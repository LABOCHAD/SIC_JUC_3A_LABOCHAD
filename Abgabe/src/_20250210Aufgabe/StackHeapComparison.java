package _20250210Aufgabe;

class Person1 {
    int age;
}

public class StackHeapComparison {
    public static void changeValue(int num) {
        num = 50; // This change does not affect the original variable
    }

    public static void changePersonAge(Person1 p) {
        p.age = 50; // This change affects the original object
    }

    public static void main(String[] args) {
        int x = 10;
        Person1 person = new Person1();
        person.age = 30;

        changeValue(x);
        changePersonAge(person);

        System.out.println("Primitive type value: " + x); // Still 10
        System.out.println("Person's age: " + person.age); // Changed to 50
    }
}

/* Aufagbe 1
    Explain why x does not change but person.age does.

    Aufagbe 2
    Modify the Person object reference inside the method and observe if the change is reflected.

    Aufgabe 3
    Experiment with final keyword and analyze its effect.
 */