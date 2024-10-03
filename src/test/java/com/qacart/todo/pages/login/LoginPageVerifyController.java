package com.qacart.todo.pages.login;

import com.qacart.todo.data.ErrorMessages;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;

import static com.qacart.todo.pages.PageCommonVerifications.isDisplayed;
import static com.qacart.todo.pages.PageCommonVerifications.isEqual;

public class LoginPageVerifyController {

    private static LoginPageVerifyController verify;

    private LoginPageVerifyController() {

    }

    public static LoginPageVerifyController getLoginPageVerifyController() {
        if (verify == null) {
            return new LoginPageVerifyController();
        }
        return verify;
    }


    @Step("Check if the error message is displayed")
    public LoginPageVerifyController errorMessageIsDisplayed(SHAFT.GUI.WebDriver driver) {
        isDisplayed(driver, LoginPageGetController.getLoginPageGetController().getErrorMessageLocator());
        return this;
    }


    @Step("Check if the error message is displayed")
    public LoginPageVerifyController emailAndPasswordNotCorrectLogin(SHAFT.GUI.WebDriver driver) {
        isEqual(LoginPageGetController.getLoginPageGetController().getErrorMessageText(driver), ErrorMessages.EMAIL_AND_PASSWORD_NOT_CORRECT_LOGIN);
        return this;
    }

}
