package io.loop.test.day5;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.*;

public class T2_getText_xPath {
    /*
 1. open chrome
 2. go to docuport
 3. click on forgot password
 4. validate url contains: reset-password
 5. validate - Enter the email address associated with your account
 6. enter forgotpasswordg1@gmail.com to email box
 7. validate send button is displayed
 8. validate cancel button is displayed
 9. click send button
 10. validate - We've sent you an email with a link to reset your password. Please check your email
  */
    public static void main(String[] args) throws InterruptedException {
        // 1, 2 - open chrome and navigate to docuport

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();

        driver.get(DocuportConstants.DOCUPORT_TEST);

        // click forgot password link
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgotPasswordLink.click();

        //validate url contains: reset-password
        String actualURL = driver.getCurrentUrl();
        if(actualURL.equals(DocuportConstants.FORGOT_PASSWORD_URL)){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        WebElement validateMassage = driver.findElement(By.xpath("//div[contains(text(),'Enter')]"));
        String actualMassage = validateMassage.getText();
        if (actualMassage.equals(DocuportConstants.RESET_PASSWORD_MASSAGE)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        // enter forgotpasswordg1@gmail.com to email box
        WebElement enterEmail = driver.findElement(By.xpath("//input[contains(@id,'input')]"));
        enterEmail.sendKeys(DocuportConstants.FORGOT_PASSWORD_EMAIL);

        // validate send button is displayed
        // validate cansel button is displayed

        WebElement cancelButton = driver.findElement(By.xpath("//span[normalize-space()='Cancel']"));
        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space()='Send']"));

        if (cancelButton.isDisplayed()){
            System.out.println("Test passed. Cancel button is displayed");
        } else  {
            System.out.println("Test failed. Cancel button is NOT displayed");
        }

        if (sendButton.isDisplayed()){
            System.out.println("Test passed. Send button is displayed");
        } else {
            System.out.println("Test failed. Send button is NOT displayed");
        }

        sendButton.click();

        Thread.sleep(5000);
        // validate the massage We've sent you an email with a link to reset your password. Please check your email
        WebElement sucsessMassage;
        try {
           sucsessMassage = driver.findElement(By.xpath("//span[@class='body-1']"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Thread.sleep(5000);
           sucsessMassage = driver.findElement(By.xpath("//span[@class='body-1']"));
        }

        System.out.println(sucsessMassage.getText()); // here we are getting the massage because the element was found

        Thread.sleep(10000); // here we wait for 10 sec and then trying to print it out in try..catch block

        try {
            System.out.println("successMessage text: " + sucsessMassage.getText());
        } catch (StaleElementReferenceException e) { // give StaleElementReferenceException because earlier in line 84 we get text and element was found but here after 10 sec wait we are trying to getText again after element is not there anymore
            e.printStackTrace();
            System.out.println("Element is not here anymore"); //
        }

        // NoSuchElementException - when element was never there
        // StaleElementReferenceException - element was there but disappeared

        if(sucsessMassage.isDisplayed()){
            System.out.println("Test passed. Success massage is displayed");
        } else  {
            System.out.println("Test failed. Success massage is NOT displayed");
        }



    }
}
