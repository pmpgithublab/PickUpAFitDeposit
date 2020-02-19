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

import static org.junit.Assert.*;

/**
 * Sorting tests.
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public class ModelTestEng {
    static Model model = new Model();
    static View view = new View();


    @BeforeClass
    public static void init() {
        model.setDepositesPrograms(new GeneratorTestData().testDataRead());
    }


    @Test
    public void profitSort() {
        assertTrue(view.depositProgramsToString(model.getSortedDeposits(DepositProgram.class, new DepositComparator())).equals("\n" +
                "Deposit program { name =Bujp, bank = BANK2, profit % = 3.93, replenishment = true, early withdrawal = true};\n" +
                "Deposit program { name =Geho, bank = BANK3, profit % = 3.29, replenishment = false, early withdrawal = true};\n" +
                "Deposit program { name =Zlli, bank = BANK4, profit % = 3.29, replenishment = true, early withdrawal = false};\n" +
                "Deposit program { name =Wqyb, bank = BANK3, profit % = 1.69, replenishment = false, early withdrawal = false};\n" +
                "Deposit program { name =Jtra, bank = BANK1, profit % = 1.31, replenishment = false, early withdrawal = false};\n" +
                "Deposit program { name =Uhli, bank = BANK1, profit % = 1.31, replenishment = true, early withdrawal = false};\n" +
                "Deposit program { name =Wnde, bank = BANK1, profit % = 1.31, replenishment = false, early withdrawal = true};\n" +
                "Deposit program { name =Bgwl, bank = BANK4, profit % = 1.31, replenishment = true, early withdrawal = true};\n" +
                "Deposit program { name =Nhcy, bank = BANK2, profit % = 0.94, replenishment = true, early withdrawal = true};"));
    }

    @Test
    public void profitAndReplenishmentSort() {
        boolean isReplenishment = true;

        assertTrue(view.depositProgramsToString(model.getSortedDeposits(DepositProgram.class, new DepositComparator(isReplenishment))).equals("\n" +
                "Deposit program { name =Bujp, bank = BANK2, profit % = 3.93, replenishment = true, early withdrawal = true};\n" +
                "Deposit program { name =Zlli, bank = BANK4, profit % = 3.29, replenishment = true, early withdrawal = false};\n" +
                "Deposit program { name =Geho, bank = BANK3, profit % = 3.29, replenishment = false, early withdrawal = true};\n" +
                "Deposit program { name =Wqyb, bank = BANK3, profit % = 1.69, replenishment = false, early withdrawal = false};\n" +
                "Deposit program { name =Uhli, bank = BANK1, profit % = 1.31, replenishment = true, early withdrawal = false};\n" +
                "Deposit program { name =Bgwl, bank = BANK4, profit % = 1.31, replenishment = true, early withdrawal = true};\n" +
                "Deposit program { name =Jtra, bank = BANK1, profit % = 1.31, replenishment = false, early withdrawal = false};\n" +
                "Deposit program { name =Wnde, bank = BANK1, profit % = 1.31, replenishment = false, early withdrawal = true};\n" +
                "Deposit program { name =Nhcy, bank = BANK2, profit % = 0.94, replenishment = true, early withdrawal = true};"));
    }

    @Test
    public void profitAndEarlyWithdrawalSort() {
        boolean isReplenishment = true;
        boolean isEarlyWithdrawal = true;

        assertTrue(view.depositProgramsToString(model.getSortedDeposits(DepositProgram.class, new DepositComparator(!isReplenishment, isEarlyWithdrawal))).equals("\n" +
                "Deposit program { name =Bujp, bank = BANK2, profit % = 3.93, replenishment = true, early withdrawal = true};\n" +
                "Deposit program { name =Geho, bank = BANK3, profit % = 3.29, replenishment = false, early withdrawal = true};\n" +
                "Deposit program { name =Zlli, bank = BANK4, profit % = 3.29, replenishment = true, early withdrawal = false};\n" +
                "Deposit program { name =Wqyb, bank = BANK3, profit % = 1.69, replenishment = false, early withdrawal = false};\n" +
                "Deposit program { name =Wnde, bank = BANK1, profit % = 1.31, replenishment = false, early withdrawal = true};\n" +
                "Deposit program { name =Bgwl, bank = BANK4, profit % = 1.31, replenishment = true, early withdrawal = true};\n" +
                "Deposit program { name =Jtra, bank = BANK1, profit % = 1.31, replenishment = false, early withdrawal = false};\n" +
                "Deposit program { name =Uhli, bank = BANK1, profit % = 1.31, replenishment = true, early withdrawal = false};\n" +
                "Deposit program { name =Nhcy, bank = BANK2, profit % = 0.94, replenishment = true, early withdrawal = true};"));
    }

    @Test
    public void profitAndReplenishmentAndEarlyWithdrawalSort() {
        boolean isReplenishment = true;
        boolean isEarlyWithdrawal = true;

        assertTrue(view.depositProgramsToString(model.getSortedDeposits(DepositProgram.class, new DepositComparator(isReplenishment, isEarlyWithdrawal))).equals("\n" +
                "Deposit program { name =Bujp, bank = BANK2, profit % = 3.93, replenishment = true, early withdrawal = true};\n" +
                "Deposit program { name =Geho, bank = BANK3, profit % = 3.29, replenishment = false, early withdrawal = true};\n" +
                "Deposit program { name =Zlli, bank = BANK4, profit % = 3.29, replenishment = true, early withdrawal = false};\n" +
                "Deposit program { name =Wqyb, bank = BANK3, profit % = 1.69, replenishment = false, early withdrawal = false};\n" +
                "Deposit program { name =Bgwl, bank = BANK4, profit % = 1.31, replenishment = true, early withdrawal = true};\n" +
                "Deposit program { name =Jtra, bank = BANK1, profit % = 1.31, replenishment = false, early withdrawal = false};\n" +
                "Deposit program { name =Uhli, bank = BANK1, profit % = 1.31, replenishment = true, early withdrawal = false};\n" +
                "Deposit program { name =Wnde, bank = BANK1, profit % = 1.31, replenishment = false, early withdrawal = true};\n" +
                "Deposit program { name =Nhcy, bank = BANK2, profit % = 0.94, replenishment = true, early withdrawal = true};"));
    }

}