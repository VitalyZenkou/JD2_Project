package com.itacademy.zenkou.jdb2project.service.service;

import com.google.common.collect.Lists;
import com.itacademy.zenkou.jdb2project.database.entity.db.QUser;
import com.itacademy.zenkou.jdb2project.database.entity.db.User;
import com.itacademy.zenkou.jdb2project.database.repository.UserRepository;
import com.itacademy.zenkou.jdb2project.service.dto.UserDTO;
import com.itacademy.zenkou.jdb2project.service.filter.ExpressionBuilder;
import com.itacademy.zenkou.jdb2project.service.filter.dto.UserFilterDTO;
import com.itacademy.zenkou.jdb2project.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> findAll() {
        List<UserDTO> usersDto = new ArrayList<>();
        List<User> users = (List<User>) userRepository.findAll();
        users.forEach(user -> usersDto.add(userMapper.toDTO(user)));
        return usersDto;
    }

    public List<UserDTO> getUsersByFilter(UserFilterDTO userFilter) {
        ExpressionBuilder builder = new ExpressionBuilder();
        builder.add(userFilter.getName(), QUser.user.name::containsIgnoreCase);
        builder.add(userFilter.getSurname(), QUser.user.surname::containsIgnoreCase);
        builder.add(userFilter.getBirthDate(), QUser.user.birthDate::after);

        List<User> filteredUsers = Lists.newArrayList(userRepository.findAll(builder.getExpression()));
        List<UserDTO> usersDTO = new ArrayList<>();
        filteredUsers.forEach(user -> usersDTO.add(userMapper.toDTO(user)));
        return usersDTO;
    }
}
