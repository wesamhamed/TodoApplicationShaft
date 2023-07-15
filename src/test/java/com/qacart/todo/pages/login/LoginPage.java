package com.qacart.todo.pages.login;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.pages.todo.TodoPage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    private SHAFT.GUI.WebDriver driver;
    private static By emailInput = By.cssSelector("[data-testid='email']");
    private static By passwordInput = By.cssSelector("[data-testid='password']");
    private static By submitButton = By.cssSelector("[data-testid='submit']");
    private static By errorMessage = By.cssSelector("[data-testid='error-alert'] div:last-child");

    public LoginPage(SHAFT.GUI.WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
    }

    @Step("Load the login page")
    public LoginPage load() {
        this.driver.browser().navigateToURL(EndPoint.LOGIN_PAGE_ENDPOINT);
        return this;
    }

    @Step("Login with email and password")
    public TodoPage login(String email, String password) {
        this.driver.element().type(emailInput, email);
        this.driver.element().type(passwordInput, password);
        this.driver.element().click(submitButton);
        return new TodoPage(this.driver);
    }

    @Step("Login with password is not correct")
    public LoginPage loginIfPasswordIsNotCorrect(String email, String password) {
        this.login(email, password);
        return this;
    }

    public boolean isErrorMessageDisplayed() {
        return this.driver.element().isElementDisplayed(errorMessage);
    }

    public String getErrorMessage() {
        return this.driver.element().getText(errorMessage);
    }
}