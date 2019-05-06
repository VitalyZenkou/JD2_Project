package com.it_academy.zenkou.jdb2project.utils;

import com.it_academy.zenkou.jdb2project.exception.DriverException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConnectionManager {

    private static final String URL = PropertiesUtil.get("db.url");
    private static final String USER = PropertiesUtil.get("db.username");
    private static final String PASSWORD = PropertiesUtil.get("db.password");

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new DriverException("Can't found postgresql driver class");
        }
    }

    @SneakyThrows
    public static Connection get() {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}