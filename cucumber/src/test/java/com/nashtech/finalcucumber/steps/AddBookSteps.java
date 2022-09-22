package com.nashtech.finalcucumber.steps;

import com.nashtech.finalcucumber.constants.UrlConstants;
import com.nashtech.finalcucumber.pages.BasePage;
import com.nashtech.finalcucumber.pages.BookInformationPage;
import com.nashtech.finalcucumber.pages.BookStorePage;
import com.nashtech.finalcucumber.pages.ProfilePage;
import com.nashtech.finalcucumber.utils.CookieUtil;
import com.nashtech.finalcucumber.utils.PropertiesFileUtil;
import com.nashtech.finalcucumber.utils.api.BookHelper;
import com.nashtech.finalcucumber.utils.api.UserHelper;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddBookSteps {
    UserHelper userHelper = new UserHelper();
    BookHelper bookHelper = new BookHelper();
    BookStorePage bookStorePage = new BookStorePage();
    BookInformationPage bookInformationPage = new BookInformationPage();
    ProfilePage profilePage = new ProfilePage();

    @Given("the user logs into application")
    public void theUserLogsIntoApplication(){
        BasePage.navigate(UrlConstants.LOGIN_PAGE);
        Response response = userHelper.generateToken(PropertiesFileUtil.getProperty("USERNAME"), PropertiesFileUtil.getProperty("PASSWORD"));
        String userToken = response.jsonPath().getString("token");
        String expires = response.jsonPath().getString("expires");

        CookieUtil.addCookie("userID", PropertiesFileUtil.getProperty("USERID"));
        CookieUtil.addCookie("token", userToken);
        CookieUtil.addCookie("expires", expires);
        CookieUtil.addCookie("userName", PropertiesFileUtil.getProperty("USERNAME"));
    }
    @And("the user is on Book Store page")
    public void theUserIsOnBookStorePage(){
        BasePage.navigate(UrlConstants.BOOKS_PAGE);
    }
    @When("^the user selects a book (.*)$")
    public void theUserSelectsABook(String bookName){
        bookStorePage.selectBook(bookName);
    }

    @And("the user clicks on Add To Your Collection")
    public void theUserClicksOnAddToYourCollection() throws AWTException {
        BasePage.zoomOutBrowser();
        bookInformationPage.clickButtonAddBook();
    }
    @Then("^an alert (.*) is shown$")
    public void anAlertIsShown(String alertMessage){
        assertThat("Verify an alert is shown", BasePage.getTextOfAlert(), equalTo(alertMessage));
        BasePage.acceptAlert();
    }
    @And("^book (.*) is shown in your profile$")
    public void bookIsShownInYourProfile(String bookName){
        BasePage.navigate(UrlConstants.PROFILE_PAGE);
        List<WebElement> bookSearchResults = bookStorePage.getAllSearchResult();

        for(int i = 1; i <= Integer.parseInt(bookStorePage.getTotalPage()); i++){
            //Verify each project in Search results section
            for(WebElement book : bookSearchResults) {
                assertThat("Verify Book Name", bookStorePage.getBookName(book),
                        equalTo(bookName));
            }
        }
    }

    @After("@Add_book_successfully")
    public void afterThird(){
        Response response = userHelper.generateToken(PropertiesFileUtil.getProperty("USERNAME"), PropertiesFileUtil.getProperty("PASSWORD"));
        String userToken = response.jsonPath().getString("token");

        Response deleteBook = bookHelper.deleteABook(userToken, PropertiesFileUtil.getProperty("USERID"), "9781449325862");
        deleteBook.then().assertThat().statusCode(204);
    }
}
