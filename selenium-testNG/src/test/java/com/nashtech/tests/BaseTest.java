package com.nashtech.tests;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import com.nashtech.utils.PropertiesFileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.logging.LogManager;

@Listeners(ExtentITestListenerAdapter.class)
public class BaseTest {

    //public WebDriver driver;
    public static RemoteWebDriver driver;
    private static final LocalDateTime START_TIME = LocalDateTime.now();
   // private static Logger LOGGER = LogManager.getLogger(String.valueOf(BaseTest.class));

    @BeforeSuite
    @Parameters({"browser"})
    public void beforeSuite(String browser) throws IOException {
        Properties properties = PropertiesFileUtil.loadPropertiesFromFile(System.getProperty("env.properties"));
        PropertiesFileUtil.appendSystemProperties(properties);
        if(StringUtils.isNotEmpty(browser)){
            System.setProperty("BROWSER_TYPE", browser);
        }
    }

    @BeforeMethod
    public void beforeMethodBaseTest(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().driverVersion("104.0.5112.48").setup();
        try {
            driver = new ChromeDriver(chromeOptions);
        }
        catch(WebDriverException e) {
            driver = new ChromeDriver(chromeOptions);
        }

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
