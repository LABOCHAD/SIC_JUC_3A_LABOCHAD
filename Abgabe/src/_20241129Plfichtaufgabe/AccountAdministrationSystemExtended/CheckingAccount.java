//Girokonto = checking account / bank account / current account
//Kontokorrent (it. (il) conto +  corrente (Partizip 1, correre = laufen, rennen) -> (laufende Rechnung))
package _20241129Plfichtaufgabe.AccountAdministrationSystemExtended;

import myTools.Color;

public class CheckingAccount extends BankAccount {
    private static final int FEES = 5;
    private static final int toleratedOverdraft = 2000;

    CheckingAccount(String owner, float balance, String accountNumber) {
        super(owner, balance, accountNumber);
        this.kind = "checking account";
    }

    /**
     * Reduces balance by fee stated statically.
     */
    @Override
    public void applyFees() {
        System.out.println("Applying fees for transaction: " + FEES);
        balance -= FEES;
    }

    @Override
    public float getFees(){
        return FEES;
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
        if (balance - withdrawal - FEES < -toleratedOverdraft) {
            System.out.println(Color.RED + "Account balance insufficient." + Color.RESET);
        } else {
            applyFees();
            balance -= withdrawal;
        }
    }

    /**
     * Adds up a given amount of money to the account balance.
     * Makes sure applying fees doesn't exceed tolerated overdraft.
     * @param disposal amount to add.
     */
    @Override
    public void deposit(float disposal) {
        if (disposal <= FEES) {
            System.out.println(Color.RED + "Disposal must be greater than " + FEES + Color.RESET);
        } else {
            applyFees();
            balance += disposal;
        }
    }
}
