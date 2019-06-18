package com.itacademy.zenkou.jdb2project.database.test;

import com.itacademy.zenkou.jdb2project.database.config.TestConfig;
import com.itacademy.zenkou.jdb2project.database.util.DatabaseHelper;
import com.itacademy.zenkou.jdb2project.database.util.EntityCreatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;

@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected EntityManagerFactory managerFactory;

    @Autowired
    protected EntityCreatorUtil creatorUtil;

    @Autowired
    protected DatabaseHelper databaseHelper;
}
