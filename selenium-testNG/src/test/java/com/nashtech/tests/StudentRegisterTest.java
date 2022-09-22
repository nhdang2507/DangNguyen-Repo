package com.nashtech.tests;

import com.nashtech.models.Students;
import com.nashtech.constants.UrlConstants;
import com.nashtech.pages.InfoStudentPage;
import com.nashtech.pages.StudentRegisterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileNotFoundException;

import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StudentRegisterTest extends BaseTest{
    StudentRegisterPage registerPage;
    InfoStudentPage infoStudentPage;

    @BeforeMethod
    public void beforeMethod() throws AWTException {
        registerPage = new StudentRegisterPage(driver);
        infoStudentPage = new InfoStudentPage(driver);
        registerPage.navigate(UrlConstants.STUDENT_REGISTER_URL);
        registerPage.zoomOutBrowser();
    }

    @Test
    public void registerStudentAllFieldsSuccessfully() throws FileNotFoundException {
        Students students = Students.getStudentData();

        registerPage.inputFirstName(students.getFirstName());
        registerPage.inputLastName(students.getLastName());
        registerPage.inputEmail(students.getUserEmail());
        registerPage.selectGender(students.getGender());
        registerPage.inputMobile(students.getMobile());
        registerPage.selectBirthDate(students.getDateOfBirth());
        registerPage.selectSubjects(students.getSubjects());
        registerPage.selectHobbies(students.getHobbies());
        registerPage.uploadPicture(students.getPicturePath());
        registerPage.inputAddress(students.getAddress());
        registerPage.selectState(students.getState());
        registerPage.selectCity(students.getCity());

        registerPage.clickSubmitButton();

        assertThat("Verify student name",infoStudentPage.getStudentName(),
                equalTo(students.getFirstName() + " " + students.getLastName()));
        assertThat("Verify student email", infoStudentPage.getStudentEmail(), equalTo(students.getUserEmail()));
        assertThat("Verify gender", infoStudentPage.getGender(), equalTo(students.getGender()));
        assertThat("Verify mobile", infoStudentPage.getMobile(), equalTo(students.getMobile()));
        assertThat("Verify date of birth", infoStudentPage.getDateOfBirth(), equalTo(students.getDateOfBirth()));
        assertThat("Verify subjects", infoStudentPage.getSubjects(), equalTo(students.getSubjects()));
        assertThat("Verify hobbies", infoStudentPage.getHobbies(), equalTo(students.getHobbies()));
        assertThat("Verify picture", infoStudentPage.getPicture(), equalTo(Paths.get(students.getPicturePath()).getFileName().toString()));
        assertThat("Verify address", infoStudentPage.getAddress(), equalTo(students.getAddress()));
        assertThat("Verify state and city", infoStudentPage.getStateAndCity(), equalTo(students.getState() + " " + students.getCity()));
    }

    @Test
    public void registerStudentMandatoryFieldsSuccessfully() throws FileNotFoundException {
        Students students = Students.getStudentData();

        registerPage.inputFirstName(students.getFirstName());
        registerPage.inputLastName(students.getLastName());
        registerPage.selectGender(students.getGender());
        registerPage.inputMobile(students.getMobile());

        registerPage.clickSubmitButton();

        assertThat("Verify student name",infoStudentPage.getStudentName(),
                equalTo(students.getFirstName() + " " + students.getLastName()));
        assertThat("Verify gender", infoStudentPage.getGender(), equalTo(students.getGender()));
        assertThat("Verify mobile", infoStudentPage.getMobile(), equalTo(students.getMobile()));
    }
}
