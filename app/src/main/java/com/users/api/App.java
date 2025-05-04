package com.users.api;

import com.users.api.Config.AppConfig;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = AppConfig.setupConfig();
        app.get("/", ctx -> ctx.result("Hello, world!"));

        app.start(3000);
    }
}
