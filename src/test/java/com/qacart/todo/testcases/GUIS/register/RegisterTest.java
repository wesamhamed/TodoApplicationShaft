package com.qacart.todo.testcases.GUIS.register;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.data.ErrorMessages;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.pages.register.RegisterPage;
import com.qacart.todo.steps.user.UserSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Auth Feature")
public class RegisterTest extends BaseTest {
    @Story("Login with firstname,lastname,email,password,and confirm password")
    @Description("It will register with firstname,lastname,email,password,and confirm password")
    @Test(description = "Should be able to register with firstname,lastname,email,password,and confirm password")
    public void shouldBeAbleToRegisterWithFirstNameAndLastNameAndEmailAndPasswordAndConfirmPassword(){

        RegisterPage registerPage =  RegisterPage.getInstance();

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequest = userSteps.generateUser();

        boolean isWelcomeDisplayed = registerPage
                .load(getShaftWebDriver())
                .register(getShaftWebDriver(),registerRequest)
                .isWelcomeDisplayed(getShaftWebDriver());

        Assert.assertTrue(isWelcomeDisplayed);
    }
    @Story("Login with the registered email")
    @Description("It will try register with the registered email")
    @Test(description = "should Not Be Able To Login With The registered Email")
    public void shouldNotBeAbleToRegisterWithTheRegisteredEmail(){

        RegisterPage registerPage =  RegisterPage.getInstance();

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequestBody = userSteps.generateUser();
        userSteps.register(registerRequestBody,201);


        boolean isErrorMessageDisplayed = registerPage
                .load(getShaftWebDriver())
                .registerWithTheRegisteredEmail(getShaftWebDriver(),registerRequestBody)
                .isErrorMessageDisplayed(getShaftWebDriver());

        Assert.assertTrue(isErrorMessageDisplayed);
        Assert.assertEquals(registerPage.getErrorMessage(getShaftWebDriver()),ErrorMessages.EMAIL_IS_ALREADY_REGISTERED);
    }
}
