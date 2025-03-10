package _20250107Wiederholung811.Lernplan.Lernfortschritt811;

/*
Legende und erwartete Ergebnisse

Scope	        unbelegt	Ergebnis	belegt	Ergebnis	Lebensspanne/Sichtbarkeit
------------------------------------------------------------------------
static	        sLeer	    0	        sVoll	1	        Klasse
static block    sbLeer	    0	        sbVoll	1	        Klasse
init block	    ibLeer	    0	        ibVoll	1	        Klasse
instance	    iLeer	    0	        iVoll	1	        Instanz
methode	        mLeer	    Fehler	    mVoll	1	        Methode

 */

public class VariablesScopesAndLifespan {
    static int sLeer;
    static int sVoll = 1;
    int iLeer;
    int iVoll = 1;

    static {
        int sbLeer;
        int sbVoll = 1;

        //System.out.println("Teste statisch-Block leer: " + sbLeer); //Fehler
        System.out.println("Teste statisch-Block voll: " + sbVoll); //1
    }

    {
        int ibLeer;
        int ibVoll = 1;
        //System.out.println("Teste Initial block leer: " + ibLeer); //Fehler
        System.out.println("Teste Initial block voll: " + ibVoll); //1
    }

    VariablesScopesAndLifespan() {
    }

    ;

    public static void main(String[] args) {
        VariablesScopesAndLifespan instance = new VariablesScopesAndLifespan(); //auch diese ist nur hier sichtbar

        System.out.println("Teste statisch leer: " + sLeer); //0
        System.out.println("Teste statisch voll: " + sVoll); //1

/*        System.out.println("Teste statisch-Block leer: " + sbLeer); //Fehler
        System.out.println("Teste statisch-Block voll: " + sbVoll); //Fehler

        System.out.println("Teste Initial block leer: " + ibLeer); //Fehler
        System.out.println("Teste Initial block voll: " + ibVoll); //Fehler*/

        System.out.println("Teste Instanzvariable leer: " + instance.iLeer); //0
        System.out.println("Teste Instanzvariable voll: " + instance.iVoll); //1

/*        System.out.println("Teste Methodenvariable leer: " + mLeer; //Fehler
        System.out.println("Teste Methodenvariable voll: " + mVoll); //hier Fehler, sonst 1*/

    }

    static void test() {
        int mLeer;
        int mVoll = 1;
        //System.out.println("Teste Methodenvariable leer: " + mLeer; //Fehler
        System.out.println("Teste Methodenvariable voll: " + mVoll); //1
    }
}
