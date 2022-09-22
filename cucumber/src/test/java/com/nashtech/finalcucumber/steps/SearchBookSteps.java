package com.nashtech.finalcucumber.steps;

import com.nashtech.finalcucumber.constants.UrlConstants;
import com.nashtech.finalcucumber.context.ScenarioContext;
import com.nashtech.finalcucumber.pages.BasePage;
import com.nashtech.finalcucumber.pages.BookStorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class SearchBookSteps {
    BookStorePage bookStorePage = new BookStorePage();
    ScenarioContext scenarioContext;

    public SearchBookSteps(ScenarioContext context) {
        scenarioContext = context;
    }

    @Given("there are books named “Learning JavaScript Design Patterns” and “Designing Evolvable Web APIs with ASP.NET”")
    public void findBooks(){
    }
    @And("the user is on the Book Store page")
    public void theUserIsOnTheBookStorePage() throws AWTException {
        BasePage.navigate(UrlConstants.BOOKS_PAGE);
        BasePage.zoomOutBrowser();
    }
    @When("^the user inputs book name (.*)$")
    public void theUserInputsBookNameToSearch(String keys){
        bookStorePage.inputKeysSearch(keys);
    }
    @Then("all books match with input criteria will be displayed")
    public void allBooksMatchWithInputCriteriaWillBeDisplayed(){
        List<WebElement> bookSearchResults = bookStorePage.getAllSearchResult();

        for(int i = 1; i <= Integer.parseInt(bookStorePage.getTotalPage()); i++){
            //Verify each project in Search results section
            for(WebElement book : bookSearchResults) {
                assertThat("Verify Book Name", bookStorePage.getBookName(book),
                        containsStringIgnoringCase("Design"));
            }
        }
    }
}
