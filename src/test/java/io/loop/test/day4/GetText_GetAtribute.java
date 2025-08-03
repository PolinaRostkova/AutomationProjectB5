package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetText_GetAtribute {
    public static void main(String[] args) {
        /*
    go to url: https://loopcamp.vercel.app/registration_form.html
    validate header text expected: Registration form
    validate placeholder attribute value for first name expected - first name
     */

        // go to the url
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();

        driver.get(LoopCampConstants.URL_REGISTRATION_FORM);

        // spy | locate | element header
        WebElement header = driver.findElement(By.tagName("h2"));

        // use getText(); method
        String actualHeaderText = header.getText();
        String expectedHeaderText = LoopCampConstants.EXPECTED_HEADER_FOR_FORM;

        // validation
        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Expected header text: \"" + expectedHeaderText + "\", matches actual header text: \"" + actualHeaderText + "\"");
            System.out.println("TEST PASSED");
        } else {
            System.out.println("Expected header text: \"" + expectedHeaderText + "\", does NOT matches actual header text: \"" + actualHeaderText + "\"");
            System.out.println("TEST FAILED");
        }

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        // use getAttribute(); method which will return the value of the attribute not the text
        WebElement firstNamePlaceHolder = driver.findElement(By.name("firstname"));
        String actualPlaceHolderForFirstName = firstNamePlaceHolder.getDomAttribute("placeholder");

        if (actualPlaceHolderForFirstName.equals(LoopCampConstants.EXPECTED_PLACEHOLDER_FOR_FIRSTNAME)){
            System.out.println("Expected header text: \"" + LoopCampConstants.EXPECTED_PLACEHOLDER_FOR_FIRSTNAME + "\", matches actual header text: \"" + actualPlaceHolderForFirstName + "\"");
            System.out.println("TEST PASSED");
        } else {
            System.out.println("Expected header text: \"" + LoopCampConstants.EXPECTED_PLACEHOLDER_FOR_FIRSTNAME + "\", does NOT matches actual header text: \"" + actualPlaceHolderForFirstName + "\"");
            System.out.println("TEST FAILED");
        }
    }
}
