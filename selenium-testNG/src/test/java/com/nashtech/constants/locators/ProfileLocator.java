package com.nashtech.constants.locators;

import org.openqa.selenium.By;

public class ProfileLocator {
    public static final By BTN_OK = By.id("closeSmallModal-ok");
    public static final By LNK_LOGIN = By.xpath("//a[@href='/login']");
    public static By LINK_BOOK (String text){
        return By.xpath(String.format("//a[text()='%s']/ancestor::div[@class='rt-tr-group']//div//div//span[@title='Delete']", text));
    }

    public static final By NO_ROWS_FOUND = By.xpath("//div[text()='No rows found']");
}
