package io.loop.test.day6;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class T2_checkboxes {
    public static void main(String[] args) {
        /*
        1. Go to http://the-internet.herokuapp.com/checkboxes
        2. Confirm checkbox #1 is NOT selected by default
        3. Confirm checkbox #2 is SELECTED by default.
        4. Click checkbox #1 to select it.
        5. Click checkbox #2 to deselect it.
        6. Confirm checkbox #1 is SELECTED.
        7. Confirm checkbox #2 is NOT selected.

         */

        // created an object of a driver
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);

        driver.get("http://the-internet.herokuapp.com/checkboxes"); // navigating to the page
        driver.manage().window().maximize(); // maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit wait


        // //input/following-sibling::text()[contains(.,'checkbox 1')]/preceding-sibling::input ---> go to preceding-sibling
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox' and following-sibling::text()[contains(.,'checkbox 1')]]")); // 1 more option --> //input[@type='checkbox' and following-sibling::text()[contains(.,'checkbox 1')]]
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox' and normalize-space(following-sibling::text())='checkbox 2']"));

        if (!checkbox1.isSelected()) {
            System.out.println("checkbox 1 is not selected");
        } else  {
            System.out.println("checkbox 1 is selected");
        }

        checkbox1.click();

        if (!checkbox1.isSelected()) {
            System.out.println("checkbox 1 is not selected");
        } else  {
            System.out.println("checkbox 1 is selected");
        }
    }
}
