package _20250107Wiederholung811;

import myTools.UserInputScanner;

import java.util.Random;
import java.util.Scanner;

public class MathRandomVSRandomUtils {
    public static void main(String[] args) {
        Random random = new Random();

        //erzeugen beide jeweils eine double größer gleich 0, kleiner 1
        double d = Math.random(); // 0 <= d < 1
        double dd = random.nextDouble();

        int i = random.nextInt(); //erzeugt eine Zahl bis 2^32 = 4.294.967.296

        int n = 10;
        int ii = random.nextInt(n); //erzeugt eine Zahl von 1 bis n-1 (exklusive n)

        int x = 10;
        int y = 21;
        int iii = random.nextInt(x, y); // erzeugt eine Zahl von x bis y-1 (exklusive y) --> x <= iii < y

        //So und wie lasse ich jetzt Math.random() eine Zahl zwischen 10 und 30 erzeugen? Probieren wir's aus.
        int min = 10;
        int max = 30;
        int range = max - min + 1;
        int gegenprobe0 = (int) (0 * (max - min + 1)) + min; //
        int gegenprobe099 = (int) (0.99 * range) + min;
        System.out.println(gegenprobe0); //10
        System.out.println(gegenprobe099); //30

        for (; ; ) {
            int number = (int) (Math.random() * range) + min;
            int number1 = (int) (Math.random() * (max - min + 1)) + min;
            int number2 = (int) (Math.random() * (30 - 10 + 1)) + 10;
            System.out.println(number); //10-30
            UserInputScanner.pressReturnToContinue(new Scanner(System.in));
        }


    }
}
