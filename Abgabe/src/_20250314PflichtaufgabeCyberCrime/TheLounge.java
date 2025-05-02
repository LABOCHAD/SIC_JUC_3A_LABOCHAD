package _20250314PflichtaufgabeCyberCrime;

import myTools.Color;

public class TheLounge {
    public static void main(String[] args) {
        DoNotLookInside usbStick = new DoNotLookInside(1);


        System.out.println("\nElizabeth adjusts her glasses, calm but irritated.\n" +
                           "\n" +
                           "\"Where were you at the time of the murder?\"\n" +
                           "\"In the lounge, reading. I prefer solitude.\"\n" +
                           "\n" +
                           "\"What was your last conversation with Mark about?\"\n" +
                           "\"Books, naturally. He borrowed one and never returned it. " +
                           "\nHardly motive for murder, wouldn’t you say?\"");

        System.out.println("\"You find an USB-Stick contains a passcode encrypted message in her purse.");


        //DONE (twice): use the use a brute force attack to crack the passcode to crack the USB-Stick
        // the passcode contains only numbers and is 5 digits long
        // the passcode can be compared using "usbStick.tryPasscode"

        //FIXME How do I remove all the "Wrong passcode!" outputs from the console, \b\r doesn't work
        // I may could fix it in your method, but I don't wanne cheat by looking in the file.
        bruteForceAttack(usbStick); //derived from former Task The Hack

        //while (!usbStick.tryPasscode(new Random().nextInt(10000,100000))) {} //shortest way

    }

    static void bruteForceAttack(DoNotLookInside usbStick){
        //DONE: update this method so it displays the real brute Force attempts
        System.out.println("Attempting to brute-force attack Elizabeth's pen drive...");
        int tryKey = 10000;
        do {
            tryKey++;
            if (tryKey > 99999) {
                System.out.println(Color.RED + "\nBrute Force Attack failed! No match found.\n" + Color.GREEN);
                return;
            }
        } while (!usbStick.tryPasscode(tryKey)); //FML the password is random :D

        System.out.println("\nMatch found!");
        System.out.println("The password was: " + tryKey);
        //Gosh, this must look ridiculous for a real hacker :D
    }
}
//help: a brute force attack can be made with a simple Random generator which generates a random 5 digits long number
