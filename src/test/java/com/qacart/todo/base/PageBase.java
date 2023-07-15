package com.qacart.todo.base;

import com.qacart.todo.config.EndPoint;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBase {

    public PageBase(){
    }
    protected void visit(SHAFT.GUI.WebDriver shaftWebDriver, String url){
        shaftWebDriver.browser().navigateToURL(url);
    }
    protected void type(SHAFT.GUI.WebDriver shaftWebDriver, By elementLocator, String text){
        shaftWebDriver.element().type(elementLocator,text);
    }
    protected void click(SHAFT.GUI.WebDriver shaftWebDriver,By elementLocator){
        shaftWebDriver.element().click(elementLocator);
    }
    protected String getText(SHAFT.GUI.WebDriver shaftWebDriver,By elementLocator){
        return shaftWebDriver.element().getText(elementLocator);
    }
    protected boolean isDisplayed(SHAFT.GUI.WebDriver shaftWebDriver,By elementLocator){
        return shaftWebDriver.element().isElementDisplayed(elementLocator);
    }
}