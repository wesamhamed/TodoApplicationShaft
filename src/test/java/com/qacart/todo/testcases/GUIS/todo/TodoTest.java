package com.qacart.todo.testcases.GUIS.todo;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.models.register.responseBody.RegisterResponseBody;
import com.qacart.todo.models.todo.addTodo.requestBody.AddTodoRequestBody;
import com.qacart.todo.pages.home.HomePage;
import com.qacart.todo.pages.todo.TodoPage;
import com.qacart.todo.steps.todo.TodoSteps;
import com.qacart.todo.steps.user.UserSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Feature("Todo Feature")
public class TodoTest extends BaseTest {
    @Story("Add Todo")
    @Test(description = "Should be able to add a new todo correctly")
    public void shouldBeAbleToAddNewTodo() {

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequestBody = userSteps.generateUser();
        Response registerResponse = userSteps.register(registerRequestBody, 201);

        HomePage homePage = HomePage.getInstance();
        homePage.load(getShaftWebDriver());

        List<Cookie> cookies = registerResponse.detailedCookies().asList();
        injectCookiesToBrowser(cookies);

        TodoPage todoPage = TodoPage.getInstance()
                .load(getShaftWebDriver());

        String todoText = "Learn Selenium";

        String getTodoText = todoPage
                .clickOnPlusButton(getShaftWebDriver())
                .addNewTask(getShaftWebDriver(), todoText)
                .getTodoText(getShaftWebDriver());

        Assert.assertEquals(todoText, getTodoText);
    }

    @Story("Delete Todo")
    @Test(description = "Should be able to delete a todo correctly")
    public void shouldBeAbleToDeleteTodo() {

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequestBody = userSteps.generateUser();
        Response registerResponse = userSteps.register(registerRequestBody, 201);
        RegisterResponseBody registerResponseBody = registerResponse.body().as(RegisterResponseBody.class);

        HomePage homePage = HomePage.getInstance();
        homePage.load(getShaftWebDriver());

        List<Cookie> cookies = registerResponse.detailedCookies().asList();
        injectCookiesToBrowser(cookies);

        String token = registerResponseBody.getAccess_token();

        TodoSteps todoSteps = new TodoSteps();
        AddTodoRequestBody addTodoRequest = todoSteps.generateTodo();

        todoSteps.addTodo(addTodoRequest, token, 201);

        TodoPage todoPage = TodoPage.getInstance()
                .load(getShaftWebDriver());

        boolean isNoTodosMessageDisplayed = todoPage
                .clickOnDeleteButton(getShaftWebDriver())
                .isNoTodosMessageDisplayed(getShaftWebDriver());

        Assert.assertTrue(isNoTodosMessageDisplayed);
    }
}