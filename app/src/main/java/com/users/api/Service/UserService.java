package com.users.api.Service;

import java.sql.SQLException;
import java.util.List;

import com.users.api.Dto.UserRequestDto;
import com.users.api.Dto.UserResponseDto;
import com.users.api.Entity.User;
import com.users.api.Interfaces.RepositoryInterface;
import com.users.api.Repository.UserRepository;

public class UserService {
    private final RepositoryInterface userRepository;

    public UserService(RepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> getActives() throws  SQLException {
        List<UserResponseDto> allUsers;
        List<UserResponseDto> usersActives;

        allUsers = userRepository.findAll();
        /* Implements filter to get only active users.
        *
        * for ( user : allUsers) {
        *   if (user.active) { usersActives.add(user); }
        * }
        * */
        return allUsers;
    }

    public UserResponseDto registerUser(UserRequestDto userDto) throws SQLException {
        User user;
        user = new User(userDto.name(), userDto.email());

        return userRepository.save(user);
    }

}
