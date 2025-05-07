package com.users.api.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.users.api.Dto.UserResponseDto;
import com.users.api.Entity.User;
import com.users.api.Interfaces.DaoInterface;

public class UserDao implements DaoInterface {
    private final Connection conn;

    public UserDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public UserResponseDto create(User user) throws SQLException {
        UserResponseDto userResponseDto = null;

        try (PreparedStatement query = conn
                .prepareStatement("INSERT INTO users (id, name, email) VALUES (?, ?, ?)")) {

            conn.setAutoCommit(false);

            query.setObject(1, user.getId());
            query.setString(2, user.getName());
            query.setString(3, user.getEmail());

            ResultSet rs = query.executeQuery();
            conn.commit();

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                userResponseDto = new UserResponseDto("Success", id, name, email);
            }


        } catch (SQLException e) {
            e.getStackTrace();

            System.err.print("Transaction is being rolled back");
            conn.rollback();
        }

        return userResponseDto;
    }

    @Override
    public UserResponseDto read(UUID id) throws SQLException {
        UserResponseDto userResponseDto = null;

        try (PreparedStatement query = conn.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            conn.setAutoCommit(false);

            query.setObject(1, id);

            ResultSet rs = query.executeQuery();
            conn.commit();

            while (rs.next()) {
                String uuid = rs.getString("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                userResponseDto = new UserResponseDto("Success", uuid, name, email);
            }

        } catch (SQLException e) {
            e.getStackTrace();

            System.err.print("Transaction is being rolled back");
            conn.rollback();
        }

        return userResponseDto;
    }

    @Override
    public UserResponseDto update(UUID id, String name, String email) throws SQLException {
        UserResponseDto userResponseDto = null;
        try (PreparedStatement query = conn.prepareStatement("UPDATE users SET name = ?, email = ? WHERE id = ?")) {
            conn.setAutoCommit(false);

            query.setString(1, name);
            query.setString(2, email);
            query.setObject(3, id);

            ResultSet rs = query.executeQuery();
            conn.commit();

            while (rs.next()) {
                String uuid = rs.getString("id");
                String _name = rs.getString("name");
                String _email = rs.getString("email");

                userResponseDto = new UserResponseDto("Success", uuid, _name, _email);
            }

        } catch (SQLException e) {
            e.getStackTrace();

            System.err.print("Transaction is being rolled back");
            conn.rollback();
        }
        return  userResponseDto;
    }

    @Override
    public UserResponseDto delete(UUID id) throws Exception {
        UserResponseDto userResponseDto = null;

        try (PreparedStatement query = conn.prepareStatement("DELETE FROM users WHERE id = ?")) {
            conn.setAutoCommit(false);

            query.setObject(1, id);

            ResultSet rs = query.executeQuery();
            conn.commit();

            while (rs.next()) {
                String uuid = rs.getString("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                userResponseDto = new UserResponseDto("Success", uuid, name, email);
            }

        } catch (SQLException e) {
            e.getStackTrace();

            System.err.print("Transaction is being rolled back");
            conn.rollback();
        }
        return userResponseDto;
    }

}
