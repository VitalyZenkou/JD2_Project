package com.itacademy.zenkou.jdb2project.service.test.service;

import com.itacademy.zenkou.jdb2project.service.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class UserDetailServiceTest extends BaseTest {

    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    public void loginUserByLoginTest() {
        assertNotNull(userDetailsService.loadUserByUsername("vasia1"));
    }
}
