package _20250228SingeltonsAndEnums;

//Erstelle eine Klasse Mitarbeiter mit folgenden Eigenschaften:
//  - er hat einen Namen
//  - er kann eine bestimmte Menge an Waren hinzufügen
//  - er kann eine bestimmte Menge an Waren entnehmen
//Die Methoden sollen auf das Lager zugreifen und den Bestand verändern!
//Erstelle in der Main-Methode Objekte und überprüfe die Funktionalität.
public class Mitarbeiter {
    String name;

    Mitarbeiter(String name) {
        this.name = name;
    }

    void takeWares(int count) {
        Warehouse.getInstance().removeBestand(count);
    }

    void storeWares(int count) {
        Warehouse.getInstance().addBestand(count);
    }

    public static void main(String[] args) {
        Mitarbeiter mitarbeiterDominik = new Mitarbeiter("Dominik");
        System.out.println("Aktuell auf Lager: " + Warehouse.getInstance().getBestand());
        mitarbeiterDominik.takeWares(2);
        mitarbeiterDominik.storeWares(2);
    }
}
