package com.nashtech.finalcucumber.steps;

import com.nashtech.finalcucumber.constants.UrlConstants;
import com.nashtech.finalcucumber.context.ScenarioContext;
import com.nashtech.finalcucumber.models.Student;
import com.nashtech.finalcucumber.pages.BasePage;
import com.nashtech.finalcucumber.pages.RegisterStudentPage;
import com.nashtech.finalcucumber.pages.modals.StudentInformation;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.*;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegisterStudentSteps {
    RegisterStudentPage registerStudentPage = new RegisterStudentPage();
    StudentInformation studentInformation = new StudentInformation();
    ScenarioContext scenarioContext;
    Student student;

    public RegisterStudentSteps(ScenarioContext context) {
        scenarioContext = context;
    }

    @DataTableType
    public Student studentEntry(Map<String, String> studentInfo){
        return new Student(
                studentInfo.get("First Name"),
                studentInfo.get("Last Name"),
                studentInfo.get("Email"),
                studentInfo.get("Gender"),
                studentInfo.get("Mobile"),
                studentInfo.get("Date of Birth"),
                studentInfo.get("Subjects"),
                studentInfo.get("Hobbies"),
                studentInfo.get("Picture"),
                studentInfo.get("Current Address"),
                studentInfo.get("State"),
                studentInfo.get("City")
        );
    }

    @Given("the user is on Student Registration Form")
    public void theUserIsOnStudentRegistrationForm() throws AWTException {
        BasePage.navigate(UrlConstants.STUDENT_REGISTER_PAGE);
        BasePage.zoomOutBrowser();
    }
    @When("the user input valid data into all fields")
    public void theUserInputValidDataIntoAllFields(List<Student> data){
        student = data.get(0);
        scenarioContext.setContext("info", student);

        if (student.firstName != null) registerStudentPage.inputFirstName(student.firstName);
        if (student.lastName != null) registerStudentPage.inputLastName(student.lastName);
        if (student.email != null) registerStudentPage.inputEmail(student.email);
        if (student.gender != null) registerStudentPage.selectGender(student.gender);
        if (student.mobile != null) registerStudentPage.inputMobile(student.mobile);
        if (student.dateOfBirth != null) registerStudentPage.selectBirthDate(student.dateOfBirth);
        if (student.subjects != null) registerStudentPage.selectSubjects(student.subjects);
        if (student.hobbies != null) registerStudentPage.selectHobbies(student.hobbies);
        if (student.picture != null) registerStudentPage.uploadPicture(student.picture);
        if (student.address != null) registerStudentPage.inputAddress(student.address);
        if (student.state != null) registerStudentPage.selectState(student.state);
        if (student.city != null) registerStudentPage.selectCity(student.city);

    }
    @And("the user clicks on Submit button")
    public void theUserClicksOnSubmitButton(){
        registerStudentPage.clickSubmitButton();
    }
    @Then("a successful message 'Thanks for submitting the form' is shown")
    public void successfulMessageIsShown(){
        assertThat("Verify successful message is correct", studentInformation.getLblStudentRegisterSuccessfully(),(equalTo("Thanks for submitting the form")));
    }
    @And("all information of the student form is shown correctly")
    public void allInformationOfTheStudentFormIsShownCorrectly(){
        Student student = scenarioContext.getContext("info", Student.class);

        if (student.firstName != null && student.lastName != null) assertThat("Verify student name", studentInformation.getStudentName(), equalTo( student.firstName + " " + student.lastName));
        if (student.email != null) assertThat("Verify student email", studentInformation.getStudentEmail(), equalTo(student.email));
        if (student.gender != null) assertThat("Verify gender", studentInformation.getGender(), equalTo(student.gender));
        if (student.mobile != null) assertThat("Verify mobile", studentInformation.getMobile(), equalTo(student.mobile));
        if (student.dateOfBirth != null) assertThat("Verify date of birth", studentInformation.getDateOfBirth(), equalTo(student.dateOfBirth));
        if (student.subjects != null) assertThat("Verify subjects", studentInformation.getSubjects(), equalTo(student.subjects));
        if (student.hobbies != null) assertThat("Verify hobbies", studentInformation.getHobbies(), equalTo(student.hobbies));
        if (student.picture != null) assertThat("Verify picture", studentInformation.getPicture(), equalTo(Paths.get(student.picture).getFileName().toString()));
        if (student.address != null) assertThat("Verify address", studentInformation.getAddress(), equalTo(student.address));
        if (student.state != null && student.city != null) assertThat("Verify state and city", studentInformation.getStateAndCity(), equalTo(student.state + " " + student.city));
    }
}
