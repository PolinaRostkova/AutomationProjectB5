package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class T4_forgotPassword {
    public static void main(String[] args) {
        /*
        validate forget password
        identify reset password heading using caa and go from parent to child

         */

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();

        // go to url
        driver.get(DocuportConstants.DOCUPORT_TEST);

        // locate forgot password with css and click on that

        WebElement forgotPasswodLink = driver.findElement(By.cssSelector("a[href='/reset-password']"));
        forgotPasswodLink.click();

        // locate password heading

        WebElement forgotPasswordHeading = driver.findElement(By.cssSelector("div[class='login-layout__form']>h1"));
        String actualForgotPasswordHeading = forgotPasswordHeading.getText();

        if (actualForgotPasswordHeading.equals(DocuportConstants.EXPECTED_RESET_PASSWORD_HEADING)){
            System.out.println("Expected heading: " + DocuportConstants.EXPECTED_RESET_PASSWORD_HEADING + ", matches actual heading: " + actualForgotPasswordHeading);
            System.out.println("TEST PASSED");
        } else {
            System.out.println("Expected heading: " + DocuportConstants.EXPECTED_RESET_PASSWORD_HEADING + ",does NOT matches actual heading: " + actualForgotPasswordHeading);
            System.out.println("TEST FAILED");
        }

    }
}
