package _20250212StringsundStringBuilder;

import java.util.Scanner;

public class AufgabeMitStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Aufgabe 1
        System.out.println("Gebe einen beliebigen Satz ein:");
        String satz = sc.nextLine();

        System.out.println("Gebe ein zu suchendes Wort ein:");
        String wort = sc.nextLine();


        //Aufgabe 2

        //◦Prüfe, ob der Satz mit „Hallo“ beginnt *oder* mit „!“ endet.
        if (satz.startsWith("Hallo"))
            System.out.println("Satz beginnt mit Hallo: ja"); // war mal: (satz.startsWith("Hallo") ? "ja" : "nein")
        else
            System.out.println("Satz endet mit !: " + (satz.endsWith("!") ? "ja" : "nein"));

        //◦Prüfe, ob der Satz das gesuchte Wort enthält (case-insensitive).
        //Gibt es auch eine Möglichkeit contains nicht case sensitive anzuwenden?
        // -> (satz.toLowerCase().contains(wort.toLowerCase()) #Danke an Thorsten Schütt
        System.out.println("Gesuchtes Wort im Satz gefunden: " + (satz.toLowerCase().contains(wort.toLowerCase()) ? "ja" : "nein"));

        //◦Ersetze alle Leerzeichen im Satz durch Unterstriche _ und gib den veränderten Satz aus.
        System.out.println("Ersetze Leerzeichen durch Unterstriche: " + satz.replace(" ", "_"));

        //◦Ermittle die Länge des Satzes und gib sie aus.
        System.out.println("Länge des Satzes: " + satz.length());

        //◦Falls das gesuchte Wort enthalten ist, gib die Position des ersten Auftretens aus.
        // Falls nicht, gib eine entsprechende Meldung aus.
        if (satz.contains(wort))
            System.out.println("Startindex des gesuchten Wortes im Satz: " + satz.indexOf(wort));
        else
            System.out.println("Da das Wort nicht vorkommt, gibt es keine Position, quasi -1.");

        //◦Schneide den Satz so zu, dass nur die ersten 10 Zeichen übrig bleiben, und gib das Ergebnis aus.
        System.out.println("Gebe nur die ersten 10 Zeichen zurück (oder weniger, wenn kürzer):");
        if (satz.length() > 10)
            System.out.println(satz.substring(0, 10)); //index 9 ist das 10. Zeichen, 10 also als exklusiv richtig
        else
            System.out.println("Der Satz ist kürzer:" + satz);

        //◦Entferne mögliche Leerzeichen am Anfang und Ende des Satzes und gib das bereinigte Ergebnis aus.
        System.out.println("Entferne alle freihängenden Leerzeichen (vorne und hinten), falls vorhanden:");
        System.out.println(satz.trim());

        //◦Gib das erste Zeichen des Satzes aus
        System.out.println("Erstes Zeichen des Satzes: " + satz.charAt(0));

        sc.close();
    }


}
