package com.itacademy.zenkou.jdb2project.service.service;

import com.itacademy.zenkou.jdb2project.database.entity.db.QUser;
import com.itacademy.zenkou.jdb2project.database.entity.db.User;
import com.itacademy.zenkou.jdb2project.database.repository.UserRepository;
import com.itacademy.zenkou.jdb2project.service.dto.UserDto;
import com.itacademy.zenkou.jdb2project.service.filter.ExpressionBuilder;
import com.itacademy.zenkou.jdb2project.service.filter.dto.UserFilterDto;
import com.itacademy.zenkou.jdb2project.service.mapper.UserMapper;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final EntityManagerFactory entityManagerFactory;

    public List<UserDto> findAll() {
        List<UserDto> usersDto = new ArrayList<>();
        List<User> users = (List<User>) userRepository.findAll();
        users.forEach(user -> usersDto.add(userMapper.toDTO(user)));
        return usersDto;
    }

    public List<UserDto> getUsersByFilter(UserFilterDto userFilter) {
        ExpressionBuilder<User> builder = new ExpressionBuilder<>(new JPAQuery<>(getEntityManager()));
        QUser qUser = QUser.user;

        builder.add(userFilter.getName(), qUser.name::containsIgnoreCase);
        builder.add(userFilter.getSurname(), qUser.surname::containsIgnoreCase);
        builder.add(userFilter.getBirthDate(), qUser.birthDate::after);

        List<User> filteredUsers = userRepository.findAllByFilter(builder.getPreparedQueryWithLimitOffset(userFilter, qUser)
                .orderBy(qUser.id.asc()));
        List<UserDto> usersDTO = new ArrayList<>();
        filteredUsers.forEach(user -> usersDTO.add(userMapper.toDTO(user)));
        return usersDTO;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
