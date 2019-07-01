package com.itacademy.zenkou.jdb2project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto<T extends Serializable> implements MarkerDto {

    private T id;
}
