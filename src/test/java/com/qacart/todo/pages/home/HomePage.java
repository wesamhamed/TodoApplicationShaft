package com.qacart.todo.pages.home;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.shaft.driver.SHAFT;

public class HomePage extends PageBase {

    private SHAFT.GUI.WebDriver driver;
    public HomePage(SHAFT.GUI.WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public HomePage load(){
        driver.browser().navigateToURL(EndPoint.HOME_PAGE_ENDPOINT);
        return this;
    }
}