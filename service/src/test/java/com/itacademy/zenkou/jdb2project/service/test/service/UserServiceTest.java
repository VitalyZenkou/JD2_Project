package com.itacademy.zenkou.jdb2project.service.test.service;

import com.itacademy.zenkou.jdb2project.service.dto.UserDTO;
import com.itacademy.zenkou.jdb2project.service.filter.dto.UserFilterDTO;
import com.itacademy.zenkou.jdb2project.service.service.UserService;
import com.itacademy.zenkou.jdb2project.service.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {
        UserFilterDTO userFilterDto = UserFilterDTO.builder()
                .birthDate("")
                .name("petia")
                .build();
        List<UserDTO> users = userService.getUsersByFilter(userFilterDto);
        assertThat(users, hasSize(5));
    }
}
