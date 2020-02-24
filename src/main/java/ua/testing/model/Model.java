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
    private Set<AccountProgram> accountPrograms = new HashSet<>();

    public void setAccountPrograms(Set<AccountProgram> accountPrograms) {
        this.accountPrograms = accountPrograms;
    }

    public Set<AccountProgram> getAccountPrograms() {
        return accountPrograms;
    }

    public TreeSet<AccountProgram> getSortedDeposits(Comparator<AccountProgram> comparator) {
        TreeSet<AccountProgram> result = new TreeSet<>(comparator);
        result.addAll(accountPrograms);
        return result;
    }

}
