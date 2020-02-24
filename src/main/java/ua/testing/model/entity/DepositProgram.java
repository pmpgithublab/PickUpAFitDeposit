/*
 * @(#)DepositProgram.java     1.00 2020/02/14
 *
 * This software is free for use.
 */


package ua.testing.model.entity;


/**
 * Class for keeping contribution data.
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public class DepositProgram extends AccountProgram {
    private long profitPercent;
    private boolean replenishment;
    private boolean earlyWithdrawal;

    public DepositProgram(String name, Bank bank, double profitPercent, boolean replenishment, boolean earlyWithdrawal) {
        super(name, bank);
        this.profitPercent = (long) profitPercent * 100;
        this.replenishment = replenishment;
        this.earlyWithdrawal = earlyWithdrawal;
    }

    public DepositProgram(String name, Bank bank, int profitPercentMultiple100, boolean replenishment, boolean earlyWithdrawal) {
        super(name, bank);
        this.profitPercent = profitPercentMultiple100;
        this.replenishment = replenishment;
        this.earlyWithdrawal = earlyWithdrawal;
    }

    public double getProfitPercent() {
        return (double) profitPercent / 100;
    }

    public boolean isReplenishment() {
        return replenishment;
    }

    public boolean isEarlyWithdrawal() {
        return earlyWithdrawal;
    }

}

