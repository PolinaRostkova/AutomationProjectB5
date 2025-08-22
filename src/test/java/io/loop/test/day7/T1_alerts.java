package io.loop.test.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T1_alerts extends TestBase {

    /*
    Information alert practice
    1. Open browser
    2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
    3. Click to “Click for JS Alert” button
    4. Click to OK button from the alert
    5. Validate “You successfully clicked an alert” text is displayed

    Confirmation alert practice
    1. Click to “Click for JS Confirm” button
    2. Click to OK button from the alert
    3. Verify “You clicked: Ok” text is displayed.
    4. Click to “Click for JS Confirm” button
    5. Click to Cancel button from the alert
    6. Validate “You clicked: Cancel” text is displayed.

    Prompt alert practice
    1. Click to “Click for JS Prompt” button
    2. Send "Loop Academy"
    3. Click Ok
    4. Validate "You entered: Loop Academy" text is displayed
     */
    @Test
    public void testAlerts() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement elementForJSAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        elementForJSAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement elementMassageSuccsess = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedAlertText = "You successfully clicked an alert";
        String actualAlertText = elementMassageSuccsess.getText();
        assertEquals(actualAlertText, expectedAlertText, "Expected doest NOT match");
    }
    //Click for JS Confirm

    @Test
    public void testConfirmationAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");

        WebElement elementForJSAlertConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        elementForJSAlertConfirm.click();

        // click and accept an alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement succsessMassageForConfirmation = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedAlertText = "You clicked: Ok";
        String actualAlertText = succsessMassageForConfirmation.getText();
        assertEquals(actualAlertText, expectedAlertText, "Expected doest NOT match");

        // click and dismiss an alert
        elementForJSAlertConfirm.click();
        driver.switchTo().alert().dismiss();
        expectedAlertText = "You clicked: Cancel";
        actualAlertText = succsessMassageForConfirmation.getText();
        assertEquals(actualAlertText, expectedAlertText, "Expected doest NOT match");
    }

    @Test
    public void testPromptAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");

        WebElement promptAlert =  driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promptAlert.click();

        String text = "Loop Camp";
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();

        WebElement successMassageForPrompt = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedAlertText = "You entered: " + text;
        String actualAlertText = successMassageForPrompt.getText();
        assertEquals(actualAlertText, expectedAlertText, "Expected doest NOT match");

        promptAlert.click();
        alert.sendKeys(text);
        alert.dismiss();
        expectedAlertText = "You entered: null";
        actualAlertText = successMassageForPrompt.getText();
        assertEquals(actualAlertText, expectedAlertText, "Expected doest NOT match");



    }
}
