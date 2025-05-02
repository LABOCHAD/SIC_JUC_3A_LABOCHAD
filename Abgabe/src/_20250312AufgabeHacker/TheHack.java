package _20250312AufgabeHacker;

import myTools.Color;
import myTools.UserInputScanner;

import java.util.Scanner;

public class TheHack {
    static final String PC_PW = "Local Machine Password";
    static DoNOTlookInside doNotLookInside = new DoNOTlookInside();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        boolean success = wifiHacking();
        if (!success) {
            System.out.println(Color.RED + "Mission failed!");
            return;
        } //end if fail

        tryToGetPC_Password();

        success = trySystemPenetration();
        if (!success) {
            System.out.println(Color.RED + "Mission failed!");
            return;
        } //end if fail

        goOnWithTheFile();
        input.close();
    }

    static boolean wifiHacking() throws InterruptedException {
        System.out.println(Color.GREEN);
        System.out.println("Starting WiFi Hack...");


        //DONE: brut-Force method here
        realBruteForceAnimation("Wifi password", doNotLookInside.getWifiPW());

        //ask for input max 3 times
        for (int tries = 3; tries > 0; tries--) {
            System.out.println("Tries left: " + tries);
            System.out.print("Now type in the Wifi password: ");
            String wifiPassword = input.nextLine();
            System.out.println();

            if (wifiPassword.equals(doNotLookInside.getWifiPW())) {
                System.out.println(Color.GREEN_BRIGHT + "WiFi Access Granted! Connecting to the network..." + Color.GREEN);
                Thread.sleep(1000);
                return true;
            }
            System.out.println(Color.RED + "Access Denied! Incorrect WiFi Password." + Color.GREEN);
        }
        return false;
    }

    static void realBruteForceAnimation(String target, String targetValue) throws InterruptedException {
        //DONE: update this method so it displays the real brute Force attempts
        String tryKey;
        System.out.println("Attempting to brute-force " + target + "...");
        int numericTryKey = 0;
        do {
            tryKey = String.format("%05d", numericTryKey);
            System.out.print("Trying " + tryKey + "...\r");
            Thread.sleep(1);
            numericTryKey++;

            if (target.equals("Local Machine Password"))
                numericTryKey += (int) (Math.random() * 100);

            if (numericTryKey > 99999) {
                System.out.println(Color.RED + "\nBrute Force Attack failed! No match found.\n" + Color.GREEN);
                return;
            }
        } while (!tryKey.equals(targetValue));

        System.out.println("\nMatch found! Proceeding...");
        System.out.println("The password is: " + tryKey);
        //Gosh, this must look ridiculous for a real hacker :D
    }

    static String caesarShifting(String text, int shift) {
        StringBuilder newText = new StringBuilder();
        //here begins the actual caesar
        for (char c : text.toCharArray()) {
            if (!Character.isLetter(c)) {
                newText.append(c);
                continue;
            }
            if (c >= 'A' && c <= 'Z') { //if the char is in uppercase range
                if (c + shift < 'A') c += 26; //if shifting falls below uppercase range
                else if (c + shift > 'Z') c -= 26; //if shifting exceeds uppercase range

            } else if (c >= 'a' && c <= 'z') { //if the char is in lowercase range
                if (c + shift < 'a') c += 26; //if shifting falls below lowercase range
                else if (c + shift > 'z') c -= 26; //if shifting exceeds lowercase range
            }
            newText.append((char) (c + shift));
        }
        return newText.toString();
    }

    static void animateProcess(String title, int length) throws InterruptedException {
        StringBuilder dots = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (dots.length() < 3) dots.append(".");
            else dots.delete(1, dots.length());
            System.out.print(title + dots + ((i < length - 1) ? "\r" : "\n"));
            Thread.sleep(10);
        }
    }

    static void decryptText(String text, int shift) throws InterruptedException {
        animateProcess("Decrypting Text", text.length());
        System.out.println("Result by decrypting with a key of " + shift);
        System.out.println(caesarShifting(text, shift));
    }

    static void tryToGetPC_Password() throws InterruptedException {
        System.out.println("Scanning local machine for vulnerabilities...");
        realBruteForceAnimation(PC_PW, doNotLookInside.getPcPW());

        //DONE: decrypt method here - in progress
        System.out.println("Try caesar decrypting hint for " + PC_PW);
        String encryptedText =
                "Jv mxpptloa fp ifkhba ql bsbov Tloa fk qefp Qbuq. Qxhb qeb cfopq Ibqqbo xka bsbov " +
                "mrkzqrxqflk, yb zxobcri xka Klqb qeb Rmmbo xka iltbo Zxpb. Xcqbo xii qebob fp qeb Krjybo 42!";

        decryptText(encryptedText, -3);
        decryptText(encryptedText, 3);
        System.out.println("\nLet's try to get a password out of the hint.");
        System.out.print("Paste the decryption here, that makes the most sense: ");
        String hint = input.nextLine();
        getPasswordFromHint(hint);
    }

    static boolean trySystemPenetration() {
        for (int tries = 3; tries > 0; tries--) {
            System.out.println("Tries left: " + tries);
            System.out.print("Type in the " + PC_PW + ": ");
            String machinePassword = input.nextLine().trim();
            System.out.println();

            //you can put the output of the decrypt method directly in and don't need to Copy and Paste it here.
            if (machinePassword.equals(doNotLookInside.getPcPW())) {
                System.out.println(Color.GREEN_BRIGHT + "Local Machine Access Granted! Hacking Complete." + Color.GREEN);
                return true;
            } else
                System.out.println(Color.RED + "Access Denied! Incorrect Local Machine Password." + Color.GREEN);
        }
        return false;
    }

    static void getPasswordFromHint(String hint) {
        StringBuilder password = new StringBuilder();
        if (hint.charAt(0) != ' ') password.append(hint.charAt(0));
        String punctuations = ",.;:!?()[]{}'`´°^";
        String numbers = "0123456789";

        for (int i = 1; i < hint.length(); i++) {
            String s = hint.substring(i, i + 1);
            if (s.equals(" ")) continue;

            if (numbers.contains(s) || punctuations.contains(s) || hint.charAt(i - 1) == ' ')
                password.append(s);
        }
        System.out.println("The password might be: " + password);
    }

    static void goOnWithTheFile() throws InterruptedException {
        int animationLength = TheFile.contentToBeEncrypted.length * 12;
        animateProcess("Fetching data to local space", animationLength);
        animateProcess("Safely delete data at remote", animationLength);
        System.out.print("Better encrypt these sensitive data. So type in a key number (1-25): ");

        int key = UserInputScanner.getIntOnlyPosRanged(input, 1, 26);
        System.out.println("Following data will be encrypted:");
        for (String s : TheFile.contentToBeEncrypted)
            System.out.println(s);

        System.out.println();
        animateProcess("Encrypting data", animationLength);
        for (int i = 0; i < TheFile.contentToBeEncrypted.length; i++){
            String replacement = caesarShifting(TheFile.contentToBeEncrypted[i], key);
            TheFile.contentToBeEncrypted[i] = replacement;
        }

        System.out.println();
        System.out.println("Encrypted data:");
        for (String s : TheFile.contentToBeEncrypted)
            System.out.println(s);

        System.out.println("Finally done! 🥳");
        //maybe safe encrypted data in a file, as soon as I learned it.
    }

}
