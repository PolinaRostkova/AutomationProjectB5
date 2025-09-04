package io.loop.test.day10;

import io.loop.pages.DynamicLoopPracticePage;
import io.loop.test.utilities.BrowserUtils;
import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class T5_dynemic_loading1 {
    /*
    1. go to https://loopcamp.vercel.app/dynamic_loading/1.html
    2. click start
    3. wait loading bar disappears
    4. validate username is displayed
    5. enter username tomsmith
    6. enter password incorrectpassword
    7. click submit button
    8. validate "Your password is invalid!" is displayed
     */

DynamicLoopPracticePage dynamicLoopPracticePage;

@BeforeMethod
public void beforeMethod(){
    dynamicLoopPracticePage = new DynamicLoopPracticePage();
    Driver.getDriver().get(ConfigurationReader.getProperty("loop.practice"));
}

@AfterMethod
public void afterMethod(){
   // Driver.getDriver().close();
}

@Test
public void testT5_dynamic_loading1(){
    BrowserUtils.loopLonkClickMethod("Dynamic Loading");
    BrowserUtils.waitForClickable(dynamicLoopPracticePage.dynamicLoading1, 10).click();
    BrowserUtils.waitForClickable(dynamicLoopPracticePage.startButton, 10).click();
    BrowserUtils.waitForInvisibility(dynamicLoopPracticePage.loadingBar, 10);

    assertTrue(dynamicLoopPracticePage.usernameField.isDisplayed());

    dynamicLoopPracticePage.usernameField.sendKeys(ConfigurationReader.getProperty("dynamicLoading.username"));
    dynamicLoopPracticePage.passwordField.sendKeys(ConfigurationReader.getProperty("dynamicLoading.incorrectPassword"));
    BrowserUtils.waitForClickable(dynamicLoopPracticePage.submitButton, 10).click();

    assertTrue(BrowserUtils.waitForVisibility(dynamicLoopPracticePage.errorMessage, 10).isDisplayed());
}
}
