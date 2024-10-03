package com.qacart.todo.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class PageCommonActions {

    public static void visit(SHAFT.GUI.WebDriver driver, String url) {
        driver.browser().navigateToURL(url);
    }

    public static void type(SHAFT.GUI.WebDriver driver, By elementLocator, String text) {
        driver.element().type(elementLocator, text);
    }

    public static void typeAndClear(SHAFT.GUI.WebDriver driver, By elementLocator, String text) {
        driver.element().clear(elementLocator);
        driver.element().type(elementLocator, text);
    }

    public static void clear(SHAFT.GUI.WebDriver driver, By elementLocator) {
        driver.element().clear(elementLocator);
    }

    public static void click(SHAFT.GUI.WebDriver driver, By elementLocator) {
        driver.element().click(elementLocator);
    }

    public static String getText(SHAFT.GUI.WebDriver driver, By elementLocator) {
        return driver.element().getText(elementLocator);
    }

}
