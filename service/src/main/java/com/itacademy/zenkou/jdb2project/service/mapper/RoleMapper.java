package com.itacademy.zenkou.jdb2project.service.mapper;

import com.itacademy.zenkou.jdb2project.database.entity.db.Role;
import com.itacademy.zenkou.jdb2project.service.dto.RoleDto;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<Role, RoleDto> {
}
