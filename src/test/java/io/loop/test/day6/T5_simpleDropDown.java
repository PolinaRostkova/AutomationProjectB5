package io.loop.test.day6;

import io.loop.test.day2.SeleniumTest;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class T5_simpleDropDown {
     /*
    1. Open Chrome browse
    2. Go to http://the-internet.herokuapp.com/dropdown
    3. Verify “Dropdown list” default selected value is correct - Expected: “Please select an option”
     */

    WebDriver driver;
    String expected = "Please select an option";
    String actual;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }


    @Test
    public void dropDownTest(){
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // to handle Select dropdown --> create a class of Select --> pass there the element ---> we can do whatever we want

        // crate a dropdown Select
        // Option 1
        //WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        //Select dropdown = new Select(dropdownElement);

        // Option 2
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        actual = dropdown.getFirstSelectedOption().getText();
        assertEquals(actual, expected, "Actual option is incorrect.");
    }

}
