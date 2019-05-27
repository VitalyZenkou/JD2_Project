package com.itacademy.zenkou.jdb2project.dao;


import com.itacademy.zenkou.jdb2project.entity.bd.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao implements BaseDao<Long, User> {

    private static final UserDao INSTANCE = new UserDao();

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
