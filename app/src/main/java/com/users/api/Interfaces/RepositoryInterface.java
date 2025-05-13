package com.users.api.Interfaces;

import com.users.api.Dto.UserResponseDto;
import com.users.api.Entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface RepositoryInterface {
    List<UserResponseDto> findAll() throws SQLException;

    UserResponseDto save(User user) throws SQLException;

    UserResponseDto find(UUID id) throws SQLException;

    UserResponseDto edit(User user) throws SQLException;

    UserResponseDto destroy(UUID id) throws Exception;
}
