package io.loop.test.day10;

import io.loop.pages.LoopPracticeDragDropPage;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class T4_dragDrop_POM {
     /*
    Loop Practice Drag and Drop Test
    1. Open a chrome browser
    2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
    3. validate expected default text appears on big circle
    Expected = "Drag the small circle here."

    Loop Practice Drag and Drop Test
    1. Open a chrome browser
    2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
    3. Click and hold small circle
    4. validate "Drop here." text appears on big circle

    1. Open a chrome browser
    2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
    3. Click and hold small circle
    4. Move it on top of the big circle
    5. validate “Now drop…” text appears on big circ

    1. Open a chrome browser
    2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
    3. Click and hold small circle
    4. Dropped anywhere outside of big circle
    5. validate “Try again!” text appears on big circle
     */

    LoopPracticeDragDropPage dragDropPage;
    Actions actions;

    @BeforeMethod
    public void beforeMethod() {
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        dragDropPage = new LoopPracticeDragDropPage();
        actions = new Actions(Driver.getDriver());
    }
    @AfterMethod
    public void afterMethod() {
        Driver.closeDriver();
    }
    @Test
    public void dragAndDrop() {

        String expected = "Drag the small circle here.";
        String actual = dragDropPage.bigCircle.getText();
        assertEquals(actual, expected);
    }

    @Test
    public void test_dropHere() {
        actions.moveToElement(dragDropPage.smallCircle)
                .clickAndHold()
                .moveByOffset(100, 100)
                .pause(3000)
                .perform();

        assertEquals(dragDropPage.bigCircle.getText(), "Drop here.", "Not matching");

    }

    @Test
    public void drop_here(){
        actions.moveToElement(dragDropPage.smallCircle)
                .clickAndHold()
                .moveByOffset(0, -200)
                .pause(3000)
                .perform();

        assertEquals(dragDropPage.bigCircle.getText(), "Now drop...", "Not matching");
    }

    @Test
    public void drop_anywhere_test(){
        actions.moveToElement(dragDropPage.smallCircle)
                .clickAndHold()
                .moveByOffset(100, 100)
                .pause(3000)
                .release()
                .perform();

        assertEquals(dragDropPage.bigCircle.getText(), "Try again!", "Not matching");
    }
}
