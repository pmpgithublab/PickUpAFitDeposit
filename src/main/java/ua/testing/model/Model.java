/*
 * @(#)Model.java     1.00 2020/02/14
 *
 * This software is free for use.
 */


package ua.testing.model;


import ua.testing.model.entity.*;

import java.util.*;

/**
 * Model class in MVC model.
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public class Model {
    Set<AccountProgram> depositesPrograms = new HashSet<>();

    public void setDepositesPrograms(Set<AccountProgram> depositesPrograms) {
        this.depositesPrograms = depositesPrograms;
    }

    public TreeSet getSortedDeposits(Class clazz, Comparator comparator) {
        TreeSet result = new TreeSet(comparator);
        for (AccountProgram accountProgram : depositesPrograms) {
            if (accountProgram.getClass() == clazz) {
                result.add(accountProgram);
            }
        }
        return result;
    }
}
