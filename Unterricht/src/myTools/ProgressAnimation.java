package myTools;

public class ProgressAnimation {

    public static String caesarShifting(String text, int shift) {
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

    public static void dotAnimateProcess(String title) {
        StringBuilder dots = new StringBuilder();
        final int length = 20;
        for (int i = 0; i < length; i++) {

            if (dots.length() < 5) dots.append(".");
            else dots.delete(0, dots.length());

            System.out.print(title + dots + ((i < length - 1) ? "\r" : "\b\n"));

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public static void fakeDotBarAnimateProcess(String title) {
        StringBuilder dotBar = new StringBuilder("          ");
        final int length = 20;
        final int dots = 10;
        final int ratio = (length) / dots;
        for (int i = 0; i < length; i++) {
            if (!dotBar.substring(1, dotBar.length()).equals(".........."))
                dotBar.replace(i/ratio,i/ratio+1,".");

            System.out.print(title + " [" + dotBar+ "] " + ((i < length - 1) ? "\r" : "\n"));

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public static void rotatingAnimateProcess(String title) {
        String symbols = "|/–\\|";
        final int length = 20;
        for (int i = 0; i < length; i++) {

            System.out.print(title + " " + symbols.charAt(i % (symbols.length() - 1))
                             + ((i < length - 1) ? "\r" : "\b\n"));

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                return;
            }
        }
    }


}
