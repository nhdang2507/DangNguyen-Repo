package com.nashtech.pages;

import com.nashtech.constants.locators.BookStoreLocator;
import com.nashtech.constants.locators.SearchBookLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStorePage extends BasePage{
    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    /** Add Book **/
    public void selectBook(String book){
        WebElement element = driver.findElement(BookStoreLocator.LINK_BOOK(book));
        element.click();
    }

    /** Search Books **/
    public void inputKeysSearch(String keys){
        inputText(SearchBookLocator.SEARCH_BOX_BOOK, keys);
    }
}
