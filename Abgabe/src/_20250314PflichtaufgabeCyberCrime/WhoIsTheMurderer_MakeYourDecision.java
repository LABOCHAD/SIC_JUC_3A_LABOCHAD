package _20250314PflichtaufgabeCyberCrime;

import java.util.Scanner;

public class WhoIsTheMurderer_MakeYourDecision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Did you collect enough evidence to raise your Word and bring someone into prison? \n Enter \"yes\" or \"no\"");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Who is it? ");
            String theMurderer = sc.nextLine();
            if (theMurderer.equalsIgnoreCase(DoNotLookInside.x)) {
                DoNotLookInside.murderer();
            } else {
                System.out.println("You suspected an innocent guest. The murderer got away.");
            }
        }
    }
}
