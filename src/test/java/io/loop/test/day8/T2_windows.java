package io.loop.test.day8;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class T2_windows extends TestBase {
     /*
    1. Open a chrome browser
    2. Go to : http://the-internet.herokuapp.com/windows
    3. Assert: Title is “The Internet”
    4. Click to: “Click Here” link
    5. Switch to new Window.
    6. Assert: Title is “New Window”
     */

    @Test
    public void testWindowHandle(){
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // assert the title
        assertEquals(driver.getTitle(), "The Internet");

        // print out the current window handle
        //System.out.println(driver.getWindowHandle());

        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHere.click();

        // print out the current window handle
        //System.out.println(driver.getWindowHandle());

        String originalWindow =  driver.getWindowHandle();
        // get all window handles
        Set<String> handles = driver.getWindowHandles();

        // loop through the window handles and stay at the last one
        for (String each : handles){
            System.out.println(each);
            driver.switchTo().window(each);
        }


        System.out.println(driver.getTitle());

        // switch back to the window
        driver.switchTo().window(originalWindow);
        System.out.println(driver.getTitle());
    }
}
