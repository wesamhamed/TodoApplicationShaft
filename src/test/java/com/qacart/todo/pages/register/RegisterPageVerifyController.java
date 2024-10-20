package com.qacart.todo.pages.register;

import com.qacart.todo.data.ErrorMessages;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;

import static com.qacart.todo.pages.PageCommonVerifications.isDisplayed;
import static com.qacart.todo.pages.PageCommonVerifications.isEqual;

public class RegisterPageVerifyController {
    private static RegisterPageVerifyController verify;

    private RegisterPageVerifyController() {
    }


    public static RegisterPageVerifyController getRegisterPageVerifyController() {
        if (verify == null) {
            verify = new RegisterPageVerifyController();
        }
        return verify;
    }


    @Step("Check if the error message is displayed")
    public RegisterPageVerifyController errorMessageIsDisplayed(SHAFT.GUI.WebDriver driver) {
        isDisplayed(driver, RegisterPageGetController.getRegisterPageGetController().getErrorMessageLocator());
        return this;
    }

    @Step("Verify email is already registered")
    public RegisterPageVerifyController emailIsAlreadyRegistered(SHAFT.GUI.WebDriver driver) {
        isEqual(RegisterPageGetController.getRegisterPageGetController().getErrorMessageText(driver), ErrorMessages.EMAIL_IS_ALREADY_REGISTERED);
        return this;
    }

}
