package _20250210GarbageCollector.stacks;

import java.util.Arrays;

class A{
    A(){
        System.out.println("Hallo ich bin Klasse A");
    }
}

class B extends A{
    B(){
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
        System.out.println("Hallo ich bin Klasse B");
    }
}

class C extends B{
    C(){
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
        System.out.println("Hallo ich bin Klasse C");
    }
}
public class StackExample {
    public static void main(String[] args) {
        C c = new C();
    }
}
