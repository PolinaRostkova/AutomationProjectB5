package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_CSS_Practice {
    public static void main(String[] args) {
         /*
    go to docuport app
    identify docuport with css
    get value of the attribute
    validate if it is "Docuport"

    the rest is home work
    locate:
    username
    password
    login
        with css
    login to docuport
    locate home icon of docuport after login or any other element after login
    validated that you logged in

     */

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
        driver.navigate().to(DocuportConstants.DOCUPORT_TEST);

        // locate the element with css
        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']"));

        // get value of the attribute
        String actualValueDocuport = logo.getDomAttribute("alt");
        //String valueDocuport = logo.getAttribute("alt");

        if (actualValueDocuport.equals(DocuportConstants.EXPECTED_LOGO)){
            System.out.println("Expected logo: " + DocuportConstants.EXPECTED_LOGO + ", matches actual logo: " + actualValueDocuport);
            System.out.println("TEST PASSED");
        } else {
            System.out.println("Expected logo: " + DocuportConstants.EXPECTED_LOGO + ", does NOT matches actual logo: " + actualValueDocuport);
            System.out.println("TEST FAILED");
        }

    }
}
