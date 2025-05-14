package com.users.api.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
            UserController.createUser(ctx, ctx.bodyAsClass(UserRequestDto.class));
        });
        app.get("/users/{uuid}", ctx -> {
            UserController.findUser(ctx, ctx.pathParam("uuid"));
        });

        app.post("/users/{uuid}", ctx -> {
            UserController.updateUser(ctx, ctx.pathParam("uuid"), ctx.bodyAsClass(UserRequestDto.class));
        });

        app.post("/users/{uuid}/delete", ctx -> UserController.deleteUser(ctx, ctx.pathParam("uuid")));
    }

    private static void getUsers(Context ctx) throws SQLException {
        List<UserResponseDto> responseDto = userService.getUsers();

        if (!responseDto.isEmpty()) ctx.status(200).json(responseDto);

        ctx.status(204);
    }

    private static void createUser(Context ctx, UserRequestDto dto) throws SQLException {
        UserResponseDto responseDto = userService.registerUser(dto);

        ctx.status(201).json(responseDto);
    }

    private  static void findUser(Context ctx, String uuid) throws SQLException {
        UserResponseDto responseDto = userService.findUser(uuid);

        ctx.status(200).json(responseDto);
    }

    public static void updateUser(Context ctx, String uuid, UserRequestDto dto) throws SQLException {
        UserResponseDto responseDto = userService.updateUser(uuid, dto);

        ctx.status(200).json(responseDto);
    }

    public static void deleteUser(Context ctx, String uuid) throws SQLException {
        var response = userService.deleteUser(uuid);

        ctx.status(200).json(response);
    }
}
