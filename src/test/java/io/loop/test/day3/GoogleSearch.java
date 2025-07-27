package io.loop.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Navigate to Google search
 * maximize the page
 * get title of the page
 * get url of the page
 * validate the title, expected title is "Google"
 * validate the url of the page, expected url is "https://www.google.com/"
 * close the browser
 */
public class GoogleSearch {
    public static void main(String[] args) {
        // create the driver object right away
        WebDriver driver = new ChromeDriver();

        // navigate to google search
        driver.get("https://www.google.com");

        // maximize the page
        driver.manage().window().maximize();

        // expected tittle
        String expectedTitle = "Google";

        // actual title
        String actualTitle = driver.getTitle(); // return type String so we can assign it to the String

        // validation
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Actual title: " + actualTitle + ", matches expected: " + expectedTitle + ". => TEST PASSED");
        } else {
            System.err.println("Actual title" + actualTitle + ", DOES NOT matches expected: " + expectedTitle + ". => TEST FAILED");
        }

        // expected URL
        String expectedURL = "https://www.google.com";

        // actual URL
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedURL)){
            System.out.println("Actual URL: " + actualUrl + ", matches expected URL " + expectedURL + ". => Test Passed");
        } else {
            System.err.println("Actual URL: " + actualUrl + ", DOES NOT matches expected URL " + expectedURL + ".Test Failed");
        }

        driver.quit();
    }
}
