package com.nashtech.shared;

import com.nashtech.constants.locators.LoginLocator;
import com.nashtech.constants.locators.StudentRegisterLocator;
import com.nashtech.pages.BasePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DatePicker extends BasePage {
    public DatePicker(WebDriver driver) {
        super(driver);
    }

    public void selectDate(String dateString) {
        //Split dateString into day, month, year
        String[] expectDate = StringUtils.split(dateString, " ");

        selectDropdownOptionWithTagSelect(StudentRegisterLocator.DDL_YEAR, expectDate[2]);

        selectDropdownOptionWithTagSelect(StudentRegisterLocator.DDL_MONTH, expectDate[1]);

        String expectedDay = expectDate[0];
        //Click on day in date picker
        clickElement(StudentRegisterLocator.PICK_DAY(expectedDay));


//        /** Select year */
//        //Get expected year
//        int expectedYear = Integer.parseInt(expectDate[2]);
//
//        //Get and split into current month, year of date picker
//        String[] currentMonthYear = StringUtils.split(getText(StudentRegisterLocator.DTP_MONTH_YEAR), " ");
//        //Get current year of date picker
//        int currentYear = Integer.parseInt(currentMonthYear[1]);
//
//        selectDropdownOptionWithTagSelect(StudentRegisterLocator.DDL_YEAR, expectDate[2]);
//
//        /** Select month */
//        //Get expected month
//        String expectedMonth = expectDate[1];
//
//        //Get current month of date picker
//        String currentMonth = currentMonthYear[0].substring(0, 3); //Get only first 3 chars
//
//        if (!currentMonth.equals(expectedMonth)) {
//            //Click on month in date picker
//            selectDropdownOptionWithTagSelect(StudentRegisterLocator.DDL_MONTH, expectedMonth);
//        }
//
//        /** Select day */
//        //Get expected day
//        String expectedDay = expectDate[0];
//        //Click on day in date picker
//        clickElement(By.xpath("//div[contains(text(),'" + expectedDay + "')]"));
    }
}
