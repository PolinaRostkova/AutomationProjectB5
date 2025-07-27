package io.loop.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

        // create an option to avoid captcha
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");

        // create an object of the driver
        WebDriver driver = new ChromeDriver(options);

        // maximize
        driver.manage().window().maximize();

        // navigate to google page
        driver.get("https://google.com");

        // locate the element with ID
        WebElement searchBoxWithI = driver.findElement(By.id("APjFqb"));

        // get a text to search
        String textSearch = "Feyruz is the king of Java";


        // send the text to the input
        searchBoxWithI.sendKeys(textSearch);

        // add some wait
        Thread.sleep(3000);

        // clear the box method
        searchBoxWithI.clear();


        // click enter
        searchBoxWithI.sendKeys("Nadir is smart" + Keys.ENTER);

        // navigate back
        driver.navigate().back();

        // locate search box with name
        WebElement searchBoxWithName = driver.findElement(By.name("q"));

        // send text to the search box which is spied with name
        searchBoxWithName.sendKeys(textSearch + Keys.ENTER);

        // navigate back again
        driver.navigate().back();

        // click About with using link text
        WebElement aboutLink = driver.findElement(By.linkText("About"));

        // click that link
        aboutLink.click();
    }
}
