package com.nashtech.finalcucumber.steps;

import com.nashtech.finalcucumber.constants.UrlConstants;
import com.nashtech.finalcucumber.pages.BasePage;
import com.nashtech.finalcucumber.pages.BookStorePage;
import com.nashtech.finalcucumber.pages.ProfilePage;
import com.nashtech.finalcucumber.utils.CookieUtil;
import com.nashtech.finalcucumber.utils.PropertiesFileUtil;
import com.nashtech.finalcucumber.utils.api.BookHelper;
import com.nashtech.finalcucumber.utils.api.UserHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class DeleteBookSteps {
    BookHelper bookHelper = new BookHelper();
    UserHelper userHelper = new UserHelper();
    BookStorePage bookStorePage = new BookStorePage();
    ProfilePage profilePage = new ProfilePage();

    @Given("^there is a book named Git Pocket Guide (.*)$")
    public void thereIsABookNamed(String isbn) {
        Response generate = userHelper.generateToken(PropertiesFileUtil.getProperty("USERNAME"), PropertiesFileUtil.getProperty("PASSWORD"));
        String userToken = generate.jsonPath().getString("token");
        Response response = bookHelper.addBookToCollection(userToken, PropertiesFileUtil.getProperty("USERID"), isbn);
        response.then().assertThat().statusCode(201);
    }
    @And("the user logs into the application")
    public void theUserLogsIntoTheApplication() {
        BasePage.navigate(UrlConstants.LOGIN_PAGE);
        Response response = userHelper.generateToken(PropertiesFileUtil.getProperty("USERNAME"), PropertiesFileUtil.getProperty("PASSWORD"));
        String userToken = response.jsonPath().getString("token");
        String expires = response.jsonPath().getString("expires");

        CookieUtil.addCookie("userID", PropertiesFileUtil.getProperty("USERID"));
        CookieUtil.addCookie("token", userToken);
        CookieUtil.addCookie("expires", expires);
        CookieUtil.addCookie("userName", PropertiesFileUtil.getProperty("USERNAME"));
    }
    @And("the user is on the Profile page")
    public void theUserIsOnTheProfilePage() {
        BasePage.navigate(UrlConstants.PROFILE_PAGE);
    }
    @When("^the user search book (.*)$")
    public void theUserSearchBook(String bookName) {
        bookStorePage.inputKeysSearch(bookName);
    }
    @And("the user clicks on Delete icon")
    public void theUserClicksOnDeleteIcon() {
        profilePage.deleteBook();
    }
    @And("the user clicks on OK button")
    public void theUserClickOnOKButton() {
        profilePage.clickVerifyDelete();
    }
    @And("^the user clicks on OK button of alert (.*)$")
    public void theUserClickOnOKButtonOfAlert(String alertMessage) {
        assertThat("Verify an alert is shown", BasePage.getTextOfAlert(), equalTo(alertMessage));
        BasePage.acceptAlert();
    }
    @And("^the book (.*) is not shown$")
    public void theBookIsNotShown(String bookName) {
        bookStorePage.inputKeysSearch(bookName);
        assertThat("Verify book is deleted", profilePage.notFoundBook(), equalTo(true));
    }
}
