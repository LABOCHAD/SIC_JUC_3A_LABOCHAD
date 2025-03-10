package _20241127MathRandom;

import java.util.Random;

public class RandomUtil {
    public static void main(String[] args) {
        //1
        Random rand = new Random();
        System.out.println("\nAufgabe 1:");
        System.out.println("Generiere Zahl zwischen 0 und 100: " + rand.nextInt(101)); //0-100

        //2
        System.out.println("\nAufgabe 2:");
        System.out.println("Generiere Zahl zwischen -50 und 50: " + (rand.nextInt(100)- 50)); //-50 - 50 --> Range +- Shift
        System.out.println("Generiere Zahl zwischen -50 und 50: " + rand.nextInt(-50,50)); //(min, max+1)

        //3
        System.out.println("\nAufgabe 3:");
        Random randSeeded1 = new Random(50);
        Random randSeeded2 = new Random(50);
        Random randSeeded3 = new Random(50);
        System.out.println("Generiere Zahl mit Seed (50): " + randSeeded1.nextInt(100)); //0-99
        System.out.println("Generiere Zahl mit Seed (50): " + randSeeded2.nextInt(100)); //0-99
        System.out.println("Generiere Zahl mit Seed (50): " + randSeeded3.nextInt(90)); //0-99

        //4
        System.out.println("\nAufgabe 4:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Generiere Zufallszahl Nummer " + i + ": " + rand.nextInt(100)); //0-99
        }

        //Zusatz
        System.out.println("\nAufgabe Zusatz");
        int[] tenRands = new int[10];
        int summe = 0;
        float durchschnitt;
        for (int i = 0; i < 10; i++) {
            tenRands[i] = rand.nextInt(101);
            System.out.println("Generiere Zufallszahl Nummer " + (i+1) + ": " + rand.nextInt(101)); //0-100 //i+1 ohne Klammer macht 01 statt 1
            summe += tenRands[i];
        }

        System.out.println("\nSumme aller Zahlen: "+ summe);
        durchschnitt = summe / (float) tenRands.length;
        System.out.println("Durchschnitt aller Zahlen: " + durchschnitt);
    }
}
