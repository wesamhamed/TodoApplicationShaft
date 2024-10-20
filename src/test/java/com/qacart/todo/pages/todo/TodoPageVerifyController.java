package com.qacart.todo.pages.todo;

import com.qacart.todo.pages.PageCommonVerifications;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;

import static com.qacart.todo.pages.PageCommonVerifications.isDisplayed;
import static com.qacart.todo.pages.PageCommonVerifications.isEqual;

public class TodoPageVerifyController {

    private static TodoPageVerifyController verify;

    private TodoPageVerifyController() {
    }


    public static TodoPageVerifyController getTodoPageVerifyController() {
        if (verify == null) {
            verify = new TodoPageVerifyController();
        }
        return verify;
    }

    @Step("Check if the welcome message is displayed")
    public TodoPageVerifyController welcomeIsDisplayed(SHAFT.GUI.WebDriver driver) {
        isDisplayed(driver, TodoPageGetController.getTodoPageGetController().getWelcomeMessageLocator());
        return this;
    }

    @Step("Check if no todos message is displayed")
    public TodoPageVerifyController noTodosMessageIsDisplayed(SHAFT.GUI.WebDriver driver) {
        isDisplayed(driver, TodoPageGetController.getTodoPageGetController().getNoTodosMessageLocator());
        return TodoPageVerifyController.getTodoPageVerifyController();
    }

    @Step("Verify todo text is correct")
    public TodoPageVerifyController addedTodoTextIsCorrect(String todoText, String getTodoText) {
        isEqual(todoText, getTodoText);
        return this;
    }

}
