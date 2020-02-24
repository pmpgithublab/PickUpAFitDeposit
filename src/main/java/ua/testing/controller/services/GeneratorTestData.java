/*
 * @(#)GeneratorTestData.java     1.00 2020/02/14
 *
 * This software is free for use.
 */

package ua.testing.controller.services;


import ua.testing.model.entity.AccountProgram;
import ua.testing.model.entity.Bank;
import ua.testing.model.entity.DepositProgram;

import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Class for test data generation.
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public class GeneratorTestData {

    public Set<AccountProgram> testDepositGenerate(int count) {
        Set<AccountProgram> result = new HashSet<>();
        Random random = new Random(System.currentTimeMillis());
        while (result.size() < count) {
            result.add(new DepositProgram(nameGeneration(3),
                    Bank.values()[random.nextInt(Bank.values().length - 1)],
                    //Math.abs(random.nextDouble() * 10 - 5),
                    random.nextInt(6),
                    random.nextBoolean(),
                    random.nextBoolean()));
        }
        return result;
    }

    private String nameGeneration(int lettersCount) {
        if (lettersCount < 4) {
            lettersCount = 4;
        }
        StringBuilder result = new StringBuilder();
        try {
            TimeUnit.MILLISECONDS.sleep(50); //else all names are the same
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < lettersCount; i++) {
            result.append((char) (random.nextInt(26) + 'a'));
        }
        return result.replace(0, 1, result.substring(0, 1).toUpperCase()).toString();
    }

    public Set<AccountProgram> testDataRead() {
        Set<AccountProgram> result = new HashSet<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("DataSource.txt"))) {
            while (true) {
                if (((line = bufferedReader.readLine()) != null)) {
                    result.add(createItem(line));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private DepositProgram createItem(String toParse) {
        String[] data = toParse.split(",");
        if (data.length == 5) {
            return new DepositProgram(data[0], Bank.valueOf(data[1]), Integer.parseInt(data[2]), Boolean.parseBoolean(data[3]), Boolean.parseBoolean(data[4]));
        }
        return null;
    }
}
