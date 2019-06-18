package com.itacademy.zenkou.jdb2project.service.config;

import com.itacademy.zenkou.jdb2project.database.config.DatabaseConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.itacademy.zenkou.jdb2project.service.service",
        "com.itacademy.zenkou.jdb2project.service.mapper"})
@Import(DatabaseConfig.class)
@EnableTransactionManagement
public class ServiceConfig {
}