package com.nashtech.shared;

import com.nashtech.constants.locators.LoginLocator;
import com.nashtech.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends BasePage {

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public String getUserName(){
        return getText(LoginLocator.LBL_USERNAME);
    }

    public void openProjectOptions(By ddlLink, By optionLink){
        clickElement(ddlLink);
        clickElement(optionLink);
    }
}
