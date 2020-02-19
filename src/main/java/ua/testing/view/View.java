/*
 * @(#)View.java     1.00 2020/02/14
 *
 * This software is free for use.
 */

package ua.testing.view;


import ua.testing.model.entity.DepositProgram;
import ua.testing.view.entity.Constants;
import ua.testing.view.entity.ResourceManager;

import java.util.Locale;
import java.util.TreeSet;

/**
 * View class in MVC model.
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public class View implements Constants {
    private ResourceManager resourceManager = ResourceManager.INSTANCE;

    public String MESSAGE_PROFIT;
    public String MESSAGE_PROFIT_REPLENISHMENT;
    public String MESSAGE_PROFIT_EARLY_WITHDRAWAL;
    public String MESSAGE_PROFIT_REPLENISHMENT_EARLY_WITHDRAWAL;

    // use in deposit toString()
    public String DEPOSIT_PROGRAM_TO_STRING;
    public String BANK_TO_STRING;
    public String PROFIT_TO_STRING;
    public String REPLENISHMENT_TO_STRIN;
    public String EARLY_WITHDRAWAL_TO_STRING;
    public String CLOSED_BRACKET;

    public View() {
        initLocaleStrings();
    }

    public void showMessage(String message) {
        System.out.print(message);
    }

    public static String concatenatingStrings(String... stringsForConcatenation) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : stringsForConcatenation) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public void changeLocale(Locale locale) {
        resourceManager.changeLocale(locale);
        initLocaleStrings();
    }

    private void initLocaleStrings() {
        MESSAGE_PROFIT = resourceManager.getLocaleProperty(MESSAGE_PROFIT_RESOURCE);
        MESSAGE_PROFIT_REPLENISHMENT = resourceManager.getLocaleProperty(MESSAGE_PROFIT_REPLENISHMENT_RESOURCE);
        MESSAGE_PROFIT_EARLY_WITHDRAWAL = resourceManager.getLocaleProperty(MESSAGE_PROFIT_EARLY_WITHDRAWAL_RESOURCE);
        MESSAGE_PROFIT_REPLENISHMENT_EARLY_WITHDRAWAL = resourceManager.getLocaleProperty(MESSAGE_PROFIT_REPLENISHMENT_EARLY_WITHDRAWAL_RESOURCE);

        // use in deposit toString()
        DEPOSIT_PROGRAM_TO_STRING = resourceManager.getLocaleProperty(DEPOSIT_PROGRAM_TO_STRING_RESOURCE);
        BANK_TO_STRING = resourceManager.getLocaleProperty(BANK_TO_STRING_RESOURCE);
        PROFIT_TO_STRING = resourceManager.getLocaleProperty(PROFIT_TO_STRING_RESOURCE);
        REPLENISHMENT_TO_STRIN = resourceManager.getLocaleProperty(REPLENISHMENT_TO_STRIN_RESOURCEG);
        EARLY_WITHDRAWAL_TO_STRING = resourceManager.getLocaleProperty(EARLY_WITHDRAWAL_TO_STRING_RESOURCE);
        CLOSED_BRACKET = resourceManager.getLocaleProperty(CLOSED_BRACKET_RESOURCE);
    }

    public String depositProgramsToString(TreeSet<DepositProgram> depositPrograms) {
        StringBuilder result = new StringBuilder();
        for (DepositProgram depositProgram : depositPrograms) {
            result.append(concatenatingStrings(DEPOSIT_PROGRAM_TO_STRING, depositProgram.getName(),
                    BANK_TO_STRING, depositProgram.getBank().toString(),
                    PROFIT_TO_STRING, Double.toString(depositProgram.getProfitPercent()),
                    REPLENISHMENT_TO_STRIN, Boolean.toString(depositProgram.isReplenishment()),
                    EARLY_WITHDRAWAL_TO_STRING, Boolean.toString(depositProgram.isEarlyWithdrawal()),
                    CLOSED_BRACKET));
        }

        return result.toString();
    }
}
