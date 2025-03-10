package _20241209WdhKonzepte;

public class AufgabeTernär_Und_If_GeradeUngerade {
    public static void main(String[] args) {
        int zahl = 5;
        ternärerAbgleich(zahl);
        ifAbgleich(zahl);
    }

    //kompaktere Variante. Ternärer Operator eignet sich zum Beschreiben von Werten, weniger für ganze Befehle.
    public static void ternärerAbgleich(int zahl) {
        String zahlIst = (zahl % 2 == 0) ? "gerade." : "ungerade."; //sout in die Zweige geht schon nicht mehr
        System.out.println("Die Zahl " + zahl + " ist " + zahlIst);
    }

    //Besser lesbare Variante, keine weitere Variable nötig
    public static void ifAbgleich(int zahl){
        System.out.printf("%nDie Zahl %d ist ", zahl);
        if (zahl % 2 ==0)
            System.out.print("gerade.");
        else
            System.out.print("ungerade.");
    }
}
