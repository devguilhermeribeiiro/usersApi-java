package com.users.api.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.users.api.Config.DependencyContainer;
import com.users.api.Dto.UserRequestDto;
import com.users.api.Dto.UserResponseDto;
import com.users.api.Service.UserService;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class UserController {
    private static UserService userService;

    public UserController(UserService userService) {
        UserController.userService = userService;
    }

    public void configRoutes(Javalin app) {
        app.get("/users", UserController::getUsers);
        app.post("/users", ctx -> {
            UserController.create(ctx, ctx.bodyAsClass(UserRequestDto.class));
        });
    }

    private static void getUsers(Context ctx) throws SQLException {
        List<UserResponseDto> responseDto = userService.getActives();

        ctx.status(200).json(responseDto);
    }

    private static void create(Context ctx, UserRequestDto dto) throws SQLException {
        UserResponseDto responseDto = userService.registerUser(dto);

        ctx.status(201).json(responseDto);
    }

}
