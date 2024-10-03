package com.qacart.todo.api.user.login;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.login.requestBody.LoginRequestBody;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginApiActController {

    private static LoginApiActController act;

    private LoginApiActController() {
    }


    public static LoginApiActController getLoginApiActController() {
        if (act == null) {
            return new LoginApiActController();
        }
        return act;
    }

    public Response login(LoginRequestBody request, int statusCode) {
        SHAFT.API api = new SHAFT.API(SHAFT.Properties.web.baseURL());
        return api.post(EndPoint.API_LOGIN_ENDPOINT)
                .setRequestBody(request)
                .setTargetStatusCode(statusCode)
                .setContentType(ContentType.JSON)
                .perform();
    }
}
