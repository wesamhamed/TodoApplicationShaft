package com.qacart.todo.pages.login;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.pages.todo.TodoPage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    private static LoginPage loginPage;

    // Elements
    private By emailInputLocator = By.cssSelector("[data-testid='email']");
    private By passwordInputLocator = By.cssSelector("[data-testid='password']");
    private By submitButtonLocator = By.cssSelector("[data-testid='submit']");
    private By errorMessageLocator = By.cssSelector("[data-testid='error-alert'] div:last-child");

    private LoginPage() {
        super();
    }

    public static LoginPage getInstance() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    @Step("Load the login page")
    public LoginPage load(SHAFT.GUI.WebDriver shaftWebDriver) {
        visit(shaftWebDriver,EndPoint.LOGIN_PAGE_ENDPOINT);
        return this;
    }

    @Step("Login with email and password")
    public TodoPage login(SHAFT.GUI.WebDriver shaftWebDriver,RegisterRequestBody registerRequestBody) {
        type(shaftWebDriver,emailInputLocator,registerRequestBody.getEmail());
        type(shaftWebDriver,passwordInputLocator,registerRequestBody.getPassword());
        click(shaftWebDriver,submitButtonLocator);
        return TodoPage.getInstance();
    }

    @Step("Login with password is not correct")
    public LoginPage loginIfPasswordIsNotCorrect(SHAFT.GUI.WebDriver shaftWebDriver, RegisterRequestBody registerRequestBody) {
        this.login(shaftWebDriver,registerRequestBody);
        return LoginPage.getInstance();
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