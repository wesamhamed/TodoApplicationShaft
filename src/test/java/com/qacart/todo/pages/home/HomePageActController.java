package com.qacart.todo.pages.home;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.pages.PageCommonActions;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;

public class HomePageActController {

    private static HomePageActController act;

    public HomePageActController() {
    }


    public static HomePageActController getHomePageActController() {
        if (act == null) {
            return new HomePageActController();
        }
        return act;
    }

    @Step("Visiting the home page")
    public HomePageActController load(SHAFT.GUI.WebDriver shaftWebDriver) {
        PageCommonActions.visit(shaftWebDriver, EndPoint.HOME_PAGE_ENDPOINT);
        return this;
    }

}
