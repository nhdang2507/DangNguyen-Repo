package com.nashtech.finalcucumber.utils;

import org.openqa.selenium.Cookie;

import static com.nashtech.finalcucumber.steps.StepHook.driver;

public class CookieUtil {
    public static void addCookie(String name, String value) {
        driver.manage().addCookie(new Cookie(name, value));
    }
}
