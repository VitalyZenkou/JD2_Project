package com.itacademy.zenkou.jdb2project.service.filter.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

public class UserFilterDto extends BaseFilterDto {

    private static final int YEAR = 1900;
    private static final int MONTH = 1;
    private static final int DAY = 1;
    @Getter
    private String name;
    @Getter
    private String surname;
    private String birthDate;

    @Builder
    public UserFilterDto(String limit, String offset, String name, String surname, String birthDate) {
        super(limit, offset);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate.isEmpty() ? LocalDate.of(YEAR, MONTH, DAY)
                : LocalDate.parse(birthDate);
    }
}
