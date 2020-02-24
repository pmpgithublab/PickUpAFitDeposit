/*
 * @(#)Controller.java     1.00 2020/02/14
 *
 * This software is free for use.
 */

package ua.testing.controller;


import ua.testing.controller.services.GeneratorTestData;
import ua.testing.model.Model;
import ua.testing.model.entity.AccountProgram;
import ua.testing.view.View;

import java.util.Comparator;


/**
 * Controller class in MVC model.
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processing() {

        // set Locale
        // view.changeLocale(Locale.ENGLISH);
        // view.changeLocale(new Locale("uk", "UA"));

        getData();

        runSorts();

    }

    private void getData() {
        // XXX fill test data
        model.setAccountPrograms(new GeneratorTestData().testDataRead());

    }

    private void runSorts() {

        view.showMessage(view.messageProfit);
        view.showMessage(view.accountProgramsToString(model.getSortedDeposits(getAccountProgramComparatorByProfit())));

        view.showMessage(view.messageProfitReplenishment);
        view.showMessage(view.accountProgramsToString(model.getSortedDeposits(getAccountProgramComparatorByProfitAndReplenishment())));

        view.showMessage(view.messageProfitEarlyWithdrawal);
        view.showMessage(view.accountProgramsToString(model.getSortedDeposits(getAccountProgramComparatorByProfitAndEarlyWithdrawal())));

        view.showMessage(view.messageProfitReplenishmentEarlyWithdrawal);
        view.showMessage(view.accountProgramsToString(model.getSortedDeposits(getAccountProgramComparatorByProfitAndReplenishmentAndEarlyWithdrawal())));
    }

    public Comparator<AccountProgram> getAccountProgramComparatorByProfit() {
        return (acc1, acc2) -> {
            if (acc1 == acc2) return 0;
            int result = compareProfit(acc1, acc2);
            if (result != 0) {
                return result;
            }
            return compareNameAndBank(acc1, acc2);
        };
    }

    private int compareProfit(AccountProgram acc1, AccountProgram acc2) {
        return Double.compare(acc2.getProfitPercent(), acc1.getProfitPercent());
    }

    private Comparator<AccountProgram> getAccountProgramComparatorByProfitAndReplenishment() {
        return (acc1, acc2) -> {
            if (acc1 == acc2) return 0;
            int result = compareProfit(acc1, acc2);
            if (result != 0) {
                return result;
            }
            return compareReplenishment(acc1, acc2);
        };
    }

    private int compareReplenishment(AccountProgram o1, AccountProgram o2) {
        if (o1.isReplenishment() & !o2.isReplenishment()) {
            return -1;
        }
        if (!o1.isReplenishment() & o2.isReplenishment()) {
            return 1;
        }

        return compareNameAndBank(o1, o2);
    }

    private Comparator<AccountProgram> getAccountProgramComparatorByProfitAndEarlyWithdrawal() {
        return (acc1, acc2) -> {
            if (acc1 == acc2) return 0;
            int result = compareProfit(acc1, acc2);
            if (result != 0) {
                return result;
            }
            return compareEarlyWithdrawal(acc1, acc2);
        };
    }

    private int compareEarlyWithdrawal(AccountProgram o1, AccountProgram o2) {
        if (o1.isEarlyWithdrawal() & !o2.isEarlyWithdrawal()) {
            return -1;
        }
        if (!o1.isEarlyWithdrawal() & o2.isEarlyWithdrawal()) {
            return 1;
        }

        return compareNameAndBank(o1, o2);
    }

    private Comparator<AccountProgram> getAccountProgramComparatorByProfitAndReplenishmentAndEarlyWithdrawal() {
        return (acc1, acc2) -> {
            if (acc1 == acc2) return 0;
            int result = compareProfit(acc1, acc2);
            if (result != 0) {
                return result;
            }
            return compareReplenishmentAndEarlyWithdrawal(acc1, acc2);
        };
    }

    private int compareReplenishmentAndEarlyWithdrawal(AccountProgram o1, AccountProgram o2) {
        if ((o1.isReplenishment() & o1.isEarlyWithdrawal()) & !(o2.isReplenishment() & o2.isEarlyWithdrawal())) {
            return -1;
        }
        if ((o2.isReplenishment() & o2.isEarlyWithdrawal()) & !(o1.isReplenishment() & o1.isEarlyWithdrawal())) {
            return 1;
        }

        return compareNameAndBank(o1, o2);
    }

    private int compareNameAndBank(AccountProgram o1, AccountProgram o2) {
        int compareBank = o1.getBank().compareTo(o2.getBank());
        if (compareBank == 0) {
            return o1.getName().compareTo(o2.getName());
        }

        return compareBank;
    }

}
