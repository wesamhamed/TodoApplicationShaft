package com.qacart.todo.pages.register;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.pages.todo.TodoPage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RegisterPage extends PageBase {
    private By firstNameInput = By.cssSelector("[data-testid='first-name']");
    private By lastNameInput = By.cssSelector("[data-testid='last-name']");
    private By emailInput = By.cssSelector("[data-testid='email']");
    private By passwordInput = By.cssSelector("[data-testid='password']");
    private By confirmPasswordInput = By.cssSelector("[data-testid='confirm-password']");
    private By submitButton = By.cssSelector("[data-testid='submit']");
    private By errorMessage = By.cssSelector("[data-testid='error'] div:last-child");
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
        this.driver.element().type(this.firstNameInput, firstName);
        this.driver.element().type(this.lastNameInput, lastName);
        this.driver.element().type(this.emailInput, email);
        this.driver.element().type(this.passwordInput, password);
        this.driver.element().type(this.confirmPasswordInput, confirmPassword);
        this.driver.element().click(this.submitButton);
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
