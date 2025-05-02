package _20250212StringsundStringBuilder;

import java.util.Scanner;

public class StrTasks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter a sentence: %n");

        String sentence = sc.nextLine();
        System.out.printf("Your sentence is: %s%n",sentence);

        System.out.printf("Write one word from your sentence: %n");
        String word = sc.nextLine();
        System.out.printf("Your word is: %s%n",word);

        boolean testHallo = sentence.startsWith("Hallo");
        System.out.printf("Starts with Hallo: %s%n",testHallo);
        boolean testEnd = sentence.endsWith("!");
        System.out.printf("Ends with ! : %s%n",testEnd);
        if (testHallo) {
            System.out.printf("Dein Satz startet mit Hallo %n");
        } if (testEnd){
            System.out.printf("Dein Satz endet mit ! %n");
        }
        boolean testCont = sentence.contains(word);
        System.out.printf("Contains %s: %s%n",word,testCont);
        String testReplace = sentence.replace(" ", "_");
        System.out.printf("Space replaced with _ : %s%n",testReplace);
        String testLength = sentence.length() + "";
        System.out.printf("Sentence length: %s%n",testLength);
        int testIndex = sentence.indexOf(word);
        if (testIndex != -1) {
            System.out.printf("Index of Word -> %s: is %s%n",word,testIndex);
        } else {
            System.out.printf("Word -> %s:  not found%n",word);
        }
        String substring = sentence.substring(0, 10);
        System.out.printf("Substring: %s%n",substring);
        String testTrim = sentence.trim();
        System.out.printf("Sentence trimmed: %s%n",testTrim);
        char testFirstChar = sentence.charAt(0);
        System.out.printf("First char: %s%n",testFirstChar);





    }
}
