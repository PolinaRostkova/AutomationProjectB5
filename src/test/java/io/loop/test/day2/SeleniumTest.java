package io.loop.test.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        // Setting up the driver
//        WebDriver driver = new ChromeDriver();

        // older versions of selenium you need to set up web driver manager
        // WebDriverManager ---> comes from bonnie garsia

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximizing");
        options.addArguments("--incognito");
        WebDriver driver1 = new ChromeDriver(options);
        // maximize the window
        driver1.manage().window().maximize();

        // just wait
        Thread.sleep(3000);

        // navigate the page
        driver1.get("https://www.loopcamp.io");

        // navigate to the page
        driver1.navigate().to("https://google.com");

        // navigate back to the page
        driver1.navigate().back();

        // navigate forward
        driver1.navigate().forward();

        // refresh
        driver1.navigate().refresh();

        // quiting the browser
        driver1.quit();

    }
}
