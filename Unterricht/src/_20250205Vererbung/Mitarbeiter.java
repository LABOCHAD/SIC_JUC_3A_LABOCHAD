package _20250205Vererbung;

public class Mitarbeiter {
    private String name, vorname;
    private int personalNummer;
    private double gehalt;


    Mitarbeiter(String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

    Mitarbeiter(String name, String vorname, int personalNummer, double gehalt) {
        this(name, vorname);
        this.personalNummer = personalNummer;
        this.gehalt = gehalt;
    }

    static void test(){}

    public double getGehalt() {
        return gehalt;
    }

    public void printDetails(){
        System.out.printf("""
                Name:           %s
                Vorname:        %s
                Personalnummer: %s
                Gehalt:         %s
                """,
        name, vorname, personalNummer, gehalt);
    }

    public String getVorname() {
        return vorname;
    }

    public String getName() {
        return name;
    }

    public int getPersonalNummer() {
        return personalNummer;
    }
}
