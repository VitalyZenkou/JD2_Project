package com.itacademy.zenkou.jdb2project.service.filter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class BaseFilterDto {

    private final String limit;
    private final String offset;
}

