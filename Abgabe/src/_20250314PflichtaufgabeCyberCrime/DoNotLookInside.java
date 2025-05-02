package _20250314PflichtaufgabeCyberCrime;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;

public class DoNotLookInside {
    String[] evidenceKitchen = new String[] {"David", "Sophia"};
    static String x = "David";
    HashMap<LocalDateTime, String> logs = new HashMap();
    String[] users = {"Ghost", "David", "Sophia", "Elizabeth", "UnknownUser"};
    Random random = new Random();
    private int passcode = 0;
    private static String dualnumber = "11110111111";

    DoNotLookInside(){
        LocalDateTime startTime = LocalDateTime.of(2023, 5, 14, 22, 0);
        for (int i = 0; i < 50; i++) {
            logs.put(startTime.plusMinutes(i * 2), users[random.nextInt(users.length)]);
        }
        logs.put(LocalDateTime.of(2023, 5, 14, 22, 30), "David");

    }
    DoNotLookInside(int number){
        //passcode = number;
        passcode = (int)(Math.random() * 90000) + 10000;
    }

    public static void murderer() {
        System.out.println("David is arrested. \nYou successfully brought the murderer into prison.");
    }

    public static void safe(String number) {
        if (number.equals(dualnumber)){
            System.out.println("You read a chat of a conversation about selling the vulnerabilities of CyberShields newest encryption. " +
                               "\nSo it is true, someone did steal his secrets and sold it.");
        }
    }

    public boolean tryPasscode(int passcode){
        if (passcode == this.passcode){
            System.out.println("Someone of your nearest loved ones is spying on you! You need to act now!");
            return true;
        }else{
            System.out.println("Wrong passcode!");
            return false;
        }
    }
}
