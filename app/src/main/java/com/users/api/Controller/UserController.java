package com.users.api.Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class UserController {
    public static void configRoutes(Javalin app) {
        app.get("/users", UserController.getUsers());
    }

    private static void getUsers(Context ctx) {

        // ctx.status(200).json();
    }

}
