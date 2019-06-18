package com.itacademy.zenkou.jdb2project.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.itacademy.zenkou.jdb2project.web.controller")
@EnableWebMvc
@Import({ThymeleafConfig.class, InternalizationConfig.class})
public class WebConfig {
}
