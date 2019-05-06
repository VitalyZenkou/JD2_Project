package com.it_academy.zenkou.jdb2project.service.UserService;

import com.it_academy.zenkou.jdb2project.dao.UserDao;
import com.it_academy.zenkou.jdb2project.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    public List<User> getUsers() {
        return UserDao.getInstance().getAll();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
