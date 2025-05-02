package _20250314PflichtaufgabeCyberCrime;

import myTools.ProgressAnimation;
import myTools.UserInputScanner;

import java.util.Scanner;

public class TheKitchen {
    public static void main(String[] args) {
        DoNotLookInside database = new DoNotLookInside();


        System.out.println("\nDavid fidgets in the kitchen, avoiding eye contact.\n" +
                           "\n" +
                           "\"Where were you at the time of the murder?\"\n" +
                           "\"In the kitchen, making coffee. " +
                           "\nI wasn’t anywhere near Mark. I mean, I saw him earlier, but...\"\n" +
                           "\n" +
                           "\"Did Mark suspect anyone of wrong doing?\"\n" +
                           "\"Not that I know of. He kept his business affairs to himself.\"\n");


        System.out.println("\"A whiskey glass lies shattered on the floor. " +
                           "\nThe toxicology report confirms the poison was in the whiskey. " +
                           "\nWho touched the glass?\"\n");

        String[] guests = new String[]{"Sophia", "David", "Ghost", "Elizabeth"};
        //DONE: search in the database for the fingerprints of the guests and see if you find a match
        UserInputScanner.pressReturnToContinue(new Scanner(System.in));
        ProgressAnimation.fakeDotBarAnimateProcess("Searching for matches in database");

        for (String guest : guests) {
            for (String fingerprint : database.evidenceKitchen) {
                if (guest.equals(fingerprint)) {
                    System.out.printf("Match found! Guest: %s - (Fingerprint: %s)%n", guest, fingerprint );
                }
            }
        }

    }
}
//help: you need to iterate through the guests and compare it to the String[] database.evidenceKitchen
