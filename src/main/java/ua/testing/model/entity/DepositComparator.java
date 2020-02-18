/*
 * @(#)DepositComparator.java     1.00 2020/02/14
 *
 * This software is free for use.
 */

package ua.testing.model.entity;

import java.util.Comparator;


/**
 * Comparator for class DepositProgram.
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public class DepositComparator implements Comparator<DepositProgram> {
    private boolean replenishment;
    private boolean earlyWithdrawal;

    private boolean setVariable(int parameterNumber, Boolean... parameters) {
        try {
            return parameters[parameterNumber];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public DepositComparator(Boolean... sortParameters) {
        // sortParameters[0]=isReplenishment, sortParameters[1]=isEarlyWithdrawal
        this.replenishment = setVariable(0, sortParameters);
        this.earlyWithdrawal = setVariable(1, sortParameters);
    }

    @Override
    public int compare(DepositProgram o1, DepositProgram o2) {
        if (o1 == o2) {
            return 0;
        }
        int profitPercentCompare = Double.compare(o1.getProfitPercent(), o2.getProfitPercent()) * -1;
        if (profitPercentCompare != 0) {
            return profitPercentCompare;
        }

        if (replenishment & !earlyWithdrawal) {
            return compareReplenishment(o1, o2);
        }

        if (!replenishment & earlyWithdrawal) {
            return compareEarlyWithdrawal(o1, o2);
        }

        if (replenishment & earlyWithdrawal) {
            return compareReplenishmentAndEarlyWithdrawal(o1, o2);
        }

        return compareNameAndBank(o1, o2);
    }

    private int compareNameAndBank(DepositProgram o1, DepositProgram o2) {
        int compareBank = o1.getBank().compareTo(o2.getBank());
        if (compareBank == 0) {
            return o1.getName().compareTo(o2.getName());
        }

        return compareBank;
    }

    private int compareReplenishment(DepositProgram o1, DepositProgram o2) {
        if (o1.isReplenishment() & !o2.isReplenishment()) {
            return -1;
        }
        if (!o1.isReplenishment() & o2.isReplenishment()) {
            return 1;
        }

        return compareNameAndBank(o1, o2);
    }

    private int compareEarlyWithdrawal(DepositProgram o1, DepositProgram o2) {
        if (o1.isEarlyWithdrawal() & !o2.isEarlyWithdrawal()) {
            return -1;
        }
        if (!o1.isEarlyWithdrawal() & o2.isEarlyWithdrawal()) {
            return 1;
        }

        return compareNameAndBank(o1, o2);
    }

    private int compareReplenishmentAndEarlyWithdrawal(DepositProgram o1, DepositProgram o2) {
        if ((o1.isReplenishment() & o1.isEarlyWithdrawal()) & !(o2.isReplenishment() & o2.isEarlyWithdrawal())) {
            return -1;
        }
        if ((o2.isReplenishment() & o2.isEarlyWithdrawal()) & !(o1.isReplenishment() & o1.isEarlyWithdrawal())) {
            return 1;
        }

        return compareNameAndBank(o1, o2);
    }
}
