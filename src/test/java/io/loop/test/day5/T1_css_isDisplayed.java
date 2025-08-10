package io.loop.test.day5;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_css_isDisplayed {
    /*
    https://the-internet.herokuapp.com/forgot_password
     */
    public static void main(String[] args) {
        // set up driver and navigate
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
        driver.get(GeneralConstants.HEROKUAPP_URL);

        WebElement forgotPasswordHeading = driver.findElement(By.cssSelector("div[class='example']>h2"));
        //System.out.println(forgotPasswordHeading.getText()); | Forgot Password

        // is displayed() = boolean will return true or false depending on the element is displayed at HTML
        //System.out.println(forgotPasswordHeading.isDisplayed()); | true

        if (forgotPasswordHeading.isDisplayed()) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }


    }
}
