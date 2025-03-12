package _20250312AufgabeTheHack;
//my Name catchy 4 dis project: DaP3n3tr4t0R :D
import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class TheHack {
    public static void main(String[] args) throws InterruptedException {
        DoNOTlookInside doNotLookInside = new DoNOTlookInside();
        Scanner input = new Scanner(System.in);
        System.out.println(Color.GREEN);

        System.out.println("Starting WiFi Hack...");
        fakeBruteForceAnimation("WiFi Password");

        //TODO: brut-Force method here
        String wifiPassword = "";
        if (wifiPassword.equals(doNotLookInside.getWifiPW())) {
            System.out.println("WiFi Access Granted! Connecting to the network...");
            Thread.sleep(2000);

            System.out.println("Scanning local machine for vulnerabilities...");
            fakeBruteForceAnimation("Local Machine Password");
            System.out.println("Brute-Force attack failed! No Match found.");

            //TODO: decrypt method here
            String machinePassword = input.nextLine(); //you can put the output of the decrypt method directly in and don't need to Copy and Paste it here. but as you wish.
            if (!machinePassword.equals(doNotLookInside.getPcPW())) {
                System.out.println("Access Denied! Incorrect Local Machine Password.");
                return;
            }
            System.out.println("Local Machine Access Granted! Hacking Complete.");


            System.out.println("Access Denied! Incorrect WiFi Password.");
        }



    }

    //TODO: update this method so it displays the real brute Force attemps
    public static void fakeBruteForceAnimation(String target) throws InterruptedException {
        String chars = "0123456789";
        System.out.println("Attempting to brute-force " + target + "...");

        for (int i = 0; i < 10; i++) { // Fake attempts
            String attempt = "";
            for (int j = 0; j < 15; j++) {
                attempt += chars.charAt((int) (Math.random() * chars.length()));
            }
            System.out.print("Trying: " + attempt + "\r");
            TimeUnit.MILLISECONDS.sleep(500);
        }
        System.out.println("\nMatch found! Proceeding...");
    }
}
