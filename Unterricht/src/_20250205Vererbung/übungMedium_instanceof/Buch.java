package _20250205Vererbung.übungMedium_instanceof;

public class Buch extends Medium {
    private final String autor;

    Buch(String titel, String autor) {
        super(titel);
        this.autor = autor;
    }

    @Override
    public void zeigeInfo() {
        System.out.printf("%nBuch: <%s> von <%s>", getTitel(), autor);
    }

    public String getAutor() {
        return autor;
    }
}
