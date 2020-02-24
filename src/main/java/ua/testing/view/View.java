/*
 * @(#)View.java     1.00 2020/02/14
 *
 * This software is free for use.
 */

package ua.testing.view;


import ua.testing.model.entity.AccountProgram;
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

    public String messageProfit;
    public String messageProfitReplenishment;
    public String messageProfitEarlyWithdrawal;
    public String messageProfitReplenishmentEarlyWithdrawal;

    // use in deposit toString()
    public String depositProgramToString;
    public String bankToString;
    public String profitToString;
    public String replenishmentToStrin;
    public String earlyWithdrawalToString;
    public String closedBracket;

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
        messageProfit = resourceManager.getLocaleProperty(MESSAGE_PROFIT_RESOURCE);
        messageProfitReplenishment = resourceManager.getLocaleProperty(MESSAGE_PROFIT_REPLENISHMENT_RESOURCE);
        messageProfitEarlyWithdrawal = resourceManager.getLocaleProperty(MESSAGE_PROFIT_EARLY_WITHDRAWAL_RESOURCE);
        messageProfitReplenishmentEarlyWithdrawal = resourceManager.getLocaleProperty(MESSAGE_PROFIT_REPLENISHMENT_EARLY_WITHDRAWAL_RESOURCE);

        // use in deposit toString()
        depositProgramToString = resourceManager.getLocaleProperty(DEPOSIT_PROGRAM_TO_STRING_RESOURCE);
        bankToString = resourceManager.getLocaleProperty(BANK_TO_STRING_RESOURCE);
        profitToString = resourceManager.getLocaleProperty(PROFIT_TO_STRING_RESOURCE);
        replenishmentToStrin = resourceManager.getLocaleProperty(REPLENISHMENT_TO_STRING_RESOURCE);
        earlyWithdrawalToString = resourceManager.getLocaleProperty(EARLY_WITHDRAWAL_TO_STRING_RESOURCE);
        closedBracket = resourceManager.getLocaleProperty(CLOSED_BRACKET_RESOURCE);
    }

    public String accountProgramsToString(TreeSet<AccountProgram> accountPrograms) {
        StringBuilder result = new StringBuilder();
        for (AccountProgram depositProgram : accountPrograms) {
            result.append(concatenatingStrings(depositProgramToString, depositProgram.getName(),
                    bankToString, depositProgram.getBank().toString(),
                    profitToString, Double.toString(depositProgram.getProfitPercent()),
                    replenishmentToStrin, Boolean.toString(depositProgram.isReplenishment()),
                    earlyWithdrawalToString, Boolean.toString(depositProgram.isEarlyWithdrawal()),
                    closedBracket));
        }

        return result.toString();
    }

}
