package com.nashtech.pages;

import com.nashtech.constants.locators.SearchBookLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchBookResults extends BasePage{
    public SearchBookResults(WebDriver driver) {
        super(driver);
    }

    public String getBookName(WebElement book) {
        return getText(book.findElement(SearchBookLocator.LIST_LNK_BOOK_NAME_RESULTS));
    }
}
