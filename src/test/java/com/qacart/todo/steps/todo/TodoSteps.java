package com.qacart.todo.steps.todo;

import com.github.javafaker.Faker;
import com.qacart.todo.api.todo.TodoAPI;
import com.qacart.todo.models.todo.addTodo.requestBody.AddTodoRequestBody;
import io.restassured.response.Response;

public class TodoSteps {
    public AddTodoRequestBody generateTodo(){
        Faker faker = new Faker();
        String item = faker.book().title();
        Boolean isCompleted = false;
        return AddTodoRequestBody
                .builder()
                .item(item)
                .isCompleted(isCompleted)
                .build();
    }
    public Response addTodo(AddTodoRequestBody addTodoRequest, String token,int statusCode){
        return  TodoAPI.getInstance().addTodo(addTodoRequest,token,statusCode);
    }
    public Response getTodoByID(String token,String taskID,int statusCode){
        return TodoAPI.getInstance().getTodoById(token,taskID,statusCode);
    }
    public Response deleteTodoByID(String token,String taskID,int statusCode){
        return TodoAPI.getInstance().deleteTodoByID(token,taskID,statusCode);
    }
}