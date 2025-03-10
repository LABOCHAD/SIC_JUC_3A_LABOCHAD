package _20241216Bis20WeekPrep1811;

//Frage 34
class Base {
    static {
        System.out.println("static 1");
    }
    static {
        System.out.println("Instance 1");
    }
    Base() {
        System.out.println("constructor base");
    }
}
class Derived extends Base {
    static {
        System.out.println("static 2");
    }
    static {
        System.out.println("Instance 2");
    }
    Derived(){
        System.out.println("constructor derived");
    }
}

//Frage 36
class Parent {
    void display(int a) {
        System.out.println("Parent: " +a);
    }
}
class Child extends Parent {
    void display(double a) {
        System.out.println("Child: " +a);
    }
}

public class Test {
    public static void main(String[] args) {
        //new Derived();

        Child obj = new Child();
        obj.display(6.0);

        Parent obj2 = new Child();
        obj2.display(10);
    }
}
