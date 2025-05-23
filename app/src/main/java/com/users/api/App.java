package com.users.api;

import java.util.Map;

import com.users.api.Config.AppConfig;
import com.users.api.Config.DependencyContainer;
import com.users.api.Controller.UserController;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = AppConfig.setupConfig();
        DependencyContainer dependencies = new DependencyContainer();

        dependencies.inject(app);

        app.get("/", ctx -> ctx.json(Map.of("message", "Hello, world!")));
        app.start(3000);
    }
}
