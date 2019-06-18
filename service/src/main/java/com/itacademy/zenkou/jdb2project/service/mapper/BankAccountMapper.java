package com.itacademy.zenkou.jdb2project.service.mapper;

import com.itacademy.zenkou.jdb2project.database.entity.db.BankAccount;
import com.itacademy.zenkou.jdb2project.service.dto.BankAccountDto;
import org.mapstruct.Mapper;

@Mapper
public interface BankAccountMapper extends BaseMapper<BankAccount, BankAccountDto> {
}
