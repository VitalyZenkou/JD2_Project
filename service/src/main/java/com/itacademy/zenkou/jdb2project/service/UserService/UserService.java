package com.itacademy.zenkou.jdb2project.service.UserService;

import com.itacademy.zenkou.jdb2project.dao.UserDao;
import com.itacademy.zenkou.jdb2project.entity.bd.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    public static UserService getInstance() {
        return INSTANCE;
    }

    public Optional<User> getUserByName(Long userId) {
        return UserDao.getInstance().get(userId);
    }

    public List<User> getUsers() {
        return UserDao.getInstance().getAll();
    }
}
