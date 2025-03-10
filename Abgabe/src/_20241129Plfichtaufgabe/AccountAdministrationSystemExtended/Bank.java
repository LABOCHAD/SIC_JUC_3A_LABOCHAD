package _20241129Plfichtaufgabe.AccountAdministrationSystemExtended;

import myTools.Color;
import myTools.UserInputScanner;

import java.util.ArrayList;
import java.util.Random;
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
    Bank() {
        this.accounts = new ArrayList<>();
    }

    /**
     * Creates a random six-digit-figure
     * for usage as an account number.
     * Although it is unlikely to occur,
     * number will be checked if already
     * an account exists in ArrayList which
     * has already assigned exact that number.
     * Repeats, still number is unique.
     *
     * @return unique account number String.
     */
    public String accountNumberGenerator() {
        Random random = new Random();
        //Feels easier and more intuitive than Math.random()
        //furthermore range could be applied much more easily.
        int id;
        String idStr;
        boolean isNew;
        do {
            id = random.nextInt(100000, 1000000);
            idStr = Integer.toString(id);
            isNew = findAccount(idStr) == null;
        } while (!isNew);
        return idStr;
    }

    /**
     * Creates new account by user's demands.
     * Offers choice for kind of account first.
     * Lets user choose, till choice is valid.
     * Asks for name and initial disposal.
     * Creates wished kind of account,
     * invoking randomized method for the ID.
     * Shows up all details after creation.
     *
     * @param scanner for user inputs.
     */
    public void createAccount(Scanner scanner) {
        int choice;
        float initialDisposal;
        do {
            System.out.printf("%nWhich kind of account?" +
                              "%n(1) Checking account" +
                              "%n(2) Savings Account" +
                              "%nPlease make a choice: "
            );
            choice = UserInputScanner.getIntOnlyPos(scanner);
        } while (choice > 2);

        System.out.printf("%nEnter the bank account owner's name: ");
        String name = scanner.nextLine();

        System.out.printf("Enter an initial balance for the new account of %s: ", name);
        initialDisposal = UserInputScanner.getFloatOnlyPos(scanner);

        if (choice == 1)
            accounts.add(new CheckingAccount(name, initialDisposal, accountNumberGenerator()));
        if (choice == 2)
            accounts.add(new SavingsAccount(name, initialDisposal, accountNumberGenerator()));

        System.out.printf("%nA new %s account has been created." +
                          "%nOwner:       %s" +
                          "%nBalance:     %.2f" +
                          "%nAccount-No.: %s%n",
                (choice == 1 ? "checking" : "savings"), name, initialDisposal, accounts.getLast().accountNumber);
    }

    /**
     * Iterates through the arraylist of accounts
     * and compares each account number with the given one.
     * If there is a match, account will be returned.
     * Else if there is no match at all, return is null.
     *
     * @param accountNumber to be compared with each account's ID.
     * @return account when found or null if not.
     */
    public BankAccount findAccount(String accountNumber) {
        for (BankAccount b : accounts) {
            if (b.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Only for debugging and testing.
     */
    private void test_ListAllAccountsDetails() {
        if (!accounts.isEmpty()) {
            System.out.printf("%nThe following accounts have been found%n");
            for (BankAccount b : accounts) {
                System.out.printf("[Name: %s, Balance: %.2f, Account Number(ID): %s, Kind: %s]%n"
                        , b.getOwner(), b.getBalance(), b.getAccountNumber(), b.getKind());
            }
        } else
            System.out.printf("%nNo accounts created so far.%n");
    }

    /**
     * Provides a main menu by making user decide what to do.
     * Lets user choose to create an account or log in with
     * an account already existing. Forwards account found.
     *
     * @param scanner used or passed further to get user inputs.
     */
    public void startMenu(Scanner scanner) {
        int choice;
        System.out.printf(
                "%nBank account administration system - main menu:" +
                "%n_______________________________________________" +
                "%nWelcome! How may we help you?" +
                "%n(1) Create new bank account" +
                "%n(2) Login with Account Number (ID)" +
                "%n(3) Exit and leave" +
                "%nPlease make a choice: ");
        choice = UserInputScanner.getIntOnlyPos(scanner);

        switch (choice) {
            case 9 -> test_ListAllAccountsDetails();
            case 1 -> createAccount(scanner);
            case 2 -> {
                System.out.printf("%nType in your account number: ");
                String id = scanner.nextLine();

                BankAccount account = findAccount(id);
                if (account != null)
                    menuWhenLoggedIn(scanner, account);
                else
                    System.out.println(Color.RED + "Login failed. Try again or make sure account exists." + Color.RESET);
            }
            case 3 -> {
                return;
            }
            default -> System.out.println("Something went wrong. Please try again.");
        }
        startMenu(scanner);
    }

    /**
     * Greets user with name and account number.
     * Offers choosing transaction for the account
     * like withdrawal or disposal and check balance
     * or logging off and returning to start menu.
     *
     * @param scanner for user input.
     * @param account that transactions will be applied to.
     */
    public void menuWhenLoggedIn(Scanner scanner, BankAccount account) {
        int choice;
        String id = account.getAccountNumber();
        String name = account.getOwner();
        String kind = account.getKind();

        System.out.printf(
                "%nHello %s " +
                "%nPlease, choose a transaction%n" +
                "for your %s [ID: %s]%n" +
                "%n(1) Make a disposal" +
                "%n(2) Make a withdrawal" +
                "%n(3) Check account balance" +
                "%n(4) Log out and exit" +
                "%n%nChoice: "
                , name, kind, id);
        choice = UserInputScanner.getIntOnlyPos(scanner);
        if (choice < 3)
            System.out.println("Dear costumer. Please consider transaction fee of " + account.getFees());
        switch (choice) {
            case 1 -> {
                System.out.printf("%nEnter an amount to dispose: ");
                account.deposit(scanner.nextFloat());
            }
            case 2 -> {
                System.out.printf("%nEnter an amount to withdraw: ");
                account.withdraw(scanner.nextFloat());
            }
            case 3 -> System.out.printf("%nAccount balance: %.2f%n", account.getBalance());
            case 4 -> {
                return;
            }
            default -> System.out.println("Choice invalid. Try again!");
        }
        menuWhenLoggedIn(scanner, account);
    }
}
