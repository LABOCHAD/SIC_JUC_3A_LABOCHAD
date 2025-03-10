package dingeTesten_LABOCHAD;

import java.util.Scanner;

public class BaumVonNadine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to build your christmastree!");
        System.out.println("Choose your height:");
        int height = scanner.nextInt();
        String asterisk = "";
        for (int i = 0; i < height; i++) {
            asterisk = asterisk + "*";
            System.out.println(asterisk);
        }
        System.out.println("**\n\nMerry Christmas!"); // Nice one (Y)
    }
}
