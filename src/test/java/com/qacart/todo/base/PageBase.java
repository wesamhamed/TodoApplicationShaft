package com.qacart.todo.base;
import com.shaft.driver.SHAFT;

public class PageBase {
    protected SHAFT.GUI.WebDriver driver;
    public PageBase(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
}