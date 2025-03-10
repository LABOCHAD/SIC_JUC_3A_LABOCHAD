package dingeTesten_LABOCHAD;

//https://javabeginners.de/Schleifen_und_Verzweigungen/switch_-case_-Verzweigung.php#:~:text=Guten%20Tag!%22)%3B%0A%20%20%20%20break%3B%0A%7D-,Switch%2DAusdr%C3%BCcke,-Mit%20Java%2012

import java.time.LocalDateTime;

public class SwitchAusdruckVglTernaryOperation {
    public static void main(String[] args) {
        int hour = LocalDateTime.now().getHour();

        System.out.println("Ausgabe eines String aus Switch-Statement: ");
        String gruss = switch (hour) {
            case 22, 23, 0, 1, 2, 3, 4 -> "Gute Nacht!"; //besser als if (hour == 22 || hour == ...)
            case 5, 6, 7, 8, 9, 10 -> "Guten Morgen!";
            case 18, 19, 20, 21 -> "Guten Abend!";
            default -> "Guten Tag!"; //11-17 Uhr
        };
        System.out.println(gruss);

        //Ternärer Ausdruck (tertiär =^ 3)
        gruss = (hour < 6 || hour >= 22 ? "Gute Nacht" : "Guten Tag"); //Wenn zu Zeit der Nachtruhe
    }
}
