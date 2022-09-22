package com.nashtech.pages;

import com.nashtech.models.Students;
import com.nashtech.constants.locators.StudentRegisterLocator;
import com.nashtech.shared.DatePicker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StudentRegisterPage extends BasePage{
    DatePicker datePicker;
    Students students;

    public StudentRegisterPage(WebDriver driver) {
        super(driver);
        datePicker = new DatePicker(driver);
    }

    public void inputFirstName(String firstname){
        inputText(StudentRegisterLocator.TXT_FIRSTNAME, firstname);
    }

    public void inputLastName(String lastname){
        inputText(StudentRegisterLocator.TXT_LASTNAME, lastname);
    }

    public void inputEmail(String email){
        inputText(StudentRegisterLocator.TXT_EMAIL, email);
    }

    public void selectGender(String gender){
        selectRadioOption(gender);
    }

    public void inputMobile(String mobile){
        inputText(StudentRegisterLocator.TXT_MOBILE, mobile);
    }

    public void selectBirthDate(String date){
        clickElement(StudentRegisterLocator.DPK_BIRTHDATE);
        datePicker.selectDate(date);
    }

    public void selectSubjects(List<String> option) {
        for(int i = 0; i < option.size(); i++){
            inputText(StudentRegisterLocator.TXT_SUBJECT, option.get(i));
            List<WebElement> allOptions = findAllElements(StudentRegisterLocator.DDL_SUBJECT);
            for (WebElement options : allOptions){
                if(getText(options).equals(option.get(i))){
                    options.click();
                }
                break;
            }
        }
    }

    public void selectHobbies(List<String> option){
        List<WebElement> allOptions = findAllElements(StudentRegisterLocator.CHK_HOBBIES);
        for(int i = 0; i < option.size(); i++){
            for (WebElement options : allOptions){
                if(getText(options).equals(option.get(i))){
                    options.click();
                }
            }
        }
    }

    public void uploadPicture(String path){
        WebElement element = driver.findElement(StudentRegisterLocator.BTN_UPLOAD_PICTURE);
        element.sendKeys(System.getProperty("user.dir") + path);
    }

    public void inputAddress(String address){
        inputText(StudentRegisterLocator.TXA_ADDRESS, address);
    }

    public void selectState(String option) {
        WebElement element = driver.findElement(StudentRegisterLocator.DDL_STATE);
        element.click();
        List<WebElement> allOptions = findAllElements(StudentRegisterLocator.LIST_STATE);
        for (WebElement options : allOptions){
            if(getText(options).equals(option)){
                options.click();
            }
            break;
        }
    }

    public void selectCity(String option){
        WebElement element = driver.findElement(StudentRegisterLocator.DDL_CITY);
        element.click();
        List<WebElement> allOptions = findAllElements(StudentRegisterLocator.LIST_CITY);
        for (WebElement options : allOptions){
            if(getText(options).equals(option)){
                options.click();
            }
            break;
        }
    }

    public void clickSubmitButton(){
        clickElement(StudentRegisterLocator.BTN_SUBMIT);
    }
}
