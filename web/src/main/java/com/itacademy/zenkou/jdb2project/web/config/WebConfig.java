package com.itacademy.zenkou.jdb2project.web.config;

import com.itacademy.zenkou.jdb2project.service.config.ServiceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.itacademy.zenkou.jdb2project.web")
@Import(ServiceConfig.class)
public class WebConfig {
}
