package com.qacart.todo.pages.todo;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.pages.newTodo.NewTodoPage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TodoPage extends PageBase {
    private SHAFT.GUI.WebDriver driver;
    private static By welcomeMessage = By.cssSelector("[data-testid='welcome']");
    private static By addButton = By.cssSelector("[data-testid='add']");
    private static By todoItem = By.cssSelector("[data-testid='todo-item']");
    private static By deleteButton = By.cssSelector("[data-testid='delete']");
    private static By noTodosMessage = By.cssSelector("[data-testid='no-todos']");

    public TodoPage(SHAFT.GUI.WebDriver webDriver){
        super(webDriver);
        this.driver = webDriver;
    }

    @Step("Load Todo page")
    public TodoPage load(){
        driver.browser().navigateToURL(EndPoint.TODO_PAGE_ENDPOINT);
        return this;
    }
    public boolean isWelcomeDisplayed(){
        return this.driver.element().isElementDisplayed(welcomeMessage);
    }

    @Step("Click on plus button")
    public NewTodoPage clickOnPlusButton(){
        this.driver.element().click(addButton);
        return new NewTodoPage(this.driver);
    }
    @Step("Click on delete button")
    public TodoPage clickOnDeleteButton(){
        this.driver.element().click(deleteButton);
        return this;
    }
    public String getTodoText(){
       return this.driver.element().getText(todoItem);
    }
    public boolean isNoTodosMessageDisplayed(){
        return this.driver.element().isElementDisplayed(noTodosMessage);
    }

}
