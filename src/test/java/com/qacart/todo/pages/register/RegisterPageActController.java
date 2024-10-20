package com.qacart.todo.pages.register;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.pages.todo.TodoPageActController;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;

import static com.qacart.todo.pages.PageCommonActions.*;


public class RegisterPageActController {

    private static RegisterPageActController act;

    private RegisterPageActController() {
    }

    public static RegisterPageActController getRegisterPageActController() {
        if (act == null) {
            act = new RegisterPageActController();
        }
        return act;
    }

    @Step("Visit the signup page")
    public RegisterPageActController load(SHAFT.GUI.WebDriver driver) {
        visit(driver, EndPoint.REGISTER_PAGE_ENDPOINT);
        return this;
    }

    @Step("Login with first name, last name,password,and confirm password")
    public TodoPageActController register(SHAFT.GUI.WebDriver driver, RegisterRequestBody registerRequestBody) {
        typeAndClear(driver, RegisterPageGetController.getRegisterPageGetController().getFirstNameInputLocator(), registerRequestBody.getFirstName());
        typeAndClear(driver, RegisterPageGetController.getRegisterPageGetController().getLastNameInputLocator(), registerRequestBody.getLastName());
        type(driver, RegisterPageGetController.getRegisterPageGetController().getEmailInputLocator(), registerRequestBody.getEmail());
        typeAndClear(driver, RegisterPageGetController.getRegisterPageGetController().getPasswordInputLocator(), registerRequestBody.getPassword());
        typeAndClear(driver, RegisterPageGetController.getRegisterPageGetController().getConfirmPasswordInputLocator(), registerRequestBody.getPassword());
        click(driver, RegisterPageGetController.getRegisterPageGetController().getSubmitButtonLocator());
        return TodoPageActController.getTodoPageActController();
    }

    @Step("Login with the registered email")
    public RegisterPageActController registerWithTheRegisteredEmail(SHAFT.GUI.WebDriver driver, RegisterRequestBody registerRequestBody) {
        this.register(driver, registerRequestBody);
        return this;
    }

}
