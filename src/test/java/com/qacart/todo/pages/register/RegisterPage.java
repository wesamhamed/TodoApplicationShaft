package com.qacart.todo.pages.register;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.pages.todo.TodoPage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends PageBase {
    private static RegisterPage registerPage;

    // Elements
    private By firstNameInputLocator = By.cssSelector("[data-testid='first-name']");
    private By lastNameInputLocator = By.cssSelector("[data-testid='last-name']");
    private By emailInputLocator = By.cssSelector("[data-testid='email']");
    private By passwordInputLocator = By.cssSelector("[data-testid='password']");
    private By confirmPasswordInputLocator = By.cssSelector("[data-testid='confirm-password']");
    private By submitButtonLocator = By.cssSelector("[data-testid='submit']");
    private By errorMessageLocator = By.cssSelector("[data-testid='error'] div:last-child");

    // Constructor
    private RegisterPage() {
        super();
    }

    public static RegisterPage getInstance() {
        if (registerPage == null) {
            registerPage = new RegisterPage();
        }
        return registerPage;
    }

    // Methods, steps
    @Step("Visit the signup page")
    public RegisterPage load(SHAFT.GUI.WebDriver shaftWebDriver) {
        visit(shaftWebDriver, EndPoint.REGISTER_PAGE_ENDPOINT);
        return this;
    }

    @Step("Login with first name, last name,password,and confirm password")
    public TodoPage register(SHAFT.GUI.WebDriver shaftWebDriver, RegisterRequestBody registerRequestBody) {
        type(shaftWebDriver,firstNameInputLocator,registerRequestBody.getFirstName());
        type(shaftWebDriver,lastNameInputLocator,registerRequestBody.getLastName());
        type(shaftWebDriver,emailInputLocator,registerRequestBody.getEmail());
        type(shaftWebDriver,passwordInputLocator,registerRequestBody.getPassword());
        type(shaftWebDriver,confirmPasswordInputLocator,registerRequestBody.getPassword());
        click(shaftWebDriver,submitButtonLocator);
        return TodoPage.getInstance();
    }

    @Step("Login with the registered email")
    public RegisterPage registerWithTheRegisteredEmail(SHAFT.GUI.WebDriver shaftWebDriver, RegisterRequestBody registerRequestBody) {
        this.register(shaftWebDriver, registerRequestBody);
        return RegisterPage.getInstance();
    }
    @Step("Check if the error message is displayed")
    public boolean isErrorMessageDisplayed(SHAFT.GUI.WebDriver shaftWebDriver) {
        return isDisplayed(shaftWebDriver,errorMessageLocator);
    }
    @Step("Get the text of the error message")
    public String getErrorMessage(SHAFT.GUI.WebDriver shaftWebDriver) {
        return getText(shaftWebDriver,errorMessageLocator);
    }
}
