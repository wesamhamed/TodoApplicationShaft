package com.qacart.todo.base;


import com.qacart.todo.utils.CookieUtils;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.List;

public class BaseTest {
    private final ThreadLocal<SHAFT.GUI.WebDriver> shaftWebDriver = new ThreadLocal<>();

    protected SHAFT.GUI.WebDriver getShaftWebDriver() {
        return this.shaftWebDriver.get();
    }
    public void setShaftWebDriver(SHAFT.GUI.WebDriver shaftWebDriver) {
        this.shaftWebDriver.set(shaftWebDriver);
    }

    private SHAFT.GUI.WebDriver createShaftWebDriver(){
        SHAFT.GUI.WebDriver shaftWebDriver = getShaftWebDriver();
        if (shaftWebDriver == null) {
            return new SHAFT.GUI.WebDriver();
        }
        return shaftWebDriver;
    }
    @BeforeMethod
    public void setUp(){
        SHAFT.GUI.WebDriver shaftWebDriver = createShaftWebDriver();
        setShaftWebDriver(shaftWebDriver);
    }
    @AfterMethod
    public void tearDown(){
        SHAFT.GUI.WebDriver shaftWebDriver = getShaftWebDriver();
        if (shaftWebDriver != null) {
            shaftWebDriver.quit();
        }
        this.shaftWebDriver.remove();
    }


    @Step
    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies){
        List<org.openqa.selenium.Cookie> seleniumCookies = CookieUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
        for(org.openqa.selenium.Cookie cookie : seleniumCookies){
            getShaftWebDriver().browser().addCookie(cookie.getName(),cookie.getValue());
        }
        getShaftWebDriver().browser().refreshCurrentPage();
    }

}