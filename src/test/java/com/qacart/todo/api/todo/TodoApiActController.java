package com.qacart.todo.api.todo;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.todo.addTodo.requestBody.AddTodoRequestBody;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TodoApiActController {

    private static TodoApiActController act;

    private TodoApiActController() {

    }


    public static TodoApiActController getTodoApiActController() {
        if (act == null) {
            return new TodoApiActController();
        }
        return act;
    }
    public Response addTodo(AddTodoRequestBody request, String token, int statusCode) {
        SHAFT.API api = new SHAFT.API(SHAFT.Properties.web.baseURL());
        return api.post(EndPoint.API_TODO_ENDPOINT)
                .addHeader("Authorization", "Bearer " + token)
                .setRequestBody(request)
                .setTargetStatusCode(statusCode)
                .setContentType(ContentType.JSON)
                .perform();
    }

    public Response deleteTodoByID(String token, String taskID, int statusCode) {
        SHAFT.API api = new SHAFT.API(SHAFT.Properties.web.baseURL());
        return api.delete(EndPoint.API_TODO_ENDPOINT + "/" + taskID)
                .addHeader("Authorization", "Bearer " + token)
                .setTargetStatusCode(statusCode)
                .setContentType(ContentType.JSON)
                .perform();
    }

    public Response getTodoById(String token, String taskID, int statusCode) {
        SHAFT.API api = new SHAFT.API(SHAFT.Properties.web.baseURL());
        return api.get(EndPoint.API_TODO_ENDPOINT + "/" + taskID)
                .addHeader("Authorization", "Bearer " + token)
                .setTargetStatusCode(statusCode)
                .setContentType(ContentType.JSON)
                .perform();
    }

}
