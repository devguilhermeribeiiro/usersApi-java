package com.users.api.Interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.users.api.Dto.UserResponseDto;
import com.users.api.Entity.User;

public interface DaoInterface {
    UserResponseDto create(User user) throws SQLException;

    UserResponseDto read(UUID id) throws SQLException;

    UserResponseDto update(UUID id, String name, String email) throws SQLException;

    UserResponseDto delete(UUID id) throws Exception;

    List<UserResponseDto> getAll() throws SQLException;
}
