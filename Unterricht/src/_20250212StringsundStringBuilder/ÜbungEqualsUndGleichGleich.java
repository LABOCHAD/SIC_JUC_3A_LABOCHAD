package _20250212StringsundStringBuilder;

public class ÜbungEqualsUndGleichGleich {
    public static void main(String[] args) {
        mitStringBuilder();
    }

    static void mitStringBuilder(){
        StringBuilder sb1 = new StringBuilder("Hallo Welt");
        StringBuilder sb2 = new StringBuilder("Hallo Welt");
        String beispiel = "Hallo Welt";

        //testen
        System.out.println(sb1.equals(beispiel));

        //Vergleiche die folgenden StringBuilder-Objekte mit == und .equals() und gib das Ergebnis (true/false) aus:

        System.out.println("Überprüfe: sb1 == sb2");
        System.out.println(sb1 == sb2); //false, weil unterschiedliche Obj.

        System.out.println("Überprüfe: sb1.equals(sb2)");
        System.out.println(sb1.equals(sb2)); //false, weil nicht gleiche Objekte (== in Obj, nur in String inhaltlich)

        System.out.println("Überprüfe: sb1.toString().equals(sb2.toString())");
        System.out.println(sb1.toString().equals(sb2.toString())); //true, weil hier Strings inhaltlich verglichen werden

        //Überprüfe dein Ergebnis in der IDE.
    }

    static void mitString(){
        String str1 = "Hallo Welt";

        String str2 = "Hallo Welt";

        String str3 = new String("Hallo Welt"); //.intern() macht es == mit str1

        //Vergleiche die folgenden String-Objekte mit == und .equals() und gib jeweils das Ergebnis (true/false) aus:

        System.out.println("Überprüfe: str1 == str2");
        System.out.println(str1 == str2); //true


        System.out.println("Überprüfe: str1.equals(str2)");
        System.out.println(str1.equals(str2)); //true

        System.out.println("Überprüfe: str1 == str3");
        System.out.println(str1 == str3); //false, wäre true, wenn siehe oben bei str3

        System.out.println("Überprüfe: str1.equals(str3)");
        System.out.println(str1.equals(str3)); //true

        //Überprüfe dein Ergebnis in der IDE.
    }
}
