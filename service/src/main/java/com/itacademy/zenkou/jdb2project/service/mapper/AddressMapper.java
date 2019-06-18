package com.itacademy.zenkou.jdb2project.service.mapper;

import com.itacademy.zenkou.jdb2project.database.entity.db.Address;
import com.itacademy.zenkou.jdb2project.service.dto.AddressDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {PhysicalAddressMapper.class})
public interface AddressMapper extends BaseMapper<Address, AddressDTO> {
}
