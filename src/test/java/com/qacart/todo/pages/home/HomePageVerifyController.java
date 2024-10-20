package com.qacart.todo.pages.home;

public class HomePageVerifyController {

    private static HomePageVerifyController verify;

    private HomePageVerifyController() {

    }

    public static HomePageVerifyController getHomePageVerifyController() {
        if (verify == null) {
            verify = new HomePageVerifyController();
        }
        return verify;
    }

}
