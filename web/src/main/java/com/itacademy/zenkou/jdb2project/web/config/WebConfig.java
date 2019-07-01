package com.itacademy.zenkou.jdb2project.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.itacademy.zenkou.jdb2project.web.controller")
@EnableWebMvc
@Import({ThymeleafConfig.class, InternalizationConfig.class})
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**", "/css/**")
                .addResourceLocations("/WEB-INF/resources/", "/WEB-INF/view/css/");
    }
}
