package com.itacademy.zenkou.jdb2project.utils;


import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class ConnectionManager {

    @Getter
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public static Session getSession() {
        return factory.openSession();
    }
}