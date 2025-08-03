package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_Locators_getText {
    public static void main(String[] args) {
        /*
         * go to docuport
         * enter username
         * do NOT enter password
         * click on login button
         * verify error message - please enter password
         */

        // get the driver and navigate to the docuport page
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);

        driver.manage().window().maximize();
        driver.get(DocuportConstants.DOCUPORT_TEST);

        WebElement logInUserName = driver.findElement(By.id("input-14"));
        logInUserName.sendKeys(DocuportConstants.USERNAME_CLIENT);

        // spy | locate | inspect log in button and click
        WebElement logInButton = driver.findElement(By.className("v-btn__content"));
        logInButton.click();

        // get an error message
        WebElement errorMessage = driver.findElement(By.className("v-messages__message"));
        String actualErrorMessage = errorMessage.getText();

        // validation

        if (actualErrorMessage.equals(DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD)){
            System.out.println("Expected error message: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", matches actual error message: " + actualErrorMessage);
            System.out.println("TEST PASSED");
        } else {
            System.out.println("Expected error message: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", does NOT matches actual error message: " + actualErrorMessage);
            System.out.println("TEST FAILED");
        }

        driver.quit();



    }
}
