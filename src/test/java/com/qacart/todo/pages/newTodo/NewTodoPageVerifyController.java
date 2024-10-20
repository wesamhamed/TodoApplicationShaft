package com.qacart.todo.pages.newTodo;

public class NewTodoPageVerifyController {

    private static NewTodoPageVerifyController verify;

    private NewTodoPageVerifyController() {

    }

    public static NewTodoPageVerifyController getNewTodoPageVerifyController() {
        if (verify == null) {
            verify = new NewTodoPageVerifyController();
        }
        return verify;
    }

}
