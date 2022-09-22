package com.nashtech.finalcucumber.pages.modals;

import com.nashtech.finalcucumber.pages.RegisterStudentPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class StudentInformation extends RegisterStudentPage {
    /**----------------------Web Elements-------------------*/
    public static final By LBL_STUDENT_REGISTER_SUCCESSFULLY = By.xpath("//div[@id='example-modal-sizes-title-lg']");
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

    /**----------------------Web Elements-------------------*/
    public String getLblStudentRegisterSuccessfully(){
        return getText(LBL_STUDENT_REGISTER_SUCCESSFULLY);
    }

    public String getStudentName(){
        return getText(LBL_STUDENT_NAME);
    }

    public String getStudentEmail(){
        return getText(LBL_STUDENT_EMAIL);
    }

    public String getGender(){
        return getText(LBL_GENDER);
    }

    public String getMobile(){
        return getText(LBL_MOBILE);
    }

    public String getDateOfBirth(){
        String dateString = getText(LBL_DATE_OF_BIRTH);

        //Split dateString into day, month, year
        String[] resultDate = StringUtils.split(dateString, ",");
        String year = resultDate[1];

        String[] dayMonth = StringUtils.split(resultDate[0], " ");
        String day = dayMonth[0];
        String month = dayMonth[1];

        String expectDate = day + " " + month + " " + year;
        return expectDate;
    }

    public String getSubjects(){
        /*String subjects = getText(LBL_SUBJECTS);
        String[] subject = StringUtils.split(subjects, ",");
        List<String> listSubjects = new ArrayList<>();
        listSubjects.add(subject[0]);
        listSubjects.add(subject[1].trim());
        return listSubjects;*/
        return getText(LBL_SUBJECTS);
    }

    public String getHobbies(){
        /*String listHobbies = ;
        String[] hobbies = StringUtils.split(listHobbies, ",");
        List<java.lang.String> listSubjects = new ArrayList<>();
        listSubjects.add(hobbies[0]);
        listSubjects.add(hobbies[1].trim());
        return listSubjects;*/
        return getText(LBL_HOBBIES);
    }

    public String getPicture(){
        return getText(LBL_PICTURE);
    }

    public String getAddress(){
        return getText(LBL_ADDRESS);
    }

    public String getStateAndCity(){
        waitForVisibilityOfElementLocated(By.id("closeLargeModal"));
        return getText(LBL_STATE_AND_CITY);
    }
}
