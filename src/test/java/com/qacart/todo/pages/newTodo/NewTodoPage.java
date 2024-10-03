package com.qacart.todo.pages.newTodo;

public class NewTodoPage {

    private static NewTodoPage newTodoPage;

    private NewTodoPageActController act;
    private NewTodoPageVerifyController verify;
    private NewTodoPageGetController get;

    public NewTodoPageActController act() {
        return act;
    }

    public NewTodoPageVerifyController verify() {
        return verify;
    }

    public NewTodoPageGetController get() {
        return get;
    }

    private NewTodoPage() {
    }

    private NewTodoPage(NewTodoPageActController act, NewTodoPageVerifyController verify, NewTodoPageGetController get) {
        this.act = act;
        this.verify = verify;
        this.get = get;
    }

    public static NewTodoPage getNewTodoPage() {
        if (newTodoPage == null) {
            newTodoPage = new NewTodoPage(NewTodoPageActController.getNewTodoPageActController(), NewTodoPageVerifyController.getNewTodoPageVerifyController(), NewTodoPageGetController.getNewTodoPageGetController());
        }
        return newTodoPage;
    }


}
