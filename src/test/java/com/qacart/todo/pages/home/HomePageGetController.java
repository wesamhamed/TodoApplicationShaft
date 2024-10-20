package com.qacart.todo.pages.home;

import lombok.Getter;

@Getter
public class HomePageGetController {

    private static HomePageGetController get;

    private HomePageGetController() {

    }

    public static HomePageGetController getHomePageGetController() {
        if (get == null) {
            get = new HomePageGetController();
        }
        return get;
    }

}
