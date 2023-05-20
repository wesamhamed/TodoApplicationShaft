package com.qacart.todo.base;


import com.qacart.todo.utils.CookieUtils;
import com.shaft.driver.SHAFT;

import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.List;

public class BaseTest {
    private static ThreadLocal<SHAFT.GUI.WebDriver> driver = new ThreadLocal<>();
    @BeforeMethod
    public void setUp(){
        driver.set(new SHAFT.GUI.WebDriver());
    }
    @AfterMethod
    public void tearDown(){
        driver.get().quit();
    }

    protected SHAFT.GUI.WebDriver getDriver() {
        return driver.get();
    }

    @Step
    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies){
        List<org.openqa.selenium.Cookie> seleniumCookies = CookieUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
        for(org.openqa.selenium.Cookie cookie : seleniumCookies){
            driver.get().browser().addCookie(cookie.getName(),cookie.getValue());

        }
        driver.get().browser().refreshCurrentPage();
    }

}