package com.nashtech.pages;

import com.nashtech.models.Users;
import com.nashtech.constants.locators.LoginLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {super(driver);
    }

    public void inputUserName(String username){
        inputText(LoginLocator.TXT_USERNAME, username);
    }

    public void inputPassword(String password){
        inputText(LoginLocator.TXT_PASSWORD, password);
    }

    public void clickBtnLogin(){
        clickElement(LoginLocator.BTN_LOGIN);
    }

    public String getErrorMessage(By locator){
        return getText(locator);
    }

    public void loginSuccessfully() throws FileNotFoundException {
        inputUserName(System.getProperty("USERNAME"));
        inputPassword(System.getProperty("PASSWORD"));
        clickBtnLogin();
    }
}
