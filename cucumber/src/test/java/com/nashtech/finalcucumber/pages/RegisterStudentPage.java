package com.nashtech.finalcucumber.pages;

import com.nashtech.finalcucumber.shared.DatePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.nashtech.finalcucumber.steps.StepHook.driver;

public class RegisterStudentPage extends BasePage{
    /** ---------------- Web Elements-------------------- **/
    public static final By TXT_FIRSTNAME = By.id("firstName");
    public static final By TXT_LASTNAME = By.id("lastName");
    public static final By TXT_EMAIL = By.id("userEmail");
    public static final By RDO_GENDER = By.xpath("//label[contains(@for, 'gender-radio')]");

    public static final By TXT_MOBILE = By.id("userNumber");
    public static final By DPK_BIRTHDATE = By.id("dateOfBirthInput");

    public static final By DTP_MONTH_YEAR = By.xpath("//div[contains(@class,'react-datepicker__current-month')]");
    public static final By DDL_MONTH = By.cssSelector(".react-datepicker__month-select");
    public static final By DDL_YEAR = By.cssSelector(".react-datepicker__year-select");


    public static final By TXT_SUBJECT = By.id("subjectsInput");

    public static By TICK_HOBBIES (String hobbies){
        return By.xpath(String.format("//label[contains(text(), '%s')]", hobbies));
    }

    public static final By BTN_UPLOAD_PICTURE = By.id("uploadPicture");
    public static final By TXA_ADDRESS = By.id("currentAddress");

    public static final By DDL_STATE = By.id("state");
    public static final By LIST_STATE = By.xpath("//div[contains(@id, 'react-select-3-option')]");

    public static final By DDL_CITY = By.id("city");
    public static final By LIST_CITY = By.xpath("//div[contains(@id, 'react-select-4-option')]");

    public static final By BTN_SUBMIT = By.id("submit");

    /**---------------------Page Methods---------------------*/
    DatePicker datePicker = new DatePicker();

    public void inputFirstName(String firstname){
        inputText(TXT_FIRSTNAME, firstname);
    }

    public void inputLastName(String lastname){
        inputText(TXT_LASTNAME, lastname);
    }

    public void inputEmail(String email){
        inputText(TXT_EMAIL, email);
    }

    public void selectGender(String gender){
        selectRadioOption(RDO_GENDER, gender);
    }

    public void inputMobile(String mobile){
        inputText(TXT_MOBILE, mobile);
    }

    public void selectBirthDate(String date){
        clickElement(DPK_BIRTHDATE);
        datePicker.selectDate(date);
    }

    public void selectSubjects(String subjects) {
        String[] option = subjects.split(",");
        for(int i = 0; i < option.length; i++){
            inputText(TXT_SUBJECT, option[i]);
            sendKeys(TXT_SUBJECT, Keys.ENTER);
        }
    }

    public void selectHobbies(String hobbies){
        String[] option = hobbies.split(",");
        for(int i = 0; i < option.length; i++){
            clickElement(TICK_HOBBIES(option[i]));
        }
    }

    public void uploadPicture(String path){
        WebElement element = driver.findElement(BTN_UPLOAD_PICTURE);
        element.sendKeys(System.getProperty("user.dir") + path);
    }

    public void inputAddress(String address){
        inputText(TXA_ADDRESS, address);
    }

    public void selectState(String option) {
        WebElement element = driver.findElement(DDL_STATE);
        element.click();
        List<WebElement> allOptions = findAllElements(LIST_STATE);
        for (WebElement options : allOptions){
            if(getText(options).equals(option)){
                options.click();
            }
            break;
        }
    }

    public void selectCity(String option){
        WebElement element = driver.findElement(DDL_CITY);
        element.click();
        List<WebElement> allOptions = findAllElements(LIST_CITY);
        for (WebElement options : allOptions){
            if(getText(options).equals(option)){
                options.click();
            }
            break;
        }
    }

    public void clickSubmitButton(){
        clickElement(BTN_SUBMIT);
    }
}
