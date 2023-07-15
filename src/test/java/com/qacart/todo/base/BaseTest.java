package com.qacart.todo.base;


import com.qacart.todo.utils.CookieUtils;
import com.shaft.driver.SHAFT;

import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.List;

public class BaseTest {
    private final ThreadLocal<SHAFT.GUI.WebDriver> driver = new ThreadLocal<>();

    private SHAFT.GUI.WebDriver createWebDriver(){
        SHAFT.GUI.WebDriver webDriver = driver.get();
        if (webDriver == null) {
            return new SHAFT.GUI.WebDriver();
        }
        return webDriver;
    }
    @BeforeMethod
    public void setUp(){
        SHAFT.GUI.WebDriver webDriver = createWebDriver();
        driver.set(webDriver);
    }
    @AfterMethod
    public void tearDown(){
        SHAFT.GUI.WebDriver webDriver = driver.get();
        if (webDriver != null) {
            driver.get().quit();
        }
        driver.remove();
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