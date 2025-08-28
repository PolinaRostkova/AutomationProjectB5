package io.loop.test.day8;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class T4_windowTitles extends TestBase {

    @Test
    public void t4_windowTitles() {
        driver.get("https://www.google.com");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.loopcamp.io");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");

        System.out.println(driver.getTitle());

//        Set<String> windowTitles = driver.getWindowHandles();
//
//        for (String each : windowTitles){
//            driver.switchTo().window(each);
//
//            if (driver.getTitle().contains("Google")){
//                break;
//            }
//        }

        /*
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

         */

        //BrowserUtils.switchWindowAndValidate(driver, "www.loopcamp.io", "Loopcamp");
        BrowserUtils.switchToWindow(driver, "Google");
    }
}
