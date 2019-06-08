package com.itacademy.zenkou.jdb2project.service.test;

import com.itacademy.zenkou.jdb2project.service.config.TestConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = TestConfig.class)
@Transactional
@Sql("classpath:prepareDataForTest.sql")
public class BaseTest extends AbstractTestNGSpringContextTests {
}
