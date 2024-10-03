package com.qacart.todo.testcases.GUIS.todo;

import com.qacart.todo.api.todo.TodoApi;
import com.qacart.todo.api.user.register.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.models.register.responseBody.RegisterResponseBody;
import com.qacart.todo.models.todo.addTodo.requestBody.AddTodoRequestBody;
import com.qacart.todo.pages.home.HomePage;
import com.qacart.todo.pages.todo.TodoPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

@Feature("Todo Feature")
public class TodoTest extends BaseTest {

    RegisterApi registerApi = RegisterApi.getRegisterApi();
    HomePage homePage = HomePage.getHomePage();
    TodoPage todoPage = TodoPage.getTodoPage();
    TodoApi todoApi = TodoApi.getTodoApi();

    @Story("Add Todo")
    @Test(description = "Should be able to add a new todo correctly")
    public void shouldBeAbleToAddNewTodo() {

        RegisterRequestBody registerRequestBody = registerApi.get()
                .generateUser();

        Response registerResponse = registerApi.act()
                .register(registerRequestBody, 201);


        homePage.act()
                .load(getShaftWebDriver());

        List<Cookie> cookies = registerResponse.detailedCookies().asList();
        injectCookiesToBrowser(cookies);

        todoPage.act()
                .load(getShaftWebDriver());

        String todoText = "Learn Selenium";

        todoPage.act()
                .clickOnPlusButton(getShaftWebDriver())
                .addNewTask(getShaftWebDriver(), todoText);

        String getTodoText = todoPage.get()
                .getTodoText(getShaftWebDriver());

        todoPage.verify()
                .addedTodoTextIsCorrect(todoText, getTodoText);

    }

    @Story("Delete Todo")
    @Test(description = "Should be able to delete a todo correctly")
    public void shouldBeAbleToDeleteTodo() {

        RegisterRequestBody registerRequestBody = registerApi.get()
                .generateUser();

        Response registerResponse = registerApi.act()
                .register(registerRequestBody, 201);


        RegisterResponseBody registerResponseBody = registerApi.get()
                .registerResponseBody(registerResponse);

        homePage.act()
                .load(getShaftWebDriver());


        List<Cookie> cookies = registerResponse.detailedCookies().asList();
        injectCookiesToBrowser(cookies);

        String token = registerResponseBody.getAccess_token();

        AddTodoRequestBody addTodoRequest = todoApi.get()
                .generateTodo();

        todoApi.act()
                .addTodo(addTodoRequest, token, 201);


        todoPage.act()
                .load(getShaftWebDriver());

        todoPage.act()
                .clickOnDeleteButton(getShaftWebDriver());

        todoPage.verify()
                .noTodosMessageIsDisplayed(getShaftWebDriver());

    }
}