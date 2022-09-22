package com.nashtech.pages;

import com.nashtech.constants.locators.ProfileLocator;
import com.nashtech.constants.locators.SearchBookLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;

public class ProfilePage extends BasePage{
    SearchBookResults searchBookResults;
    public ProfilePage(WebDriver driver) {
        super(driver);
        searchBookResults = new SearchBookResults(driver);

    }

    public void deleteBook(String name){
        WebElement element = driver.findElement(ProfileLocator.LINK_BOOK(name));
        element.click();
    }

    public void inputKeysSearch(String keys){
        inputText(SearchBookLocator.SEARCH_BOX_BOOK, keys);
    }

    public void clickVerifyDelete(){
        clickElement(ProfileLocator.BTN_OK);
    }

    /** Search results **/
    public boolean searchResults(String option){
        List<WebElement> bookSearchResults = searchBookResults.findAllElements(SearchBookLocator.LIST_TITLE_RESULTS);

        for(WebElement book : bookSearchResults) {
            if(book.getText().equals(option)){
                return true;
            }
        }
        return false;
    }
}
