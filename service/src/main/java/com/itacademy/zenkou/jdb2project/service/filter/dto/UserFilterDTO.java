package com.itacademy.zenkou.jdb2project.service.filter.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Optional;

public class UserFilterDTO extends BaseFilterDTO {

    private static final int YEAR = 1900;
    private static final int MONTH = 1;
    private static final int DAY = 1;
    @Getter
    private final String name;
    @Getter
    private final String surname;
    private final String birthDate;

    @Builder
    public UserFilterDTO(String limit, String offset, String name, String surname, String birthDate) {
        super(limit, offset);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return Optional.of(birthDate).isPresent() ? (birthDate.isEmpty() ? LocalDate.of(YEAR, MONTH, DAY)
                : LocalDate.parse(birthDate)) : LocalDate.of(YEAR, MONTH, DAY);
    }
}
