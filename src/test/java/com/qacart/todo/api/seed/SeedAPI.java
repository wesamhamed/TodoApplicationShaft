package com.qacart.todo.api.seed;

import com.qacart.todo.config.EndPoint;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SeedAPI {

    private static SeedAPI seedAPi;

    private SeedAPI() {

    }

    public static SeedAPI getInstance() {
        if (seedAPi == null) {
            seedAPi = new SeedAPI();
        }
        return seedAPi;
    }

    public Response setupDatabase() {
        SHAFT.API api = new SHAFT.API(SHAFT.Properties.web.baseURL());

        return api.get(EndPoint.API_SEED_ENDPOINT)
                .setContentType(ContentType.JSON)
                .perform();
    }
}