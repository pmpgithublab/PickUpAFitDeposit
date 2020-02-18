/*
 * @(#)ResourceManager.java     1.00 2020/02/14
 *
 * This software is free for use.
 */
package ua.testing.view.entity;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Localization manager class
 *
 * @author Firstname Lastname
 * @version 1.00 11 Feb 2020
 */
public enum ResourceManager {

    INSTANCE;
    private ResourceBundle resourceBundle;
    private static final String PROPERTIES_FILE_NAME = "properties";

    ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(PROPERTIES_FILE_NAME, Locale.getDefault());
    }

    public void changeLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(PROPERTIES_FILE_NAME, locale);
    }

    public String getLocaleProperty(String key) {
        return resourceBundle.getString(key);
    }

}
