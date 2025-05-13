package com.users.api.Repository;

import com.users.api.Dao.UserDao;
import com.users.api.Dto.UserResponseDto;
import com.users.api.Entity.User;
import com.users.api.Interfaces.DaoInterface;
import com.users.api.Interfaces.RepositoryInterface;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class UserRepository implements RepositoryInterface {
    private final DaoInterface userDao;

    public UserRepository(DaoInterface userDao) { this.userDao = userDao; }

    @Override
    public List<UserResponseDto> findAll() throws SQLException {
        return userDao.getAll();
    }

    @Override
    public UserResponseDto save(User user) throws SQLException {
        return userDao.create(user);
    }

    @Override
    public UserResponseDto find(UUID id) throws SQLException {
        return userDao.read(id);
    }

    @Override
    public UserResponseDto edit(User user) throws SQLException {
        return userDao.update(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public UserResponseDto destroy(UUID id) throws Exception {
        return userDao.delete(id);
    }
}
