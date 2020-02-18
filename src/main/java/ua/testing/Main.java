/*
 * @(#)Main.java     1.00 2020/02/14
 *
 * This software is free for use.
 */


package ua.testing;


import ua.testing.controller.Controller;
import ua.testing.model.Model;
import ua.testing.view.View;

/**
 * Main class for start this application.
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 * <p>
 * Task description:
 * 16. Вклады. Сформировать набор предложений клиенту по вкладам
 * различных банков для оптимального выбора. Учитывать возможность
 * досрочного снятия кредита и\или пополнения. Реализовать поиск и
 * сортировку вкладов.
 */
public class Main {

    public static void main(String[] args) {

        new Controller(new Model(), new View()).processing();

    }

}
