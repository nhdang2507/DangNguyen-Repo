package com.nashtech.tests;

import com.nashtech.models.Books;
import com.nashtech.constants.UrlConstants;
import com.nashtech.constants.locators.ProfileLocator;
import com.nashtech.pages.*;
import com.nashtech.shared.NavigationBar;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.FileNotFoundException;
import java.time.Duration;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteBookTest extends BaseTest{
    LoginPage loginPage;
    NavigationBar navigationBar;
    ProfilePage profilePage;
    ProfileNotLoginPage profileNotLoginPage;
    SearchBookResults searchBookResults;

    @BeforeMethod
    public void beforeMethod() throws AWTException {
        loginPage = new LoginPage(driver);
        navigationBar = new NavigationBar(driver);
        profilePage = new ProfilePage(driver);
        profileNotLoginPage = new ProfileNotLoginPage(driver);
        searchBookResults = new SearchBookResults(driver);

        navigationBar.navigate(UrlConstants.PROFILE_URL);
        profilePage.zoomOutBrowser();
    }

    @Test
    public void deleteSuccessfully() throws FileNotFoundException, InterruptedException {
        Books books = Books.getBookData();
        profileNotLoginPage.clickLoginLink(ProfileLocator.LNK_LOGIN);

        loginPage.loginSuccessfully();

        Thread.sleep(1000);
        profilePage.deleteBook(books.getBookTitle());
        profilePage.clickVerifyDelete();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        /** Verify book is deleted **/

        profilePage.inputKeysSearch(books.getBookTitle());

        assertThat("Verify book is deleted", searchBookResults.getText(ProfileLocator.NO_ROWS_FOUND),
                equalTo("No rows found"));
    }
}
