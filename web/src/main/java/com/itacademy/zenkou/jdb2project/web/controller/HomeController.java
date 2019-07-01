package com.itacademy.zenkou.jdb2project.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.itacademy.zenkou.jdb2project.web.util.constant.UrlPath.HOME;

@Controller
@RequestMapping("/" + HOME)
public class HomeController {

    @GetMapping
    public String showPage() {
        return HOME;
    }
}
