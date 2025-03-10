package _20250212Aufgabe;

public class init {
    public static void main(String[] args) {
        String s1 = "Ich bin ein Satz"; //Whitespaces entfernen
        String s2= ".";
        String gegenprobe = "Ich bin ein Satz.";

        //Egal ob
        //String s3 = s1+".";
        //String s4 = s1+".";
        //oder
        String s3 = s1+s2;
        String s4 = s1+s2;
        System.out.println(s3==s4);
        System.out.println(s3==gegenprobe);
        //aber
        System.out.println(s2==".");
    }
}
