/*
 * @(#)Controller.java     1.00 2020/02/14
 *
 * This software is free for use.
 */

package ua.testing.controller;


import ua.testing.controller.services.GeneratorTestData;
import ua.testing.model.Model;
import ua.testing.model.entity.DepositComparator;
import ua.testing.model.entity.DepositProgram;
import ua.testing.view.View;

import java.util.Locale;


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
        //view.changeLocale(Locale.ENGLISH);
        view.changeLocale(new Locale("ua", "UA"));

        getData();
        runSorts();

    }

    private void runSorts() {
        boolean isReplenishment = true;
        boolean isEarlyWithdrawal = true;

        // sort only by profit
        view.showMessage(view.MESSAGE_PROFIT);
        view.showMessage(view.depositProgramsToString(model.getSortedDeposits(DepositProgram.class, new DepositComparator())));

        // sort by profit and replenishment
        view.showMessage(view.MESSAGE_PROFIT_REPLENISHMENT);
        view.showMessage(view.depositProgramsToString(model.getSortedDeposits(DepositProgram.class, new DepositComparator(isReplenishment))));

        //sort by profit and early withdrawal
        view.showMessage(view.MESSAGE_PROFIT_EARLY_WITHDRAWAL);
        view.showMessage(view.depositProgramsToString(model.getSortedDeposits(DepositProgram.class, new DepositComparator(!isReplenishment, isEarlyWithdrawal))));

        //sort by profit and replenishment and early withdrawal
        view.showMessage(view.MESSAGE_PROFIT_REPLENISHMENT_EARLY_WITHDRAWAL);
        view.showMessage(view.depositProgramsToString(model.getSortedDeposits(DepositProgram.class, new DepositComparator(isReplenishment, isEarlyWithdrawal))));
    }

    private void getData() {
        // XXX fill test data
        model.setDepositesPrograms(new GeneratorTestData().testDataRead());
        // model.setDepositesPrograms(new GeneratorTestData().testDepositGenerate(10));
    }

}
