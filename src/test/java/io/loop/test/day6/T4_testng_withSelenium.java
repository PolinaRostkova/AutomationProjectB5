package io.loop.test.day6;

import io.loop.test.utilities.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class T4_testng_withSelenium {
    WebDriver driver;
    String actual;
    String expected;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
    }

    @Test
    public void googleTitle(){
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());
        expected = "Google";
        actual = driver.getTitle();
        assertEquals(actual, expected, "Actual: " + actual + " Expected: " + expected);
    }

    @Test
    public void docuportTitle(){
        Driver.getDriver().get(ConfigurationReader.getProperty("docuportBETA"));
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());
        expected = "Docuport";
        actual = driver.getTitle();
        assertEquals(actual, expected, "Actual: " + actual + " Expected: " + expected);
    }
}
