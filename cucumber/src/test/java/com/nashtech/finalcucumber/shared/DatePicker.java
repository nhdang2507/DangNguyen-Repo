package com.nashtech.finalcucumber.shared;

import com.nashtech.finalcucumber.pages.BasePage;
import com.nashtech.finalcucumber.pages.RegisterStudentPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

public class DatePicker extends BasePage {
    public void selectDate(String dateString) {
        //Split dateString into day, month, year
        String[] expectDate = StringUtils.split(dateString, " ");

        /** Select year */
        //Get expected year
        int expectedYear = Integer.parseInt(expectDate[2]);

        //Get and split into current month, year of date picker
        String[] currentMonthYear = StringUtils.split(getText(RegisterStudentPage.DTP_MONTH_YEAR), " ");
        //Get current year of date picker
        int currentYear = Integer.parseInt(currentMonthYear[1]);

        selectDropdownOption(RegisterStudentPage.DDL_YEAR, expectDate[2]);

        /** Select month */
        //Get expected month
        String expectedMonth = expectDate[1];

        //Get current month of date picker
        String currentMonth = currentMonthYear[0].substring(0, 3); //Get only first 3 chars

        if (!currentMonth.equals(expectedMonth)) {
            //Click on month in date picker
            selectDropdownOption(RegisterStudentPage.DDL_MONTH, expectedMonth);
        }

        /** Select day */
        //Get expected day
        String expectedDay = expectDate[0];
        //Click on day in date picker
        clickElement(By.xpath("//div[contains(text(),'" + expectedDay + "')]"));
    }
}
