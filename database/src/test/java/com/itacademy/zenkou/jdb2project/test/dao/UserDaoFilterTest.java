package com.itacademy.zenkou.jdb2project.test.dao;

import com.itacademy.zenkou.jdb2project.dao.UserDao;
import com.itacademy.zenkou.jdb2project.entity.db.User;
import com.itacademy.zenkou.jdb2project.util.EntityCreatorUtil;
import com.itacademy.zenkou.jdb2project.utils.ConnectionManager;
import com.itacademy.zenkou.jdb2project.utils.filter.UserFilter;
import lombok.Cleanup;
import org.hibernate.Session;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

public class UserDaoFilterTest {

    private UserFilter userFilter;
    private UserDao userDao;

    @BeforeClass
    public void setup() {
        userFilter = UserFilter.builder()
                .name("Vasia")
                .surname("")
                .birthDate(LocalDate.of(1987, 1, 1))
                .build();

        userDao = UserDao.getInstance();
    }

    @Test
    public void testUserDaoWithFilter() {
        int limit = 2;
        List<User> users = EntityCreatorUtil.getTheSameUsers();
        for (User user : users) {
            userDao.save(user);
        }
        List<User> gotUsers = userDao.getUsersByUserFilter(userFilter);
        Assert.assertEquals(gotUsers.size(), 3);

        userFilter = userFilter.toBuilder().limit(limit).build();
        List<User> gotUsersWithLimit = userDao.getUsersByUserFilter(userFilter);
        Assert.assertEquals(gotUsersWithLimit.size(), limit);

        userFilter = userFilter.toBuilder().limit(limit).offset(2).build();
        List<User> gotUsersWithLimitOffset = userDao.getUsersByUserFilter(userFilter);
        Assert.assertEquals(gotUsersWithLimitOffset.size(), 1);
        Assert.assertEquals(gotUsersWithLimitOffset.get(0).getLogin(), "vasia4");
    }

    @AfterClass
    public void cleanDataBase() {
        @Cleanup Session session = ConnectionManager.getSession();
        session.beginTransaction();
        session.createQuery("delete from User").executeUpdate();
    }
}
