package _20250314PflichtaufgabeCyberCrime;

import java.util.Scanner;

public class Start {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWhat is your name, detective?");
        String player = sc.nextLine();
        System.out.println("Scene: A storm rages outside the grand Reynard Mansion. " +
                           "\nThe police have sealed off the crime scene, " +
                           "but Detective " + player + " has been called in for an unusual investigation. " +
                           "\nThe victim: Mark Reynard, CEO of CyberShield Inc., found dead in his office." +
                           "\nDate: 2023-05-14 \nTime of death: 10:30 PM. \nPress ENTER to proceed.");
        if (sc.hasNextLine()) {
            System.out.println("Detective's Log:\n" +
                               "\"Mark Reynard is dead. Poisoned. The crime scene offers more questions than answers." +
                               "\n His laptop screen flickers with an unfinished email, and a shattered whiskey glass lies near his body." +
                               "\n Four suspects, each with a motive.\n My job: uncover the truth. My tool: code.\n" +
                               "\n" +
                               "Press ENTER to begin the investigation.");
        }
        sc.nextLine();
        if (sc.hasNextLine()) {
            System.out.println("You start by talking to the guests\n" +
                               "Sophia Reynard (The Wife)\n" +
                               "\n" +
                               "Sophia sits stiffly in the lounge, her hands wrapped around a half-empty cup of tea.\n" +
                               "\n" +
                               "\"Where were you at the time of the murder?\"\n" +
                               "\"I was in the garden. I needed some air. " +
                               "\nMark and I had been arguing about... personal matters." +
                               "\nWhen I came back in, he was already dead.\"\n" +
                               "\n" +
                               "\"Did Mark have any enemies?\"\n" +
                               "\"He was paranoid. " +
                               "\nAlways talking about corporate spies, hackers, betrayal. " +
                               "\nBut that was just business. I never thought...\"");
        }
        System.out.println("\nYou should start going though the house and investigate further ... " +
                           "\nGo to any next room and start by running it");


    }
}
