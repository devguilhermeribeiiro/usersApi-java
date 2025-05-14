package com.users.api.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.users.api.Dto.UserRequestDto;
import com.users.api.Dto.UserResponseDto;
import com.users.api.Entity.User;
import com.users.api.Interfaces.RepositoryInterface;

public class UserService {
    private final RepositoryInterface userRepository;

    public UserService(RepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> getUsers() throws  SQLException {
        List<UserResponseDto> allUsers;

        return  allUsers = userRepository.findAll();
    }

    public UserResponseDto registerUser(UserRequestDto userDto) throws SQLException {
        User user;
        user = new User(null, userDto.name(), userDto.email());

        return userRepository.save(user);
    }

    public UserResponseDto findUser(String id) throws SQLException {
        UUID uuid = UUID.fromString(id);
        return  userRepository.find(uuid);
    }

    public UserResponseDto updateUser(String id, UserRequestDto userRequestDto) throws SQLException {
        UUID uuid = UUID.fromString(id);
        User user = new User(uuid, userRequestDto.name(), userRequestDto.email());

        return userRepository.edit(user);
    }

    public UserResponseDto deleteUser(String id) throws SQLException {
        UUID uuid = UUID.fromString(id);

        return  userRepository.destroy(uuid);
    }

}
