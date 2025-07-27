package io.loop.test.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
    navigate to amazon
    maximize
    navigate back
    navigate forward
    refresh
     */
public class NavigateToAmazon {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximizing");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
}
