package com.nashtech.constants.locators;

import org.openqa.selenium.By;

public class InfoBookLocator {
    public static final By INFO_TITLE_BOOK = By.xpath("//div[@id='title-wrapper']//label[@id='userName-value']");
    public static final By BTN_ADD_BOOK = By.xpath("//button[text()='Add To Your Collection']");
}

