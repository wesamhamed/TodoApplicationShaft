package com.qacart.todo.pages.register;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.pages.todo.TodoPage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RegisterPage extends PageBase {
    private static By firstNameInput = By.cssSelector("[data-testid='first-name']");
    private static By lastNameInput = By.cssSelector("[data-testid='last-name']");
    private static By emailInput = By.cssSelector("[data-testid='email']");
    private static By passwordInput = By.cssSelector("[data-testid='password']");
    private static By confirmPasswordInput = By.cssSelector("[data-testid='confirm-password']");
    private static By submitButton = By.cssSelector("[data-testid='submit']");
    private static By errorMessage = By.cssSelector("[data-testid='error'] div:last-child");
    private SHAFT.GUI.WebDriver driver;

    public RegisterPage(SHAFT.GUI.WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
    }
    @Step("Load the register page")
    public RegisterPage load() {
        this.driver.browser().navigateToURL(EndPoint.REGISTER_PAGE_ENDPOINT);
        return this;
    }
    @Step("Login with first name, last name,password,and confirm password")
    public TodoPage register(String firstName, String lastName, String email, String password, String confirmPassword) {
        this.driver.element().type(firstNameInput, firstName);
        this.driver.element().type(lastNameInput, lastName);
        this.driver.element().type(emailInput, email);
        this.driver.element().type(passwordInput, password);
        this.driver.element().type(confirmPasswordInput, confirmPassword);
        this.driver.element().click(submitButton);
        return new TodoPage(this.driver);
    }

    @Step("Login with the registered email")
    public RegisterPage registerWithTheRegisteredEmail(String firstName, String lastName, String email, String password, String confirmPassword) {
        this.register(firstName, lastName, email, password, confirmPassword);
        return this;
    }

    public boolean isErrorMessageDisplayed() {
        return this.driver.element().isElementDisplayed(errorMessage);
    }

    public String getErrorMessage() {
        return this.driver.element().getText(errorMessage);
    }
}
