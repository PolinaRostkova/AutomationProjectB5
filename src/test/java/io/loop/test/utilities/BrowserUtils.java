package io.loop.test.utilities;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class BrowserUtils {

    // this class is created to store utils for browser

    /**
     * validate if the driver switched to the expected url or title
     * @param driver
     * @param  expectedUrl
     * @param expectedTitle
     * implements assertion
     */

    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        // to lower case the params to avoid case sensitiveness
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();

        // get all window handles, switch one by one and each ti,e check if the url matches expected to stop
        var windowHandles = driver.getWindowHandles();
        for (var windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }

        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * @param driver
     * @param targetTitle
     */

    public static void switchToWindow(WebDriver driver, String targetTitle) {
        String currentWindowHandle = driver.getWindowHandle();
        for (String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
            if(driver.getTitle().contains(targetTitle)){
                return;
            }
        }
        driver.switchTo().window(currentWindowHandle);
    }
}
