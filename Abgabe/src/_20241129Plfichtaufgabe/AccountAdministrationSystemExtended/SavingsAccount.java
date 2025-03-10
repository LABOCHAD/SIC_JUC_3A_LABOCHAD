package _20241129Plfichtaufgabe.AccountAdministrationSystemExtended;

import myTools.Color;

public class SavingsAccount extends BankAccount {
    private static final float FEES_PERCENTAGE = 1.5F/100; //I began with float, I don't want to dig over the whole project

    SavingsAccount(String owner, float balance, String accountNumber) {
        super(owner, balance, accountNumber);
        kind = "savings account";
    }

    /**
     * Reduces balance by fees
     * calculated in fees().
     */
    @Override
    public void applyFees() {
        balance -= getFees();
    }

    /**
     * calculates the fees based on the
     * account balance and percentage
     * stated on top of the class.
     * @return fees for current balance.
     */
    @Override
    public float getFees(){
        return balance * FEES_PERCENTAGE;
    }



    /**
     * Checks, if account balance isn't smaller
     * than intended withdrawal and fees together.
     * Messages user if not balance insufficient.
     * Applies fee and withdrawal if account
     * balance is covered sufficiently.
     * @param withdrawal amount that gets withdrawn from the account.
     */
    @Override
    public void withdraw(float withdrawal) {
        if (withdrawal + getFees() > balance) {
            System.out.println(Color.RED + "Account balance insufficient." + Color.RESET);
        } else {
            applyFees();
            balance -= withdrawal;
        }
    }

    /**
     * Adds up a given amount of money to the account balance.
     * Makes sure applying fees doesn't exceed balance below 0.
     * @param disposal amount to add.
     */
    @Override
    public void deposit(float disposal) {
        if (disposal <= getFees()) {
            System.out.println(Color.RED + "Disposal must be greater than " + getFees() + Color.RESET);
        } else {
            applyFees();
            balance += disposal;
        }
    }

}
