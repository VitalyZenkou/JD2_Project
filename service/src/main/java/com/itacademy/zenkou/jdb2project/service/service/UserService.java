package com.itacademy.zenkou.jdb2project.service.service;

import com.google.common.collect.Lists;
import com.itacademy.zenkou.jdb2project.database.entity.db.QUser;
import com.itacademy.zenkou.jdb2project.database.entity.db.User;
import com.itacademy.zenkou.jdb2project.database.repository.UserRepository;
import com.itacademy.zenkou.jdb2project.service.filter.ExpressionBuilder;
import com.itacademy.zenkou.jdb2project.service.filter.dto.UserFilterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public List<User> getUsersByFilter(UserFilterDto userFilterDto) {
        ExpressionBuilder builder = new ExpressionBuilder();
        builder.add(userFilterDto.getName(), QUser.user.name::containsIgnoreCase);
        builder.add(userFilterDto.getSurname(), QUser.user.surname::containsIgnoreCase);
        builder.add(userFilterDto.getBirthDate(), QUser.user.birthDate::after);

        return Lists.newArrayList(userRepository.findAll(builder.getExpression()));
    }
}
