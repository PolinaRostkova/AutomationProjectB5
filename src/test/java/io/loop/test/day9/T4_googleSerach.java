package io.loop.test.day9;

import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T4_googleSerach {

    @Test
    public void googleSerach() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());

        WebElement serach = Driver.getDriver().findElement(By.name("q"));
        serach.sendKeys("Loop Academy" + Keys.ENTER);

        Thread.sleep(3000);
        String actualTutle = Driver.getDriver().getTitle();

        assertEquals(actualTutle, "Loop Academy - Google Search");
    }

    @Test
    public void googleSearch() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("docuportBETA"));
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());

        DocuportUtils.login(Driver.getDriver(), DocuportConstants.ADVISOR);
        WebElement myUploads = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'My uploads')]"));
        myUploads.click();
    }
}
