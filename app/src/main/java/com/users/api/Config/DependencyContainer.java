package com.users.api.Config;

import com.users.api.Controller.UserController;
import com.users.api.Dao.UserDao;
import com.users.api.Interfaces.DaoInterface;
import com.users.api.Interfaces.RepositoryInterface;
import com.users.api.Repository.UserRepository;
import com.users.api.Service.UserService;
import io.javalin.Javalin;

public class DependencyContainer {

    public void inject(Javalin app) {
        DaoInterface userDao = new UserDao(Database.connect());
        RepositoryInterface userRepository =  new UserRepository(userDao);
        UserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);
        userController.configRoutes(app);
    }
}
