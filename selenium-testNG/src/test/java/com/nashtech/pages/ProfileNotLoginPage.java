package com.nashtech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileNotLoginPage extends BasePage{
    public ProfileNotLoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink(By locator){
        clickElement(locator);
    }
}
