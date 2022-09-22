package com.nashtech.pages;

import com.nashtech.constants.ConfigConstants;
import com.nashtech.constants.TestDataConstants;
import com.nashtech.constants.locators.SearchBookLocator;
import com.nashtech.constants.locators.StudentRegisterLocator;
import com.nashtech.utils.PropertiesFileUtil;
import org.docx4j.wml.P;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static com.nashtech.constants.TestDataConstants.TIMEOUT_IN_SECOND;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty("TIMEOUT_IN_SECOND"))));
    }

    public void navigate(String url){
        driver.get(System.getProperty("BASE_URL") + url);
    }

    /** Wait **/
    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForVisibilityOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> waitForVisibilityOfAllElementsLocatedBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForVisibilityOfWebElement(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /** Find element */
    public List<WebElement> findAllElements(By locator) {
        return waitForVisibilityOfAllElementsLocatedBy(locator);
    }

    /** Click element **/
    public void clickElement(By locator){
        WebElement element = waitForElementToBeClickable(locator);
        element.click();
    }

    /** Input text **/
    public void inputText(By locator, String text){
        WebElement element = waitForElementToBeClickable(locator);
        element.sendKeys(text);
    }

    /** Get text **/
    public String getText(By locator){
        WebElement element = waitForVisibilityOfElementLocated(locator);
        return element.getText();
    }

    public String getText(WebElement webElement) {
        WebElement element = waitForVisibilityOfWebElement(webElement);
        return element.getText();
    }

    /** Clear to element is empty */
    public void clearElement(By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        element.clear();
    }

    /** Select radio option **/
    public void selectRadioOption(String option){
        List<WebElement> allOptions = findAllElements(StudentRegisterLocator.RDO_GENDER);
        for (WebElement options : allOptions){
            if(getText(options).equals(option) && options.isSelected() == false){
                options.click();
            }
            break;
        }
    }

    /** Select options Dropdown-list **/
    public void selectDropdownOptionWithTagSelect(By locator, String option){
        Select dropdownElement = new Select(waitForElementToBeClickable(locator));
        dropdownElement.selectByVisibleText(option);
    }

    /** Zoom out Browser **/
    public void zoomOutBrowser() throws AWTException {
        Robot robot = new Robot();
        for(int i = 0; i <= 4; i++){
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }
}
