package com.qacart.todo.pages.todo;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.qacart.todo.pages.PageCommonActions.getText;

@Getter
public class TodoPageGetController {

    private static TodoPageGetController get;

    private TodoPageGetController() {
    }

    public static TodoPageGetController getTodoPageGetController() {
        if (get == null) {
            get = new TodoPageGetController();
        }
        return get;
    }

    // Elements
    private final By welcomeMessageLocator = By.cssSelector("[data-testid='welcome']");
    private final By addButtonLocator = By.cssSelector("[data-testid='add']");
    private final By todoItemLocator = By.cssSelector("[data-testid='todo-item']");
    private final By deleteButtonLocator = By.cssSelector("[data-testid='delete']");
    private final By noTodosMessageLocator = By.cssSelector("[data-testid='no-todos']");


    @Step("Get the text of the todo")
    public String getTodoText(SHAFT.GUI.WebDriver driver) {
        return getText(driver, todoItemLocator);
    }

}
