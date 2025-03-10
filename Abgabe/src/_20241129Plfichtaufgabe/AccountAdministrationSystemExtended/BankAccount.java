package _20241129Plfichtaufgabe.AccountAdministrationSystemExtended;

/**
 * Class modeling bank accounts.
 * Has owner name and a balance each.
 * Can show balance or owner,
 * make a withdrawal or disposal.
 */
abstract class BankAccount {
    protected final String owner;
    protected float balance;
    protected String accountNumber;
    protected String kind;

    BankAccount(String owner, float balance, String accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
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

    public abstract void applyFees();

    public abstract float getFees();

    public float getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getKind() {
        return kind;
    }


}
