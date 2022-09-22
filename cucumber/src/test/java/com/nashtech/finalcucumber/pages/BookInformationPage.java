package com.nashtech.finalcucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookInformationPage extends BasePage{
    public static final By BTN_ADD_BOOK = By.xpath("//button[text()='Add To Your Collection']");
    public void clickButtonAddBook(){
       clickElement(BTN_ADD_BOOK);
    }
}
