package _20241129Plfichtaufgabe.BankBeispiel;

public class BankAccount {

    private final String kontoinhaber;
    private double kontostand;

    BankAccount(String name){
        this.kontoinhaber = name; // name des kontoinhabers speichern
        kontostand = 100.00; // in dieser Version bekommt der Kunde automatisch 100 Euro, wenn er ein Konto eröffnet

    }
    // Geld einzahlen prüft ob einzahlung größer 0 ist
    public void deposit(double money){
        if (money > 0) {
            this.kontostand += money;
        }else {
            System.out.println("es können nur positive beträge eingezahlt werden.");
        }
    }
    // auszahlung prüft, ob kontostand ausreichend gedeckt ist
    public void withdraw(double money){
        if (money <= this.kontostand){
            this.kontostand -= money;
        }else {
            System.out.println("es ist zu wenig Geld auf deinem Konto.");
        }
    }
    public double getBalance(){
        return this.kontostand;
    } // gibt den Kontostand zurück
    public String getOwner(){
        return this.kontoinhaber;
    } // gibt den Namen des Kontoinhabers zurück
}
