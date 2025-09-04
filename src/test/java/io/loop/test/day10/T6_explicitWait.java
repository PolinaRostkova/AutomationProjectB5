package io.loop.test.day10;

import io.loop.pages.LoopPracticeDynamicLoading7Page;
import io.loop.test.utilities.BrowserUtils;
import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class T6_explicitWait {

    LoopPracticeDynamicLoading7Page loopPracticeDynamicLoading7Page;
    WebDriverWait wait;

    @BeforeMethod
    public void beforeMethod() {
        loopPracticeDynamicLoading7Page = new LoopPracticeDynamicLoading7Page();
        Driver.getDriver().get(ConfigurationReader.getProperty("loop.practice"));

    }

    @AfterMethod
    public void afterMethod() {
        Driver.closeDriver();
    }

    @Test
    public void explicitWaitTest() {
        BrowserUtils.loopLonkClickMethod("Dynamic Loading");
        loopPracticeDynamicLoading7Page.getDynamicLoading7.click();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Dynamic title"));
        assertTrue(loopPracticeDynamicLoading7Page.doneMessage.isDisplayed(), "Element is NOT displayed");
        assertTrue(loopPracticeDynamicLoading7Page.image.isDisplayed(), "Element is NOT displayed");
    }
}
