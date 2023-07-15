package com.qacart.todo.pages.newTodo;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.pages.todo.TodoPage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NewTodoPage extends PageBase {
    private static NewTodoPage newTodoPage;

    // Elements
    private By newTodoInputLocator = By.cssSelector("[data-testid='new-todo']");
    private By newTaskSubmitLocator = By.cssSelector("[data-testid='submit-newTask']");

    // Constructor
    private NewTodoPage() {
        super();
    }

    public static NewTodoPage getInstance() {
        if (newTodoPage == null) {
            newTodoPage = new NewTodoPage();
        }
        return newTodoPage;
    }
    // Methods, Steps
    @Step("Visiting  new todo page")
    public NewTodoPage load(SHAFT.GUI.WebDriver shaftWebDriver) {
        visit(shaftWebDriver,EndPoint.NEW_TODO_ENDPOINT);
        return this;
    }
    @Step("Add new task")
    public TodoPage addNewTask(SHAFT.GUI.WebDriver shaftWebDriver,String item){
        type(shaftWebDriver,newTodoInputLocator,item);
        click(shaftWebDriver,newTaskSubmitLocator);
        return TodoPage.getInstance();
    }
}
