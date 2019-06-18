package com.itacademy.zenkou.jdb2project.service.mapper;

import com.itacademy.zenkou.jdb2project.database.entity.db.BaseEntity;
import com.itacademy.zenkou.jdb2project.service.dto.BaseDTO;

public interface BaseMapper<T extends BaseEntity, E extends BaseDTO> {

    E toDTO(T t);

    T fromDTO(E e);
}
