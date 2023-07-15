package com.qacart.todo.api.user.register;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class RegisterAPI {
    private static RegisterAPI registerAPI;

    private RegisterAPI() {

    }

    public static RegisterAPI getInstance() {
        if (registerAPI == null) {
            return new RegisterAPI();
        }
        return registerAPI;
    }

    public Response register(RegisterRequestBody request, int statusCode) {
        SHAFT.API api = new SHAFT.API(SHAFT.Properties.web.baseURL());
        return api.post(EndPoint.API_REGISTER_ENDPOINT)
                .setRequestBody(request)
                .setContentType(ContentType.JSON)
                .setTargetStatusCode(statusCode)
                .perform();
    }
}