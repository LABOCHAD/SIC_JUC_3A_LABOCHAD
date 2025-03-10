package _20241127MathRandom;

import java.util.Random;

public class RandomClassSolutions {
    public static void main(String[] args) {

        //Generierung einer Zufallszahl zwischen 0 und 100
        Random random = new Random();
        int randomInt = random.nextInt(101);  // Zufallszahl zwischen 0 und 100
        System.out.println("Die Zufallszahl ist: " + randomInt);

        //Generierung einer Zufallszahl zwischen -50 und 50
        Random random1 = new Random();
        int randomInt1 = random1.nextInt(101) - 50;  // Zufallszahl zwischen -50 und 50
        System.out.println("Die Zufallszahl zwischen -50 und 50 ist: " + randomInt1);

        //Generierung einer Zufallszahl mit einem Seed
        Random random3 = new Random(1234);  // Zufallsgenerator mit Seed 1234
        Random random2 = new Random(1234);  // Zufallsgenerator mit demselben Seed

        System.out.println("Zufallszahl 1: " + random3.nextInt(100));
        System.out.println("Zufallszahl 2: " + random2.nextInt(100));

        //Generierung von 5 zufälligen Ganzzahlen
        Random random4 = new Random();

        for (int i = 0; i < 5; i++) {
            int randomInt2 = random4.nextInt(100) + 1; // Zufallszahl zwischen 1 und 100
            System.out.println("Zufallszahl " + (i + 1) + ": " + randomInt2);
        }

        //Unser Test zu dem Seed
        Random randomTest1 = new Random(43);
        Random randomTest2 = new Random(43);
        Random randomTest3 = new Random(42);
        System.out.println(randomTest1.nextInt(23) +" "+ randomTest2.nextInt(23) +" "+ randomTest3.nextInt(23));

        //Extra-Task
        /*
        Schreiben Sie ein Java-Programm, das die folgenden Schritte ausführt:

        Erzeugen Sie 10 zufällige Ganzzahlen im Bereich von 1 bis 100 und speichern Sie diese in einem Array.
        Geben Sie alle diese Zahlen auf der Konsole aus.
        Berechnen Sie die Summe und den Durchschnitt der Zahlen und geben Sie diese aus.
         */
        Random rand = new Random();
        int[] numbers = new int[10]; // Array für 10 Zufallszahlen

        // Zufallszahlen generieren und in das Array einfügen
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100) + 1; // Zufallszahl im Bereich [1, 100]
        }

        // Zahlen ausgeben
        System.out.println("Die generierten Zufallszahlen sind:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println(); // Neue Zeile nach der Ausgabe

        // Summe der Zahlen berechnen
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        // Durchschnitt berechnen
        double average = sum / (double) numbers.length;

        // Ausgabe der Summe und des Durchschnitts
        System.out.println("Summe der Zahlen: " + sum);
        System.out.println("Durchschnitt der Zahlen: " + average);
    }
}
