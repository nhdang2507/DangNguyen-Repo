package com.nashtech.constants.locators;

import org.openqa.selenium.By;

public class StudentRegisterLocator {
    /**  Register Page **/
    public static final By TXT_FIRSTNAME = By.id("firstName");
    public static final By TXT_LASTNAME = By.id("lastName");
    public static final By TXT_EMAIL = By.id("userEmail");
    public static final By RDO_GENDER = By.xpath("//label[contains(@for, 'gender-radio')]");

    public static final By TXT_MOBILE = By.id("userNumber");
    public static final By DPK_BIRTHDATE = By.id("dateOfBirthInput");

    public static final By DTP_MONTH_YEAR = By.xpath("//div[contains(@class,'react-datepicker__current-month')]");
    public static final By DDL_MONTH = By.cssSelector(".react-datepicker__month-select");
    public static final By DDL_YEAR = By.cssSelector(".react-datepicker__year-select");
    public static By PICK_DAY (String text){
        return By.xpath(String.format("//div[contains(text(),'%s')]", text));
    }


    public static final By TXT_SUBJECT = By.id("subjectsInput");
    public static final By DDL_SUBJECT = By.xpath("//div[contains(@id, 'react-select-2-option')]");
    public static final By CHK_HOBBIES = By.xpath("//label[contains(@for, 'hobbies-checkbox')]");

    public static final By BTN_UPLOAD_PICTURE = By.id("uploadPicture");
    public static final By TXA_ADDRESS = By.id("currentAddress");

    public static final By DDL_STATE = By.id("state");
    public static final By LIST_STATE = By.xpath("//div[contains(@id, 'react-select-3-option')]");

    public static final By DDL_CITY = By.id("city");
    public static final By LIST_CITY = By.xpath("//div[contains(@id, 'react-select-4-option')]");

    public static final By BTN_SUBMIT = By.id("submit");
}
