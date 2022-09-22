package com.nashtech.finalcucumber.steps;

import com.nashtech.finalcucumber.utils.PropertiesFileUtil;
import com.nashtech.finalcucumber.utils.api.UserHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.docx4j.wml.U;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class StepHook {
    static public WebDriver driver;
    UserHelper userHelper = new UserHelper();

    @BeforeAll
    public static void beforeAll() throws IOException {
        PropertiesFileUtil.readProperties("src/test/resources/configs/env/dev.properties");
    }

    @Before()
    public void beforeScenario(Scenario scenario) throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PropertiesFileUtil.getProperty("BASE_URL"));
    }

    @After
    public void afterScenario(Scenario scenario){
        driver.quit();
    }

}
