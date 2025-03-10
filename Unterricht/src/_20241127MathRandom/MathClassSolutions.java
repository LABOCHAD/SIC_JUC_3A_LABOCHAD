package _20241127MathRandom;

public class MathClassSolutions {
    public static void main(String[] args) {

        //    Berechnung des absoluten Wertes einer Zahl
        int number = -7;
        System.out.println("Der absolute Wert von " + number + " ist: " + Math.abs(number));

        //    Die Quadratwurzel einer Zahl berechnet
        double number2 = 16;
        System.out.println("Die Quadratwurzel von " + number2 + " ist: " + Math.sqrt(number2));

        //    Die Potenz einer zufallsgenerierten Zahl berechnet
        int randomInt = (int)(Math.random() * 10) + 1; // Zufallszahl zwischen 1 und 10
        double result = Math.pow(randomInt, 2); // Potenzierung mit 2
        System.out.println("Die Zufallszahl ist: " + randomInt);
        System.out.println("Die Zahl " + randomInt + " hoch 2 ergibt: " + result);

        //    Eine Zufallszahl zwischen 25 und 50 generiert - ACHTUNG: Nicht verwechseln mit der Random.class!!!
        int randomInt2 = (int) (Math.random() * 26) + 25;  // (max - min + 1) + min

        System.out.println("Die Zufallszahl zwischen 25 und 50 ist: " + randomInt2);
    }

}
