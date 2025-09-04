package io.loop.test.day10;

import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class T1_actions_hoverover {
    /*
    /*
    1. Go to https://www.google.com
    2. Hover over on Search button
    3. Hover over on Feeling Lucky button
     */

    @Test
    public void google_actions_hoverover() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
        WebElement googleSearch = Driver.getDriver().findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@class='gNO89b']"));
        WebElement feelingLucky =  Driver.getDriver().findElement(By.id("gbqfbb"));
//        WebElement googleSearchSel4 = Driver.getDriver().findElement(with(By.tagName("input")).straightLeftOf(feelingLucky));
//        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
//        searchBox.sendKeys("loopcamp");
//        googleSearchSel4.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(googleSearch).perform();

        Thread.sleep(3000);

        actions.moveToElement(feelingLucky).perform();

        actions.sendKeys("F12");

    }
}
