package io.loop.test.day10;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Set;

public class T3_javaskript_executor_scroll {
    /*
        1. Go to https://loopcamp.vercel.app/index.html
        2. Scroll down to the link
         */
    @Test
    public void test_javaskript_executor_scroll() {
        Driver.getDriver().get("https://loopcamp.vercel.app/index.html");

        WebElement elementLink = Driver.getDriver().findElement(By.xpath("//a[@href='https://www.loopcamp.io/']"));

        // how to scroll

        // 1. use the actions class move to element
        //Actions actions = new Actions(Driver.getDriver());
        //actions.moveToElement(elementLink).perform();
        //actions.scrollToElement(elementLink).perform(); // scrolls right to the element

        // 2. use key press
        //actions.sendKeys(Keys.PAGE_DOWN).perform(); // scrolls just one time and that's it

        // 3. move horizontally or vertically
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver(); // downcasting
        //js.executeScript("window.scroll(0, 5000)");

        // 4. move scroll to view
        js.executeScript("arguments[0].scrollIntoView(true)", elementLink);
        js.executeScript("arguments[0].click();", elementLink);

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            Driver.getDriver().switchTo().window(handle);
            js.executeScript("window.scroll(0,5000)");
        }
       // js.executeScript("window.scroll(0,5000)");
    }
}
