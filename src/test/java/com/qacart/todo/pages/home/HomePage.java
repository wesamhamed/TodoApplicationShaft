package com.qacart.todo.pages.home;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;

public class HomePage extends PageBase {

    private static HomePage homePage;
    private SHAFT.GUI.WebDriver driver;
    // Elements

    // Constructor
    private HomePage() {
        super();
    }

    public static HomePage getInstance() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    @Step("Visiting the home page")
    public HomePage load(SHAFT.GUI.WebDriver shaftWebDriver) {
        visit(shaftWebDriver,EndPoint.HOME_PAGE_ENDPOINT);
        return this;
    }
}