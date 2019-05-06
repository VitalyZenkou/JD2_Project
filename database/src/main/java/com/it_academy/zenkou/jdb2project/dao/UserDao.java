package com.it_academy.zenkou.jdb2project.dao;


import com.it_academy.zenkou.jdb2project.entity.User;
import com.it_academy.zenkou.jdb2project.exception.DaoException;
import com.it_academy.zenkou.jdb2project.utils.ConnectionManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserDao {

    private static final UserDao INSTANCE = new UserDao();
    private static final String SELECT_ALL = "SELECT * FROM \"user\"";

    public static UserDao getInstance() {
        return INSTANCE;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(getUser(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Something went wrong");
        }
        return users;
    }

    private User getUser(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .build();
    }
}
