package _20241126Pflichtaufgabe.AccountAdministrationSystem;

/**
 * Class modeling bank accounts.
 * Has owner name and a balance each.
 * Can show balance or owner,
 * make a withdrawal or disposal.
 */
class BankAccount {
    private final String owner;
    private float balance;

    /**
     * Constructor method.
     * @param owner name of the owner.
     * @param balance how much money is on the account.
     */
    BankAccount(String owner, float balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    /**
     * Checks, if account balance isn't smaller than intended withdrawal.
     * If yes, gives a message to the user.
     * If not, reduces balance by amount of withdrawal.
     * @param withdrawal amount that gets withdrawn from the account.
     */
    public void withdraw(float withdrawal) {
        if (withdrawal >= balance) {
            System.out.println("Account balance insufficient.");
        } else {
            balance -= withdrawal;
        }
    }

    /**
     * Adds up a given amount of money to the account balance.
     * @param disposal amount to add.
     */
    public void deposit(float disposal) {
        balance += disposal;
    }


}
