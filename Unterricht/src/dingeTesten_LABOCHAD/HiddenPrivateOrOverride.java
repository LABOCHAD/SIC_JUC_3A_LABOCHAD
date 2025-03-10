package dingeTesten_LABOCHAD;

public class HiddenPrivateOrOverride {
    public static void main(String[] args) {
    A obj = new B();
    //obj.method();
}
}
class A {
    private void method() { System.out.println("A"); }
}
class B extends A {
    void method() { System.out.println("B"); }
}

