/*
 * @(#)AccountProgram.java     1.00 2020/02/14
 *
 * This software is free for use.
 */


package ua.testing.model.entity;

import java.util.Objects;


/**
 * Class for keeping contribution data.
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public abstract class AccountProgram {
    protected String name;
    protected Bank bank;

    public AccountProgram(String name, Bank bank) {
        this.name = name;
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepositProgram deposit = (DepositProgram) o;
        return bank == deposit.bank &&
                Objects.equals(name, deposit.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 31 + bank.hashCode();
    }

    public String getName() {
        return name;
    }

    public Bank getBank() {
        return bank;
    }

    public abstract double getProfitPercent();

    public abstract boolean isReplenishment();

    public abstract boolean isEarlyWithdrawal();

}
