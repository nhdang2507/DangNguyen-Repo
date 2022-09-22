package com.nashtech.pages;

import com.nashtech.constants.locators.InfoBookLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class InfoBookPage extends BasePage{
    public InfoBookPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonAddBook(){
        WebElement element = driver.findElement(InfoBookLocator.BTN_ADD_BOOK);
        element.click();
    }

    public String getBookTitle(){
        return getText(InfoBookLocator.INFO_TITLE_BOOK);
    }
}
