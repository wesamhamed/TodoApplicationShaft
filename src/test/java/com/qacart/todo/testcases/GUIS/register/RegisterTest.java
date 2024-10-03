package com.qacart.todo.testcases.GUIS.register;

import com.qacart.todo.api.user.register.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.pages.register.RegisterPage;
import com.qacart.todo.pages.todo.TodoPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Auth Feature")
public class RegisterTest extends BaseTest {

    RegisterApi registerApi = RegisterApi.getRegisterApi();
    RegisterPage registerPage = RegisterPage.getRegisterPage();
    TodoPage todoPage = TodoPage.getTodoPage();

    @Story("Login with firstname,lastname,email,password,and confirm password")
    @Description("It will register with firstname,lastname,email,password,and confirm password")
    @Test(description = "Should be able to register with firstname,lastname,email,password,and confirm password")
    public void shouldBeAbleToRegisterWithFirstNameAndLastNameAndEmailAndPasswordAndConfirmPassword() {

        RegisterRequestBody registerRequest = registerApi.get()
                .generateUser();

        registerPage.act()
                .load(getShaftWebDriver())
                .register(getShaftWebDriver(), registerRequest);

        todoPage.verify()
                .welcomeIsDisplayed(getShaftWebDriver());

    }

    @Story("Login with the registered email")
    @Description("It will try register with the registered email")
    @Test(description = "should Not Be Able To Login With The registered Email")
    public void shouldNotBeAbleToRegisterWithTheRegisteredEmail() {

        RegisterRequestBody registerRequestBody = registerApi.get()
                .generateUser();

        registerApi.act()
                .register(registerRequestBody, 201);


        registerPage.act()
                .load(getShaftWebDriver())
                .registerWithTheRegisteredEmail(getShaftWebDriver(), registerRequestBody);

        registerPage.verify()
                .errorMessageIsDisplayed(getShaftWebDriver())
                .emailIsAlreadyRegistered(getShaftWebDriver());
    }
}
