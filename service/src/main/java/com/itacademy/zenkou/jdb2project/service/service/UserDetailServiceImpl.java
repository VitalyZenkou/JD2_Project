package com.itacademy.zenkou.jdb2project.service.service;

import com.itacademy.zenkou.jdb2project.database.repository.UserRepository;
import com.itacademy.zenkou.jdb2project.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String login) {
        return Optional.of(login)
                .map(userRepository::findUserByLogin)
                .filter(Optional::isPresent)
                .map(user -> userMapper.toDTO(user.get()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
