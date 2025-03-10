package dingeTesten_LABOCHAD;

interface Interface1 {
    default void method(){}
}

interface Interface2 {
    void method();
}

interface Interface3 extends Interface1, Interface2 {
    @Override
    default void method() { //gut zu wissen, mehrfach-erbende Interfaces müssen die abstracts mitnehmen
        Interface1.super.method();
    }
}

class c1 implements Interface1 {}
class c2 implements Interface2 {
    @Override
    public void method() {

    }
}
class c3 extends c1{}
//class c3 extends c1, c2{}
