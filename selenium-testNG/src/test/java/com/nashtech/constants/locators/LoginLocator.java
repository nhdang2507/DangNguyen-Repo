package com.nashtech.constants.locators;

import org.openqa.selenium.By;

public class LoginLocator {
    /** Login Page **/
    public static final By TXT_USERNAME = By.id("userName");
    public static final By TXT_PASSWORD = By.id("password");
    public static final By BTN_LOGIN = By.id("login");
    public static final By LBL_USERNAME = By.id("userName-value");
    public static final By LNK_LOGIN = By.cssSelector("a[href='/login']");
}
