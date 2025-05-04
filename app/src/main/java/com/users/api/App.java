package com.users.api;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(3000);
        app.get("/", ctx -> ctx.result("Hello, world!"));
    }
}
