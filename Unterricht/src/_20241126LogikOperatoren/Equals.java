package _20241126LogikOperatoren;

public class Equals {
    public static void main(String[] args){

        //Vergleich von Referenzen
        String str1 = "Hallo";
        String str2 = "Hallo";

        System.out.println(str1 == str2); // Gibt true zurück, da beide auf denselben Speicherort verweisen

        int a = 10;
        int b = 10;
        System.out.println(a == b);  // Gibt true zurück, da die Werte gleich sind.

        //Vergleich von Objekten
        String strObj1 = new String("Hallo");
        String strObj2 = new String("Hallo");

        System.out.println(str1.equals(str2)); // Gibt true zurück, da die Inhalte gleich sind

    }
}
