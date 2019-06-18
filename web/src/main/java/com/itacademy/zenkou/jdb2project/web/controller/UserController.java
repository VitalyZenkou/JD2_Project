package com.itacademy.zenkou.jdb2project.web.controller;

import com.itacademy.zenkou.jdb2project.service.dto.UserDTO;
import com.itacademy.zenkou.jdb2project.service.filter.dto.UserFilterDTO;
import com.itacademy.zenkou.jdb2project.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.itacademy.zenkou.jdb2project.web.util.constant.UrlPath.USER;
import static com.itacademy.zenkou.jdb2project.web.util.constant.WebParameterConstant.USERS;

@Controller
@RequestMapping("/" + USER)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getPage(Model model) {
        List<UserDTO> users = userService.findAll();
        model.addAttribute(USERS, users);
        return USER;
    }

    @PostMapping
    public String loadUsersByFilter(Model model, UserFilterDTO userFilterDto) {
        List<UserDTO> users = userService.getUsersByFilter(userFilterDto);
        model.addAttribute(USERS, users);
        return USER;
    }
}
