package dingeTesten_LABOCHAD;

public class TesteSubString {
    public static void main(String[] args) {
        String plzStadt = "49757 Werlte";

        String plz = plzStadt.substring(0, 5); // exklusiv Stelle 5 [0-4]

        String city = plzStadt.substring(6); //von Stelle 6, weil 5 = Leerzeichen
    }
}
