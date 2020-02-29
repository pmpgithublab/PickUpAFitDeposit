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
        // fill test data
        model.setAccountPrograms(new GeneratorTestData().testDataRead());

    }

    private void runSorts() {

        view.showMessage(view.messageProfit);
        sortAndShow(Comparator.comparingDouble(AccountProgram::getProfitPercent).
                reversed().
                thenComparing(AccountProgram::getBank).
                thenComparing(AccountProgram::getName));

        view.showMessage(view.messageProfitReplenishment);
        sortAndShow(Comparator.comparingDouble(AccountProgram::getProfitPercent).
                thenComparing(AccountProgram::isReplenishment).
                reversed().
                thenComparing(AccountProgram::getBank).
                thenComparing(AccountProgram::getName));

        view.showMessage(view.messageProfitEarlyWithdrawal);
        sortAndShow(Comparator.comparingDouble(AccountProgram::getProfitPercent).
                thenComparing(AccountProgram::isEarlyWithdrawal).
                reversed().
                thenComparing(AccountProgram::getBank).
                thenComparing(AccountProgram::getName));

        view.showMessage(view.messageProfitReplenishmentEarlyWithdrawal);
        sortAndShow(Comparator.comparingDouble(AccountProgram::getProfitPercent).
                thenComparing(AccountProgram::isReplenishment).
                thenComparing(AccountProgram::isEarlyWithdrawal).
                reversed().
                thenComparing(AccountProgram::getBank).
                thenComparing(AccountProgram::getName));
    }

    private void sortAndShow(Comparator<AccountProgram> comparator) {
        view.showMessage(view.accountProgramsToString(model.getSortedDeposits(comparator)));
    }
}
