package _20250314PflichtaufgabeCyberCrime;

import myTools.ProgressAnimation;
import myTools.UserInputScanner;

import java.time.LocalDateTime;
import java.util.Scanner;

public class TheOffice {
    public static void main(String[] args) {
        DoNotLookInside findlogs = new DoNotLookInside();

        System.out.println("You go to the next person\n" +
                           "Axel \"Ghost\" Nakamura (The Hacker)\n" +
                           "\n" +
                           "Axel leans back in a chair in the basement, arms crossed.\n" +
                           "\n" +
                           "\"Where were you at the time of the murder?\"\n" +
                           "\"Down here. I was setting up a security test for Mark’s systems. " +
                           "\nWe had a deal — he’d pay me to try and break in. " +
                           "\nBut I didn’t touch his files. I swear.\"\n" +
                           "\n" +
                           "\"Did you notice anything unusual?\"\n" +
                           "\"Yeah. Someone else logged in at 10:30 PM. Wasn’t me. Logs don’t lie.\"");


        System.out.println("\n\"Mark’s laptop is still open. " +
                           "\nThe last login entry shows activity at 10:30 PM. " +
                           "\nBut who accessed it?\"");

        //DONE: search in the logs "findlogs.logs" for the Date and time of the murder


        System.out.println("\nThere is a Safe behind a Painting, I'll guess there is not the clue in it, " +
                           "\nbecause it was not opened at that killer evening, " +
                           "\nbut maybe I will find some Information on why he was killed.\n");
        UserInputScanner.pressReturnToContinue(new Scanner(System.in));
        ProgressAnimation.rotatingAnimateProcess("Searching in logs for 05/14/2023 - 10:30 PM");
        //                           "\nDate: 2023-05-14 \nTime of death: 10:30 PM.
        LocalDateTime deathTime = LocalDateTime.of(2023, 5, 14, 22, 30); //22:30 = 10:30 PM
        String value = findlogs.logs.get(deathTime);
        System.out.println("Username associated to this activity: " + value); //David
        //that was funny, nice idea :)
    }
}
//help: the date and time is written in the start. just go through the hashmap of logs
//the function of a hashmap(like a list) you need is get(key), the key is the date and time, and it returns a Value(name of a suspect)