package com.users.api.Config;

import io.javalin.Javalin;

public class AppConfig {

    public static Javalin setupConfig() {
        return Javalin.create(config -> {
            config.http.defaultContentType = "Application/Json";
            config.http.strictContentTypes = true;
        });
    }
}
