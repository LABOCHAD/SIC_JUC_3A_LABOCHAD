package _20241129Plfichtaufgabe.BankBeispiel;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    public ArrayList<BankAccount> accounts = new ArrayList<>(); //Speichert alle existierende BankAccounts
    Scanner scanner = new Scanner(System.in);


    //Konstruktor ruft displayMenu auf damit in Main nur ein neues Bankobjekt erstellt werden muss
    Bank(){
        displayMenu();
    }

    // prüft, ob ein account bereits existiert und erstellt diesen und fügt ihn zu der ArrayList accounts hinzu
    public void createAccount(String name){
        if (findAccount(name) == null){
            this.accounts.add(new BankAccount(name));
            System.out.println("Account erstellt, du hast eine Kontoeröffnungsprämie von 100€ erhalten");
        }else {
            System.out.println("Account existiert bereits!");
        }

    }
    // sucht nach einem Account mit dem Namen
    public BankAccount findAccount(String name) {
        for (BankAccount account : accounts) {
            if (account.getOwner().equalsIgnoreCase(name)) {
                return account;
            }
        }
        return null;
    }

    //"GUI" des programms: abfragen und eingaben durch den Benutzer
    public void displayMenu(){
        boolean menuScreen = false;


        while (!menuScreen) { // es gibt hier mehrere mögliche implementierungen dieser Schleife, es kann auch eine do-while sein oder einfach while(true), ...
            System.out.println("Hauptmenü:");
            System.out.println("1. Konto Erstellen");
            System.out.println("2. Geld einzahlen");
            System.out.println("3. Geld abheben");
            System.out.println("4. Kontostand abfragen");
            System.out.println("5. Beenden");

            switch (scanner.nextInt()) {
                case 1: //neues Konto erstellen
                    System.out.println("bitte Name eingeben:");
                    String name = scanner.next();
                    createAccount(name);
                    break;
                case 2: // geld einzahlen
                    System.out.print("Gib den Namen des Kontoinhabers ein: ");
                    BankAccount depositAccount = findAccount(scanner.next());
                    if (depositAccount != null) {
                        System.out.print("Gib den Betrag ein, der eingezahlt werden soll: ");
                        depositAccount.deposit(scanner.nextDouble());
                    } else {
                        System.out.println("Konto nicht gefunden.");
                    }
                    break;
                case 3: // geld abheben
                    System.out.print("Gib den Namen des Kontoinhabers ein: ");
                    BankAccount withdrawAccount = findAccount(scanner.next());
                    if (withdrawAccount != null) {
                        System.out.print("Gib den Betrag ein, der ausgezahlt werden soll: ");
                        withdrawAccount.withdraw(scanner.nextDouble());
                    } else {
                        System.out.println("Konto nicht gefunden.");
                    }
                    break;
                case 4: // Kontostand abfragen
                    System.out.print("Gib den Namen des Kontoinhabers ein: ");
                    BankAccount balanceAccount = findAccount(scanner.next());
                    if (balanceAccount != null) {
                        System.out.println("Dein Kontostand beträgt: " + balanceAccount.getBalance());
                    } else {
                        System.out.println("Konto nicht gefunden.");
                    }
                    break;
                case 5: // beenden
                    System.out.println("beenden ...");
                    scanner.close();
                    menuScreen = true;
                    break;

                default:
                    System.out.println("Falsche eingabe");
            }
        }
    }
}
