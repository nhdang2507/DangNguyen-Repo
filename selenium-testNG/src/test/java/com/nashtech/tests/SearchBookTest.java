package com.nashtech.tests;

import com.nashtech.models.Books;
import com.nashtech.constants.UrlConstants;
import com.nashtech.constants.locators.SearchBookLocator;
import com.nashtech.pages.BookStorePage;

import com.nashtech.pages.SearchBookResults;
import com.nashtech.shared.NavigationBar;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchBookTest extends BaseTest{
    SearchBookResults searchBookResults;
    BookStorePage bookStorePage;
    NavigationBar navigationBar;

    @BeforeMethod
    public void beforeMethod() {
        navigationBar = new NavigationBar(driver);
        searchBookResults = new SearchBookResults(driver);
        bookStorePage = new BookStorePage(driver);

        navigationBar.navigate(UrlConstants.BOOK_STORE_URL);
    }

    @Test
    public void SearchBookSuccessfully() throws FileNotFoundException {
        Books books = Books.getBookData();
        bookStorePage.inputKeysSearch(books.getKeysSearchBook());

        List<WebElement> bookSearchResults = searchBookResults.findAllElements(SearchBookLocator.LIST_SEARCH_RESULTS);

        for(int i = 1; i <= Integer.parseInt(bookStorePage.getText(SearchBookLocator.TOTAL_OF_PAGE)); i++){
            //Verify each project in Search results section
            for(WebElement book : bookSearchResults) {
                assertThat("Verify Book Name", searchBookResults.getBookName(book),
                        containsStringIgnoringCase(books.getKeysSearchBook()));
            }
        }
    }
}
