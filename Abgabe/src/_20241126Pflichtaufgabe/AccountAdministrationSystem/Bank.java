package _20241126Pflichtaufgabe.AccountAdministrationSystem;

import myTools.UserInputScanner;

import java.util.ArrayList;
import java.util.Scanner;

class Bank {
    protected ArrayList<BankAccount> accounts;

    /**
     * Simple constructor initializing ArrayList
     * that has been instantiated before.
     * Just makes sense in case multiple banks will be used.
     * Otherwise, making the whole class static had done as well.
     * (done in sense of being enough, not doing anything literally.)
     */
    //for this specific task also a static class Bank would work
    Bank() {
        this.accounts = new ArrayList<>();
    }

    /**
     * Creates an account if none is already existent
     * with the given name by adding it directly into
     * the arraylist while instantiating it. If an
     * account already exists with the name given
     * user will be messaged by an output.
     * @param name for creating account or checking for preexistence.
     * @param initialDisposal first disposal at account opening.
     */
    public void createAccount(String name, float initialDisposal) {
        if (findAccount(name) == null) { //not equals(), because null seems considered a literal
            accounts.add(new BankAccount(name, initialDisposal));
        } else {
            System.out.println("Account with stated name already exists.");
        }
    }

    /**
     * Iterates through the arraylist of accounts
     * and compares each name with the given one.
     * If there is a match, account will be returned.
     * Else if there is no match at all, return is null.
     * @param name to be compared with each account's name.
     * @return account when found or null if not.
     */
    public BankAccount findAccount(String name) {
        for (BankAccount b : accounts) {
            if (b.getOwner().equalsIgnoreCase(name)) {
                return b;
            }
        }
        System.out.println("Account with stated owner couldn't be found.");
        return null;
    }

    /**
     * Provides a main menu by making user decide what to do.
     * Also calls the desired sub functionalities from here.
     * Lets user choose to create an account, make a disposal
     * or a withdrawal, also account balance can be checked.
     * For all except exiting a name must be entered and a
     * float value for the particular transaction to be done.
     * Checks for account's existence, when not creating but
     * intending a transaction that won't be done, when not found.
     * Makes the program come to its end, when exit is chosen.
     * @param scanner used or passed further to get user inputs.
     */
    public void displayMenu(Scanner scanner) {
        System.out.printf(
                "%nBank account administration system - main menu:" +
                        "%n_______________________________________________" +
                        "%n(1) Create new bank account" +
                        "%n(2) Make a disposal" +
                        "%n(3) Make a withdrawal" +
                        "%n(4) Check account balance" +
                        "%n(5) Exit" +
                        "%n%nChoice: ");

        int choice = UserInputScanner.getIntOnlyPos(scanner);

        String name = "";
        if (choice < 5) {
            System.out.printf("%nEnter the bank account owner's name: ");
            name = scanner.nextLine();
        }
        BankAccount ba = findAccount(name);
        if (ba == null){
            displayMenu(scanner);
        } else {
            switch (choice) {
                case 1 -> { //creation
                    System.out.printf("Enter an initial balance for the new account of %s: ", name);
                    createAccount(name, scanner.nextFloat());
                }
                case 2 -> { //disposal
                    System.out.printf("Enter an amount to dispose for the account of %s: ", name);
                    ba.deposit(scanner.nextFloat());

                }
                case 3 -> { //withdrawal
                    System.out.printf("Enter an amount to withdraw for the account of %s: ", name);
                    ba.withdraw(scanner.nextFloat());
                }
                case 4 -> //check balance
                    System.out.printf("Account balance of %s: %.2f", name, ba.getBalance());

                case 5 -> {
                    return;
                }
                default -> {
                    System.out.println("Choice invalid. Try again!");
                    displayMenu(scanner);
                }
            }
        }

        System.out.print("Press return to continue...");
        scanner.nextLine();
        scanner.reset();
        displayMenu(scanner);
    }
}
