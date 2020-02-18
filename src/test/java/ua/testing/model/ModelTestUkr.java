/*
 * @(#)ModelTest.java     1.00 2020/02/14
 *
 * This software is free for use.
 */


package ua.testing.model;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.testing.controller.services.GeneratorTestData;
import ua.testing.model.entity.DepositComparator;
import ua.testing.model.entity.DepositProgram;
import ua.testing.view.View;

import java.util.Locale;

import static org.junit.Assert.assertTrue;

/**
 * Sorting tests.
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public class ModelTestUkr {
    //Set test = new GeneratorTestData().testDataRead();
    static Model model = new Model();
    static View view = new View();


    @BeforeClass
    public static void init(){
        model.setDepositesPrograms(new GeneratorTestData().testDataRead());
        view.changeLocale(new Locale("ua", "UA"));
    }


    @Test
    public void profitSort() {

        assertTrue(view.depositProgramsToString(model.getSortedDeposits(DepositProgram.class, new DepositComparator())).equals("\n" +
                "Депозитна програма { назва =Bujp, банк = BANK2, відсоток % = 3.93, поповнення = true, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Geho, банк = BANK3, відсоток % = 3.29, поповнення = false, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Zlli, банк = BANK4, відсоток % = 3.29, поповнення = true, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Wqyb, банк = BANK3, відсоток % = 1.69, поповнення = false, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Jtra, банк = BANK1, відсоток % = 1.31, поповнення = false, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Uhli, банк = BANK1, відсоток % = 1.31, поповнення = true, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Wnde, банк = BANK1, відсоток % = 1.31, поповнення = false, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Bgwl, банк = BANK4, відсоток % = 1.31, поповнення = true, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Nhcy, банк = BANK2, відсоток % = 0.94, поповнення = true, дострокове зняття = true};"));
    }

    @Test
    public void profitAndReplenishmentSort() {
        boolean isReplenishment = true;

        assertTrue(view.depositProgramsToString(model.getSortedDeposits(DepositProgram.class, new DepositComparator(isReplenishment))).equals("\n" +
                "Депозитна програма { назва =Bujp, банк = BANK2, відсоток % = 3.93, поповнення = true, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Zlli, банк = BANK4, відсоток % = 3.29, поповнення = true, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Geho, банк = BANK3, відсоток % = 3.29, поповнення = false, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Wqyb, банк = BANK3, відсоток % = 1.69, поповнення = false, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Uhli, банк = BANK1, відсоток % = 1.31, поповнення = true, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Bgwl, банк = BANK4, відсоток % = 1.31, поповнення = true, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Jtra, банк = BANK1, відсоток % = 1.31, поповнення = false, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Wnde, банк = BANK1, відсоток % = 1.31, поповнення = false, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Nhcy, банк = BANK2, відсоток % = 0.94, поповнення = true, дострокове зняття = true};"));
    }

    @Test
    public void profitAndEarlyWithdrawalSort() {
        boolean isReplenishment = true;
        boolean isEarlyWithdrawal = true;

        assertTrue(view.depositProgramsToString(model.getSortedDeposits(DepositProgram.class, new DepositComparator(!isReplenishment, isEarlyWithdrawal))).equals("\n" +
                "Депозитна програма { назва =Bujp, банк = BANK2, відсоток % = 3.93, поповнення = true, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Geho, банк = BANK3, відсоток % = 3.29, поповнення = false, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Zlli, банк = BANK4, відсоток % = 3.29, поповнення = true, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Wqyb, банк = BANK3, відсоток % = 1.69, поповнення = false, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Wnde, банк = BANK1, відсоток % = 1.31, поповнення = false, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Bgwl, банк = BANK4, відсоток % = 1.31, поповнення = true, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Jtra, банк = BANK1, відсоток % = 1.31, поповнення = false, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Uhli, банк = BANK1, відсоток % = 1.31, поповнення = true, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Nhcy, банк = BANK2, відсоток % = 0.94, поповнення = true, дострокове зняття = true};"));
    }

    @Test
    public void profitAndReplenishmentAndEarlyWithdrawalSort() {
        boolean isReplenishment = true;
        boolean isEarlyWithdrawal = true;

        assertTrue(view.depositProgramsToString(model.getSortedDeposits(DepositProgram.class, new DepositComparator(isReplenishment, isEarlyWithdrawal))).equals("\n" +
                "Депозитна програма { назва =Bujp, банк = BANK2, відсоток % = 3.93, поповнення = true, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Geho, банк = BANK3, відсоток % = 3.29, поповнення = false, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Zlli, банк = BANK4, відсоток % = 3.29, поповнення = true, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Wqyb, банк = BANK3, відсоток % = 1.69, поповнення = false, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Bgwl, банк = BANK4, відсоток % = 1.31, поповнення = true, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Jtra, банк = BANK1, відсоток % = 1.31, поповнення = false, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Uhli, банк = BANK1, відсоток % = 1.31, поповнення = true, дострокове зняття = false};\n" +
                "Депозитна програма { назва =Wnde, банк = BANK1, відсоток % = 1.31, поповнення = false, дострокове зняття = true};\n" +
                "Депозитна програма { назва =Nhcy, банк = BANK2, відсоток % = 0.94, поповнення = true, дострокове зняття = true};"));
    }

}