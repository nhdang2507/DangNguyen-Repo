package com.nashtech.finalcucumber.pages;

import com.nashtech.finalcucumber.utils.PropertiesFileUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import static com.nashtech.finalcucumber.steps.StepHook.driver;

public class BasePage {
    public WebDriverWait wait;
    private static final int SELENIUM_TIMEOUT_SECONDS = Integer.parseInt(PropertiesFileUtil.getProperty("TIMEOUT_IN_SECOND"));

    public static void navigate(String url) {
        driver.get(PropertiesFileUtil.getProperty("BASE_URL") + url);
    }

    public static WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SELENIUM_TIMEOUT_SECONDS));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForVisibilityOfElementLocated(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SELENIUM_TIMEOUT_SECONDS));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForVisibilityOfWebElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SELENIUM_TIMEOUT_SECONDS));

        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static List<WebElement> waitForAllElementsToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SELENIUM_TIMEOUT_SECONDS));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static void waitForTextToBePresentInElementLocated(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SELENIUM_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public static void waitForTextBePresentInElementValue(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SELENIUM_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
    }

    public List<WebElement> waitForVisibilityOfAllElementsLocatedBy(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SELENIUM_TIMEOUT_SECONDS));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static String getTextOfAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SELENIUM_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        // Accepting alert
        return alert.getText();
    }

    public static void acceptAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SELENIUM_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        // Accepting alert
        alert.accept();
    }

    public List<WebElement> findAllElements(By locator) {
        return waitForVisibilityOfAllElementsLocatedBy(locator);
    }

    public boolean isElementLinkTextPresent(String nameElement) {
        try {
            driver.findElement(By.xpath(String.format("//a[text()='%s']",nameElement)));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void inputText(By locator, String text) {
        WebElement element = waitForVisibilityOfElementLocated(locator);
        element.sendKeys(text);
    }

    public void sendKeys(By locator, Keys key) {
        WebElement element = waitForVisibilityOfElementLocated(locator);
        element.sendKeys(key);
    }

    public void clickElement(By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        element.click();
    }

    public String getText(By locator) {
        WebElement element = waitForVisibilityOfElementLocated(locator);
        return element.getText();
    }

    public String getText(WebElement webElement) {
        WebElement element = waitForVisibilityOfWebElement(webElement);
        return element.getText();
    }

    /** Select options Dropdown-list **/
    public void selectDropdownOption(By locator, String option){
        Select dropdownElement = new Select(waitForElementToBeClickable(locator));
        dropdownElement.selectByVisibleText(option);
    }

    /** Select radio option **/
    public void selectRadioOption(By locator, String option){
        List<WebElement> allOptions = findAllElements(locator);
        for (WebElement options : allOptions){
            if(getText(options).equals(option) && options.isSelected() == false){
                options.click();
            }
            break;
        }
    }

    public static void scrollToPageBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    /** Zoom out Browser **/
    public static void zoomOutBrowser() throws AWTException {
        Robot robot = new Robot();
        for(int i = 0; i <= 3; i++){
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }
}
