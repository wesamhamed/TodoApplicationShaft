package com.qacart.todo.testcases.apis.user;

import com.github.javafaker.Faker;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.data.ErrorMessages;
import com.qacart.todo.models.error.Error;
import com.qacart.todo.models.login.requestBody.LoginRequestBody;
import com.qacart.todo.models.login.responseBody.LoginResponseBody;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.models.register.responseBody.RegisterResponseBody;
import com.qacart.todo.steps.user.UserSteps;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Feature("User Feature")
public class UserApiTest {
    @Story("Should Be Able To register")
    @Test(description = "should Be Able To register")
    public void shouldBeAbleToRegister(){

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequest = userSteps.generateUser();

        Response response = userSteps.register(registerRequest,201);
        RegisterResponseBody registerResponseBody = response.body()
                .as(RegisterResponseBody.class);

        assertThat(response.statusCode(),equalTo(201));
        assertThat(registerRequest.getFirstName(),equalTo(registerResponseBody.getFirstName()));
    }
    @Story("Should Not Be Able To Login With The Same Email")
    @Test(description = "should Not Be Able To Login With The Same Email")
    public void shouldNotBeAbleToRegisterWithTheSameEmail(){

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequest = userSteps.generateUser();
        userSteps.register(registerRequest,201);

        Response response = userSteps.register(registerRequest,400);
        Error returnedError = response.body().as(Error.class);

        assertThat(response.statusCode(),equalTo(400));
        assertThat(returnedError.getMessage(),equalTo(ErrorMessages.EMAIL_IS_ALREADY_REGISTERED));
    }
    @Story("Should Be Able To Login")
    @Test(description = "should Be Able To Login")
    public void shouldBeAbleToLogin(){

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequest = userSteps.generateUser();
        userSteps.register(registerRequest,201);

        LoginRequestBody loginRequest = new LoginRequestBody(registerRequest.getEmail(),registerRequest.getPassword());
        Response loginResponse = userSteps.login(loginRequest,200);

        LoginResponseBody loginResponseBody = loginResponse.body().as(LoginResponseBody.class);

        assertThat(loginResponse.statusCode(),equalTo(200));
        assertThat(loginResponseBody.getFirstName(),equalTo(registerRequest.getFirstName()));
        assertThat(loginResponseBody.getAccess_token(),is(not(equalTo(null))));
    }
    @Story("Should Not Be Able To Login If Password Is Not Correct")
    @Test(description = "Should Not Be Able To Login If Password Is Not Correct")
    public void ShouldNotBeAbleToLoginIfPasswordIsNotCorrect(){

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequest = userSteps.generateUser();
        userSteps.register(registerRequest,201);

        LoginRequestBody loginRequest =  LoginRequestBody.builder().email(registerRequest.getEmail())
                .password( "wrongPassword").build();

        System.out.println(loginRequest.getEmail());
        System.out.println(loginRequest.getPassword());

        Response loginResponse = userSteps.login(loginRequest,401);
        Error returnedError = loginResponse.body().as(Error.class);

        assertThat(loginResponse.statusCode(),equalTo(401));
        assertThat(returnedError.getMessage(),equalTo(ErrorMessages.EMAIL_OR_PASSWORD_WRONG));
    }
}