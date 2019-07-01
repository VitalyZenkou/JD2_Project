package com.itacademy.zenkou.jdb2project.service.mapper;

import com.itacademy.zenkou.jdb2project.database.entity.db.BaseEntity;
import com.itacademy.zenkou.jdb2project.service.dto.MarkerDto;

public interface BaseMapper<T extends BaseEntity, E extends MarkerDto> {

    E toDTO(T t);

    T fromDTO(E e);
}
