package com.qacart.todo.pages.login;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.pages.PageCommonActions;
import com.qacart.todo.pages.todo.TodoPageActController;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;

import static com.qacart.todo.pages.PageCommonActions.type;
import static com.qacart.todo.pages.PageCommonActions.visit;

public class LoginPageActController {

    private static LoginPageActController act;


    private LoginPageActController() {
    }

    public static LoginPageActController getLoginPageActController() {
        if (act == null) {
            return new LoginPageActController();
        }
        return act;
    }

    @Step("Load the login page")
    public LoginPageActController load(SHAFT.GUI.WebDriver shaftWebDriver) {
        visit(shaftWebDriver, EndPoint.LOGIN_PAGE_ENDPOINT);
        return this;
    }

    @Step("Login with email and password")
    public TodoPageActController login(SHAFT.GUI.WebDriver shaftWebDriver, RegisterRequestBody registerRequestBody) {
        type(shaftWebDriver, LoginPageGetController.getLoginPageGetController().getEmailInputLocator(), registerRequestBody.getEmail());
        type(shaftWebDriver, LoginPageGetController.getLoginPageGetController().getPasswordInputLocator(), registerRequestBody.getPassword());
        PageCommonActions.click(shaftWebDriver, LoginPageGetController.getLoginPageGetController().getSubmitButtonLocator());
        return TodoPageActController.getTodoPageActController();
    }

    @Step("Login with password is not correct")
    public LoginPageActController loginIfPasswordIsNotCorrect(SHAFT.GUI.WebDriver shaftWebDriver, RegisterRequestBody registerRequestBody) {
        this.login(shaftWebDriver, registerRequestBody);
        return this;
    }

}
