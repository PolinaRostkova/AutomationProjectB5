package io.loop.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocators {
    public static void main(String[] args) {

        // create driver obj
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // navigate loopcamp practice page
        // https://loopcamp.vercel.app

        driver.get("https://loopcamp.vercel.app/registration_form.html");

        // locate the first name
        WebElement elementFirstName = driver.findElement(By.name("firstname"));
        //WebElement elementFirstName = driver.findElement(By.className("form-control"));

        // firstname to send
        String firstName = "Loop";

        // snd keys firstname
        elementFirstName.sendKeys(firstName);

        WebElement elementLastName = driver.findElement(By.name("lastname"));
        String lastName = "Camp";
        elementLastName.sendKeys(lastName);

        WebElement elementUserName = driver.findElement(By.name("username"));
        String userName = "loopCampSchool";
        elementUserName.sendKeys(userName);

        // this will return us 3 elements, and always will click the first match, that why we should pay attention to locate unique elements
        WebElement elementGenderFemale = driver.findElement(By.name("gender"));
        elementGenderFemale.click();
    }
}
