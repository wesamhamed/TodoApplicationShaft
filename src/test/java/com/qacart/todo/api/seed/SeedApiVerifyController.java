package com.qacart.todo.api.seed;

public class SeedApiVerifyController {

    private static SeedApiVerifyController verify;

    private SeedApiVerifyController() {

    }

    public static SeedApiVerifyController getSeedApiVerifyController() {
        if (verify == null) {
            verify = new SeedApiVerifyController();
        }
        return verify;
    }

}
