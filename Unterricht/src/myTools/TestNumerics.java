package myTools;

import java.util.Scanner;

public class TestNumerics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i;
        float f;
        double d;

        //Integer
        System.out.printf("%nEnter positive integer: ");
        i = UserInputScanner.getIntOnlyPos(scanner);
        System.out.println(i);

        System.out.printf("%nEnter positive integer from 1 to 5: ");
        i = UserInputScanner.getIntOnlyPosRanged(scanner,1, 6);
        System.out.println(i);

        System.out.printf("%nEnter integer: ");
        i = UserInputScanner.getInt(scanner);
        System.out.println(i);

        //Float
        System.out.printf("%nEnter positive float: ");
        f = UserInputScanner.getFloatOnlyPos(scanner);
        System.out.println(f);

        System.out.printf("%nEnter float: ");
        f = UserInputScanner.getFloat(scanner);
        System.out.println(f);

        //Double
        System.out.printf("%nEnter positive double: ");
        d = UserInputScanner.getDoubleOnlyPos(scanner);
        System.out.println(d);

        System.out.printf("%nEnter double: ");
        d = UserInputScanner.getDouble(scanner);
        System.out.println(d);


        scanner.close();
    }


}
