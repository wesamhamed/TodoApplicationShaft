package com.qacart.todo.pages.newTodo;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.pages.todo.TodoPage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
public class NewTodoPage extends PageBase {
    private SHAFT.GUI.WebDriver driver;
    private static By newTodoInput = By.cssSelector("[data-testid='new-todo']");
    private static By newTaskSubmit = By.cssSelector("[data-testid='submit-newTask']");
    public NewTodoPage(SHAFT.GUI.WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    @Step("Load new todo page")
    public NewTodoPage load(){
        driver.browser().navigateToURL(EndPoint.NEW_TODO_ENDPOINT);
        return this;
    }
    @Step("Add new task")
    public TodoPage addNewTask(String item){
        this.driver.element().type(newTodoInput,item);
        this.driver.element().click(newTaskSubmit);
        return new TodoPage(this.driver);
    }
}
