package com.qacart.todo.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PageCommonVerifications {

    public static void isDisplayed(SHAFT.GUI.WebDriver driver, By elementLocator) {
        Assert.assertTrue(driver.element().isElementDisplayed(elementLocator));
    }

    public static void isEqual(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

}
