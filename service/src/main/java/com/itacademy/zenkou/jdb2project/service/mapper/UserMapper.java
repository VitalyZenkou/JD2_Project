package com.itacademy.zenkou.jdb2project.service.mapper;

import com.itacademy.zenkou.jdb2project.database.entity.db.User;
import com.itacademy.zenkou.jdb2project.service.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDto> {
}
