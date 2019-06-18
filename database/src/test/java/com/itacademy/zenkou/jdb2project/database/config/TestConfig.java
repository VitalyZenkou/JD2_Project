package com.itacademy.zenkou.jdb2project.database.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.itacademy.zenkou.jdb2project.database.util"})
@Import(DatabaseConfig.class)
public class TestConfig {
}
