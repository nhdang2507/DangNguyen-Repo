package com.nashtech.constants.locators;

import org.openqa.selenium.By;

public class InfoStudentLocator {
    public static final By LBL_STUDENT_NAME = By.xpath("//tbody//td[text()='Student Name']/following-sibling::td");
    public static final By LBL_STUDENT_EMAIL = By.xpath("//tbody//td[text()='Student Email']/following-sibling::td");
    public static final By LBL_GENDER = By.xpath("//tbody//td[text()='Gender']/following-sibling::td");
    public static final By LBL_MOBILE = By.xpath("//tbody//td[text()='Mobile']/following-sibling::td");
    public static final By LBL_DATE_OF_BIRTH = By.xpath("//tbody//td[text()='Date of Birth']/following-sibling::td");
    public static final By LBL_SUBJECTS = By.xpath("//tbody//td[text()='Subjects']/following-sibling::td");
    public static final By LBL_HOBBIES = By.xpath("//tbody//td[text()='Hobbies']/following-sibling::td");
    public static final By LBL_PICTURE = By.xpath("//tbody//td[text()='Picture']/following-sibling::td");
    public static final By LBL_ADDRESS = By.xpath("//tbody//td[text()='Address']/following-sibling::td");
    public static final By LBL_STATE_AND_CITY = By.xpath("//tbody//td[text()='State and City']/following-sibling::td");
}
