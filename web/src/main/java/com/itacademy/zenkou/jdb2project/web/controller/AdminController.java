package com.itacademy.zenkou.jdb2project.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.itacademy.zenkou.jdb2project.web.util.constant.UrlPath.ADMIN;

@Controller
@RequestMapping("/" + ADMIN)
public class AdminController {

    @GetMapping
    public String showPage() {
        return ADMIN;
    }
}
