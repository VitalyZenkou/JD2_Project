package com.itacademy.zenkou.jdb2project.service.dto;

import com.itacademy.zenkou.jdb2project.database.entity.db.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AddressDTO extends BaseDTO {
    private User user;
    private String phoneNumber;
    private String email;
    private PhysicalAddressDTO physicalAddress;
}
