package com.qacart.todo.utils;

import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {
    public static List<Cookie> convertRestAssuredCookiesToSeleniumCookies(List<io.restassured.http.Cookie> restAssuredCookies){
        List<org.openqa.selenium.Cookie> seleniumCookies = new ArrayList<>();
        for (io.restassured.http.Cookie cookie : restAssuredCookies){
            org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie(cookie.getName(),cookie.getValue());
            seleniumCookies.add(seleniumCookie);
        }
        return seleniumCookies;
    }
}
