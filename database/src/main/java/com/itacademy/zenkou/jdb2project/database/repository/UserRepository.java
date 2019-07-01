package com.itacademy.zenkou.jdb2project.database.repository;

import com.itacademy.zenkou.jdb2project.database.entity.db.User;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>, QuerydslPredicateExecutor<User> {

    Optional<User> findUserByLogin(String login);

    default List<User> findAllByFilter(JPAQuery<User> query) {
        return query.fetch();
    }
}

