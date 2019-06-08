package com.itacademy.zenkou.jdb2project.test.dao;

import com.itacademy.zenkou.jdb2project.dao.UserDao;
import com.itacademy.zenkou.jdb2project.entity.db.User;
import com.itacademy.zenkou.jdb2project.util.EntityCreatorUtil;
import com.itacademy.zenkou.jdb2project.utils.ConnectionManager;
import lombok.Cleanup;
import org.hibernate.Session;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

public class UserBaseDaoTest {

    private UserDao userDao;
    private Long userId;
    private User user;

    @BeforeClass
    public void setup() {
        userDao = UserDao.getInstance();
    }

    @Test
    public void checkSaveUser() {
        userId = userDao.save(EntityCreatorUtil.getUser());
        Assert.assertNotNull(userId);
    }

    @Test(dependsOnMethods = "checkSaveUser")
    public void checkGetUser() {
        Optional<User> userOptional = userDao.get(userId);
        Assert.assertTrue(userOptional.isPresent());
        user = userOptional.get();
    }

    @Test(dependsOnMethods = "checkGetUser")
    public void checkUpdateUser() {
        String newName = "test";
        user.setName(newName);
        userDao.update(user);
        Optional<User> gotUser = userDao.get(userId);
        String actName = gotUser.isPresent() ? gotUser.get().getName() : "";
        Assert.assertEquals(actName, newName);
    }

    @Test(dependsOnMethods = "checkGetUser", enabled = false)
    public void checkDeleteUser() {
        userDao.delete(user);
        Optional<User> userOptional = userDao.get(userId);
        Assert.assertFalse(userOptional.isPresent());
    }

    @Test(dependsOnMethods = "checkDeleteUser", enabled = false)
    public void checkGetAllUsers() {
        List<User> users = EntityCreatorUtil.getUsers();
        for (User user : users) {
            userDao.save(user);
        }
        List<User> gotUsers = userDao.getAll();
        Assert.assertEquals(users.size(), gotUsers.size());
    }

    @AfterClass
    public void cleanDataBase() {
        @Cleanup Session session = ConnectionManager.getSession();
        session.beginTransaction();
        session.createQuery("delete from User").executeUpdate();
    }
}
