package com.itacademy.zenkou.jdb2project.database.repository;

import com.itacademy.zenkou.jdb2project.database.entity.db.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>, QuerydslPredicateExecutor<User> {

    Optional<User> findUserByLogin(String login);
}

