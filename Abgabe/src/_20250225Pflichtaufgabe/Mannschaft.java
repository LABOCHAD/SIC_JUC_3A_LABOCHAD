package _20250225Pflichtaufgabe;

import java.util.ArrayList;

public class Mannschaft {
    private static final int MAX_SPIELER = 11;
    private ArrayList<Spieler> spielerListe;

    public Mannschaft() {
        this.spielerListe = new ArrayList<>();
    }

    // Spieler hinzufügen (Checked Exception, falls Team voll)
    public void spielerHinzufuegen(Spieler spieler) throws KaderVollException, NummerSchonVergebenException {
        //MINE DONE: Ergänze NummerSchonVergebenException + Methode zum Durchsuchen
        //DONE: Prüfe, ob die maximale Anzahl erreicht wurde
        //Falls ja, werfe eine KaderVollException mit passender Fehlermeldung
        if (spielerListe.size() == MAX_SPIELER) {
            throw new KaderVollException(String.format("Kader ist voll! Spieler %s konnte nicht hinzugefügt werden!", spieler.getName()));
        }

        int nummer = spieler.getRueckennummer();
        if (istNummerVorhanden(nummer))
            throw new NummerSchonVergebenException(String.format("Es gibt schon einen Spieler mit der Nummer %d. Wähle eine andere für %s.", nummer, spieler.getName()));

        // DONE: Falls nicht, füge den Spieler zur Liste hinzu
        spielerListe.add(spieler);
    }

    private boolean istNummerVorhanden(int nummer) {
        for (Spieler spieler : spielerListe) {
            if (spieler.getRueckennummer() == nummer) {
                return true;
            }
        }
        return false;
    }

    // Eigene Overload, falls Spieler gleiche Namen, andere Nummer haben
    public void spielerEntfernen(String name, int rueckennummer) {
        for (Spieler spieler : spielerListe) {
            if (spieler.equals(new Spieler(name, rueckennummer))) {
                spielerListe.remove(spieler);
                System.out.printf("Spieler %s mit Rückennummer %d wurde entfernt.%n", name, rueckennummer);
                return;
            }
        }
        throw new SpielerNichtGefundenException(String.format("Spieler %s mit Nummer %d nicht gefunden.", name, rueckennummer)); //finde ich so eleganter.
    }

    // Spieler entfernen (Unchecked Exception, falls Spieler nicht existiert) - Gemäß Aufgabenstellung
    public void spielerEntfernen(String name) {
        // Suche den Spieler nach Namen
        int index = -1; //weil wir erst suchen, dann entfernen sollen.
        // Ich hätte ja versucht zu entfernen, wenn da und die Exception geworfen, wenn nicht da.
        // Falls Spieler nicht existiert, werfe eine SpielerNichtGefundenException
        // contains aus Liste geht nicht, weil dort equals aus Objekt (==) genutzt wird
        for (Spieler spieler : spielerListe) {
            if (spieler.getName().equals(name)) {
                index = spielerListe.indexOf(spieler);
                break; //suche nur nach erstem Match, sonst liefe es durch bis zum letzten
            }
        }
        if (index == -1)
            throw new SpielerNichtGefundenException(String.format("Spieler namens %s nicht gefunden!", name));

        // DONE: Falls Spieler existiert, entferne ihn aus der Liste
        spielerListe.remove(index); //es wäre auch ein direkter remove über spieler möglich.
        System.out.printf("Spieler %s wurde entfernt%n", name);
    }

    // Mannschaft ausgeben
    public void mannschaftAnzeigen() {
        System.out.println("Aktuelle Mannschaft:");
        for (Spieler s : spielerListe) {
            System.out.println(s);
        }
    }
}
