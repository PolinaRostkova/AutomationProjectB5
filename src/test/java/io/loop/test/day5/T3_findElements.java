package io.loop.test.day5;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class T3_findElements {
    public static void main(String[] args) throws InterruptedException {
         /*
        1- Open a chrome browser
        2- Go to: https://www.nba.com
        3- Locate all the links in the page.
         */
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();

        driver.get("https://www.nba.com");
        //Thread.sleep(10000); // will wait no metter what and does NOT check
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // it waits that element in the page are available for us // it checks every second what is loaded  | selenium 4

        List<WebElement> nbaLinks = driver.findElements(By.tagName("a"));
        System.out.println(nbaLinks.size());

        List<WebElement> nbaLinksWithXpath = driver.findElements(By.xpath("//a"));
        System.out.println(nbaLinksWithXpath.size());

        for (WebElement nbaLink : nbaLinks) {
            if (!nbaLink.getText().equals("")){
                System.out.println(nbaLink.getText());
                System.out.println(nbaLink.getDomAttribute("href"));
            }
        }
    }
}
