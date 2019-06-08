package com.itacademy.zenkou.jdb2project.database.repository;

import com.itacademy.zenkou.jdb2project.database.entity.db.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>, QuerydslPredicateExecutor<User> {
}

