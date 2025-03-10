package dingeTesten_LABOCHAD;
// der Aufruf der Methode print wird hier durch das Construction chaining auf die zu erzeugende Instanz C bezogen.
public class ChainingConstructionMethodCall {
    static class A {
        public A() {
            System.out.print("A ");
            print();
        }

        void print() {
            System.out.print("A-print ");
        }
    }

    static class B extends A {
        public B(int x) {
            System.out.print("B ");
            print();
        }

        void print() {
            System.out.print("B-print ");
        }
    }

    static class C extends B {
        public C() {
            super(5);
            System.out.print("C ");
            print();
        }

        void print() {
            System.out.print("C-print ");
        }
    }

    public static void main(String[] args) {
        C c = new C();
    }
}
