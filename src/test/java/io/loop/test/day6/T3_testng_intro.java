package io.loop.test.day6;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class T3_testng_intro {

    @Test (priority = 1)
    public void test2(){
        System.out.println("Test 2 is running");
        String actual = "Nina";
        String expected = "Nina";
        assertEquals(actual,expected, "Actual does NOT equal expected");
    }
    @Test (priority = 2)
    public void test1(){
        System.out.println("Test 1 is running");
        String actual = "Feyruz";
        String expected = "Nadir";
        assertEquals(actual,expected, "This massage will show only if test fails");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before Method is running");
    }

    @BeforeClass
    public void tearDownMethod(){
        System.out.println("Before Class is running");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("After Class is running");
    }
}
