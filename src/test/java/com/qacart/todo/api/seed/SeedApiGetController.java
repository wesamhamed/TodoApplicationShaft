package com.qacart.todo.api.seed;

public class SeedApiGetController {

    private static SeedApiGetController get;

    private SeedApiGetController() {
    }

    public static SeedApiGetController getSeedApiGetController() {
        if (get == null) {
            get = new SeedApiGetController();
        }
        return get;
    }
}
