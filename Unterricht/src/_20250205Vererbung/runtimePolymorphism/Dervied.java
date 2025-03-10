package _20250205Vererbung.runtimePolymorphism;

class A {
    void test() {
        System.out.println("Base ");

    }
}


class B extends A {
    void test() {
        System.out.println("DerivedA ");
    }
}

class C extends B {
    void test() {
        System.out.println("DerivedB ");
    }

    public static void main(String[] args) {
        A b1 = new B();
        A b2 = new B();
        A b3 = new B();

        A b = new A();
        B c = (B)b;

        b1 = (A) b3;
        A b4 = (B) b3;
        b1.test();
        b4.test();
    }
}
