package com.nashtech.finalcucumber.shared;

import com.nashtech.finalcucumber.pages.BasePage;
import com.nashtech.finalcucumber.pages.locators.CommonLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends BasePage {
    public String getUserName(){
        return getText(CommonLocators.LBL_USERNAME);
    }

    public void openProjectOptions(By ddlLink, By optionLink){
        clickElement(ddlLink);
        clickElement(optionLink);
    }


}
