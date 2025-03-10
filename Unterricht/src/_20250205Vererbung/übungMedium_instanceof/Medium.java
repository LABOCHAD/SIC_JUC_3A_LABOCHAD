package _20250205Vererbung.übungMedium_instanceof;

public class Medium {
    private String titel;

    Medium(String titel){
        this.titel = titel;
    }

    public void zeigeInfo(){
        System.out.format("%nMedium: <%s>", titel);
    }

    public String getTitel() {
        return titel;
    }
}
