package io.loop.test.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TO_Etsy {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com");
        WebElement search = driver.findElement(By.id("global-enhancements-search-query"));

        String searchItem = "wooden spoon";
        search.sendKeys(searchItem + Keys.ENTER);

        String expectedTitle = "Wooden spoon - Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Actual title: " + actualTitle + ", matches expected: " + expectedTitle + ". => TEST PASSED");
        } else {
            System.err.println("Actual title" + actualTitle + ", DOES NOT matches expected: " + expectedTitle + ". => TEST FAILED");
        }
    }
}
