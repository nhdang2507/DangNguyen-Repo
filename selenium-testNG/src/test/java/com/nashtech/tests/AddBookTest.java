package com.nashtech.tests;

import com.nashtech.constants.locators.SearchBookLocator;
import com.nashtech.models.Books;
import com.nashtech.constants.locators.LoginLocator;
import com.nashtech.constants.UrlConstants;
import com.nashtech.pages.*;
import com.nashtech.shared.NavigationBar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.awt.*;
import java.io.FileNotFoundException;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AddBookTest extends BaseTest{
    BookStorePage bookStorePage;
    LoginPage loginPage;
    NavigationBar navigationBar;
    InfoBookPage infoBookPage;
    SearchBookResults searchBookResults;
    ProfilePage profilePage;

    @BeforeMethod
    public void beforeMethod() throws AWTException {
        loginPage = new LoginPage(driver);
        navigationBar = new NavigationBar(driver);
        bookStorePage = new BookStorePage(driver);
        infoBookPage = new InfoBookPage(driver);
        searchBookResults = new SearchBookResults(driver);
        profilePage = new ProfilePage(driver);


        navigationBar.navigate(UrlConstants.BOOK_STORE_URL);
        bookStorePage.zoomOutBrowser();
    }

    @Test
    public void addBookSuccessfully() throws FileNotFoundException, InterruptedException {
        Books books = Books.getBookData();

        Thread.sleep(1000);
        bookStorePage.selectBook(books.getBookTitle());
        bookStorePage.clickElement(LoginLocator.BTN_LOGIN);

        loginPage.loginSuccessfully();

        Thread.sleep(1000);
        infoBookPage.clickButtonAddBook();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        // Accepting alert
        alert.accept();

        infoBookPage.navigate(UrlConstants.PROFILE_URL);

        boolean bookAdded = profilePage.searchResults(books.getBookTitle());
        assertThat("Verify book is added", bookAdded == true);
    }

}
