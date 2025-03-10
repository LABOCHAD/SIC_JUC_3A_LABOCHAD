package _20250205Vererbung;

public class Abteilungsleiter extends Mitarbeiter {

    Abteilungsleiter(String name, String vorname) {
        super(name, vorname);
    }

    Abteilungsleiter(String name, String vorname, int personalNummer, double gehalt) {
        super(name, vorname, personalNummer, gehalt);
    }

    @Override
    public double getGehalt() {
        return super.getGehalt();
    }


    public static void test(){

    }

    public void printDetails() {
        System.out.printf("""
                        Name:           %s
                        Vorname:        %s
                        Personalnummer: %s
                        Gehalt:         %s
                        """,
                getName(), getVorname(), getPersonalNummer(), getGehalt());
    }
}
