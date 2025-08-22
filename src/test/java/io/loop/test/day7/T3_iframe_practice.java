package io.loop.test.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T3_iframe_practice extends TestBase {


    @Test
    public void test_iframe_practice() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");

        // validate left
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//body[contains(.,'LEFT')]"));
        String actualText = left.getText().trim();
        assertEquals(actualText, "LEFT");

        driver.switchTo().parentFrame();

        // validate middle
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//body[contains(.,'MIDDLE')]"));
        String actualMiddle = middle.getText().trim();
        assertEquals(actualMiddle, "MIDDLE");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.xpath("//body[contains(.,'RIGHT')]"));
        String actualRight = right.getText().trim();
        assertEquals(actualRight, "RIGHT");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//body[contains(.,'BOTTOM')]"));
        String actualBottom = bottom.getText().trim();
        assertEquals(actualBottom, "BOTTOM");
    }
}
