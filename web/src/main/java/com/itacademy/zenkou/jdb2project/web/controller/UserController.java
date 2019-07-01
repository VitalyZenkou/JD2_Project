package com.itacademy.zenkou.jdb2project.web.controller;

import com.itacademy.zenkou.jdb2project.service.dto.UserDto;
import com.itacademy.zenkou.jdb2project.service.filter.dto.UserFilterDto;
import com.itacademy.zenkou.jdb2project.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.itacademy.zenkou.jdb2project.web.util.constant.UrlPath.USER;
import static com.itacademy.zenkou.jdb2project.web.util.constant.WebParameterConstant.USERS;

@Controller
@RequiredArgsConstructor
@RequestMapping("/" + USER)
public class UserController {

    private final UserService userService;

    @GetMapping
    public String getPage(Model model) {
        List<UserDto> users = userService.findAll();
        model.addAttribute(USERS, users);
        return USER;
    }

    @PostMapping
    public String loadUsersByFilter(Model model, UserFilterDto userFilterDto) {
        List<UserDto> users = userService.getUsersByFilter(userFilterDto);
        model.addAttribute(USERS, users);
       return USER;
    }
}
