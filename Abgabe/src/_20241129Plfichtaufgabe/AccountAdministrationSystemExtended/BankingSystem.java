//TODO: -= Neue TODOs (04.12.2024) =-
//TODO: Negative Beträge verhindern: Aktuell können negative Abhebungen den Kontostand manipulieren.
//TODO: Validierung für alle Eingaben (z. B. bei `deposit()` und `withdraw()`) zentralisieren, um redundanten Code zu vermeiden.
//TODO: Überziehungslimit korrekt anwenden: Bei Girokonten wird das Überziehungslimit nicht immer geprüft, wenn Gebühren hinzukommen.
//TODO: Duplikate in `menuWhenLoggedIn` und `startMenu` durch Auslagerung von gemeinsamem Code reduzieren.
//TODO: Optional: Konstante Gebühren oder Prozentsätze dynamisch anpassbar machen, z. B. durch eine Konfigurationsdatei.
//TODO: Optional: Sicherheitsfunktionen wie Passwort- oder PIN-Validierung für Kontoanmeldungen einführen.

//TODO: -= Alte TODOs: =-
//TODO: Fehlerbehandlung beim Erstellen eines Kontos hinzufügen (z. B. ungültige Eingaben wie negative Beträge).
//TODO: Zusätzliche Validierungen für Ein- und Auszahlungen (z. B. keine negativen Werte) einfügen.
//TODO: Überlegen, ob ein Benutzerkonto durch eine eindeutige ID statt nur durch den Namen identifiziert werden soll.
//TODO: Einheitliche Validierung der Benutzereingaben in displayMenu() implementieren.
//TODO: Redundante Aufrufe von findAccount() optimieren.
//TODO: Möglichkeit hinzufügen, alle existierenden Konten aufzulisten.
//TODO: Überprüfen, ob das Menü durch eine separate Klasse übersichtlicher gestaltet werden könnte.

package _20241129Plfichtaufgabe.AccountAdministrationSystemExtended;

import java.util.Scanner;

/**
 * Class containing main method.
 * Further information, see main.
 */
class BankingSystem {
    /**
     * Starts the programm by
     * providing a scanner,
     * instantiating a bank object,
     * calling menu in bank class
     * while passing scanner to it.
     * Messages if exiting.
     * Closes Scanner in the end.
     *
     * @param args not considered.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        bank.startMenu(scanner);
        System.out.println("Exiting program...");
        scanner.close();
    }
}
