package _20241209WdhKonzepte;

public class AufgabeSchleifen_EinsBisZehn {
    public static void main(String[] args) {
        System.out.println();
        ansatzFor();
        ansatzDoWhile();
    }

    //Zum Zählen, besonders in einer zuvor schon bekannten Range macht die For mehr Sinn
    //Des Weiteren ist Kopfgesteuert sinnvoll,
    //wenn die Bedingung bereits bei Eintritt erfüllt sein muss. (Hier Zahl < 11)
    public static void ansatzFor(){
        System.out.println("Kopfgesteuert: ");
        for (int i = 1; i < 11; i++){
            System.out.println(i);
        }
        System.out.println();
    }

    //Hier eher sinnvoll, wenn die Bedingung erst nach Erstausführung geprüft werden soll
    //oder gar in ihr erst zustande kommt (wie eine Menüauswahl).
    //Das Zählen ist hier also eher praxisfremd (konstruiert).
    public static void ansatzDoWhile(){
        System.out.println("Fußgesteuert: ");
        int i=1;
        do {
            System.out.println(i);
            i++;
        } while (i < 11);
    }

}
