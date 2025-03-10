package _20250225Pflichtaufgabe;

public class Main {
    public static void main(String[] args) {
        Mannschaft team = new Mannschaft();

        try {
            //Teste irgendwo bei den ersten 11 eine gleiche Nummer (Kader fliegt zuerst)
            team.spielerHinzufuegen(new Spieler("Thomas Müller", 25));
            team.spielerHinzufuegen(new Spieler("Manuel Neuer", 1));
            team.spielerHinzufuegen(new Spieler("Joshua Kimmich", 6));
            team.spielerHinzufuegen(new Spieler("Leroy Sané", 10));
            team.spielerHinzufuegen(new Spieler("Leon Goretzka", 8));
            team.spielerHinzufuegen(new Spieler("Serge Gnabry", 7));
            team.spielerHinzufuegen(new Spieler("Jamal Musiala", 42));
            team.spielerHinzufuegen(new Spieler("Antonio Rüdiger", 2));
            team.spielerHinzufuegen(new Spieler("Niklas Süle", 4));
            team.spielerHinzufuegen(new Spieler("David Raum", 3));
            team.spielerHinzufuegen(new Spieler("Marc-André ter Stegen", 1)); //rn22
            // DONE: Füge weitere Spieler hinzu (maximal 11) //Es waren schon 11
            //team.spielerHinzufuegen(new Spieler("Dominik Labocha", 29)); //Spieler 12

        } catch (KaderVollException | NummerSchonVergebenException e) {
            System.err.println("Fehler: " + e.getMessage());
        }

        team.mannschaftAnzeigen();

        // DONE: Teste das Entfernen eines Spielers - Kommentiere jeweils aus zum Testen
        // Teste auch das Entfernen eines Spielers, der nicht existiert (sollte eine Unchecked Exception auslösen)
        try{
            team.spielerEntfernen("Thomas Müller");
            team.spielerEntfernen("Manuel Neuer",1);
            team.spielerEntfernen("David Raum",10);
            team.spielerEntfernen("Dominik Labocha");
        } catch (SpielerNichtGefundenException e){
            System.err.println("Fehler: " + e.getMessage());
        }
    }
}

