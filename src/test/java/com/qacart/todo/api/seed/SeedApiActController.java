package com.qacart.todo.api.seed;

import com.qacart.todo.config.EndPoint;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SeedApiActController {

    private static SeedApiActController act;

    private SeedApiActController() {

    }

    public static SeedApiActController getSeedApiActController() {
        if (act == null) {
            act = new SeedApiActController();
        }
        return act;
    }

    public Response setupDatabase() {
        SHAFT.API api = new SHAFT.API(SHAFT.Properties.web.baseURL());

        return api.get(EndPoint.API_SEED_ENDPOINT)
                .setContentType(ContentType.JSON)
                .perform();
    }
}
