package com.itacademy.zenkou.jdb2project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PhysicalAddressDTO extends BaseDTO {
    private String city;
    private String street;
    private int houseNumber;
    private int flatNumber;
}
