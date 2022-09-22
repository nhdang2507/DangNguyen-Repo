package com.nashtech.pages;

import com.nashtech.constants.locators.InfoStudentLocator;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class InfoStudentPage extends BasePage{
    public InfoStudentPage(WebDriver driver) {
        super(driver);
    }

    public String getStudentName(){
        return getText(InfoStudentLocator.LBL_STUDENT_NAME);
    }

    public String getStudentEmail(){
        return getText(InfoStudentLocator.LBL_STUDENT_EMAIL);
    }

    public String getGender(){
        return getText(InfoStudentLocator.LBL_GENDER);
    }

    public String getMobile(){
        return getText(InfoStudentLocator.LBL_MOBILE);
    }

    public String getDateOfBirth(){
        String dateString = getText(InfoStudentLocator.LBL_DATE_OF_BIRTH);

        //Split dateString into day, month, year
        String[] resultDate = StringUtils.split(dateString, ",");
        String year = resultDate[1];

        String[] dayMonth = StringUtils.split(resultDate[0], " ");
        String day = dayMonth[0];
        String month = dayMonth[1];

        String expectDate = day + " " + month + " " + year;
        return expectDate;
    }

    public List<String> getSubjects(){
        String subjects = getText(InfoStudentLocator.LBL_SUBJECTS);
        String[] subject = StringUtils.split(subjects, ",");
        List<String> listSubjects = new ArrayList<>();
        listSubjects.add(subject[0]);
        listSubjects.add(subject[1].trim());
        return listSubjects;
    }

    public  List<String> getHobbies(){
        String listHobbies = getText(InfoStudentLocator.LBL_HOBBIES);
        String[] hobbies = StringUtils.split(listHobbies, ",");
        List<java.lang.String> listSubjects = new ArrayList<>();
        listSubjects.add(hobbies[0]);
        listSubjects.add(hobbies[1].trim());
        return listSubjects;
    }

    public String getPicture(){
        return getText(InfoStudentLocator.LBL_PICTURE);
    }

    public String getAddress(){
        return getText(InfoStudentLocator.LBL_ADDRESS);
    }

    public String getStateAndCity(){
        return getText(InfoStudentLocator.LBL_STATE_AND_CITY);
    }

}
