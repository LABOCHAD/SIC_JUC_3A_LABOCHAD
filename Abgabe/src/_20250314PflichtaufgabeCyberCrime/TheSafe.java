package _20250314PflichtaufgabeCyberCrime;

import myTools.ProgressAnimation;
import myTools.UserInputScanner;

import java.util.Scanner;

public class TheSafe {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("His friend Elizabeth said something about that he loved the the dual number system. " +
                           "\nI think if we can transform his birth year 1983 into the dual system\n");
        UserInputScanner.pressReturnToContinue(new Scanner(System.in));
        //DONE: optional
        //DONE: make 1983 a dual number
        // you can check your number with DoNotLookInside.safe();
        StringBuilder code = new StringBuilder();
        int i = 1983;
        while (i > 0) {
            code.append(i % 2);
            i /= 2;
            System.out.print("Found: " + code + ((i > 0) ? "\r" : "bin\n"));
            Thread.sleep(300);
        }
        UserInputScanner.pressReturnToContinue(new Scanner(System.in));
        System.out.println("Now lets reverse it according how to transform into dual system:\n" + code);
        code.reverse();
        UserInputScanner.pressReturnToContinue(new Scanner(System.in));
        ProgressAnimation.dotAnimateProcess("Try opening the safe with " + code);
        DoNotLookInside.safe(code.toString()); //String needed

    }
}

