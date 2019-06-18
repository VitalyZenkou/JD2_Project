package com.itacademy.zenkou.jdb2project.service.mapper;

import com.itacademy.zenkou.jdb2project.database.entity.db.CreditCard;
import com.itacademy.zenkou.jdb2project.service.dto.CreditCardDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CreditCardMapper extends BaseMapper<CreditCard, CreditCardDTO> {
}
