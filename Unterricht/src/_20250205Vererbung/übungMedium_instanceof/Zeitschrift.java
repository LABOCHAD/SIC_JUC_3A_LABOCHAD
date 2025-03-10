package _20250205Vererbung.übungMedium_instanceof;

public class Zeitschrift extends Medium {
    private final int ausgabeNummer;

    Zeitschrift(String titel, int ausgabeNummer) {
        super(titel);
        this.ausgabeNummer = ausgabeNummer;
    }

    @Override
    public void zeigeInfo() {
        System.out.printf("%nZeitschrift: <%s> , Ausgabe <%s>", getTitel(), ausgabeNummer);
    }

}
