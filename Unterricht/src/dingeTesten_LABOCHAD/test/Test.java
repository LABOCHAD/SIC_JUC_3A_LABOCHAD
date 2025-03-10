package dingeTesten_LABOCHAD.test;

interface I {
    public void displayI();
}

class C2 {
    public void displayC2() {
        System.out.println("C2");
    }
}

class C1 extends C2 implements I {
    public void displayI() {
        System.out.println("C1");
    }
}

public class Test {
    public static void main(String[] args) {
        C2 obj1 = new C1();
        I obj2 = new C1();

        //C2 s = obj2; //C2 ist zwar Parent von C1, aber obj2 ist vom Typ 1, was nur C1 (Child) implementiert.
        //I t = obj1; //Da obj1 als C2 referiert ist (obgleich zur Lauzeitig C1) und C2 I nicht implementiert, geht das auch nicht.
   /*
        t.displayI();
        s.displayC2();*/
    }
}