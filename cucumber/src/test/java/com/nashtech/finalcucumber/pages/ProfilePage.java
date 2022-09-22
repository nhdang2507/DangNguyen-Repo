package com.nashtech.finalcucumber.pages;

import io.cucumber.java.bs.I;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage{
    /** ---------------- Web Elements -------------------- **/
    public static final By BTN_OK = By.id("closeSmallModal-ok");
    public static final By LNK_LOGIN = By.xpath("//a[@href='/login']");
    public static By ICON_DELETE_BOOK = By.xpath("//span[@id='delete-record-undefined']//*[name()='svg']");

    public static final By NO_ROWS_FOUND = By.xpath("//div[text()='No rows found']");
    /** ---------------- Page Methods-------------------- **/
    public void deleteBook(){
        clickElement(ICON_DELETE_BOOK);
    }

    public void clickVerifyDelete(){
        clickElement(BTN_OK);
    }

    public boolean notFoundBook(){
        return isElementPresent(NO_ROWS_FOUND);
    }
}
