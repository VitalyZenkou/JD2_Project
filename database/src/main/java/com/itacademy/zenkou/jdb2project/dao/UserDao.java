package com.itacademy.zenkou.jdb2project.dao;


import com.itacademy.zenkou.jdb2project.entity.db.User;
import com.itacademy.zenkou.jdb2project.utils.ConnectionManager;
import com.itacademy.zenkou.jdb2project.utils.filter.UserFilter;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

import static com.itacademy.zenkou.jdb2project.entity.db.QUser.user;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao implements BaseDao<Long, User> {

    private static final UserDao INSTANCE = new UserDao();

    public static UserDao getInstance() {
        return INSTANCE;
    }

    public List<User> getUsersByUserFilter(UserFilter userFilter) {
        @Cleanup Session session = ConnectionManager.getSession();
        JPAQuery<User> query = new JPAQuery<>(session);
        query.select(user).from(user);
        return userFilter.apply(query).fetch();
    }
}
