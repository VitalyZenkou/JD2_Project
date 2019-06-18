package com.itacademy.zenkou.jdb2project.service.mapper;

import com.itacademy.zenkou.jdb2project.database.entity.db.Payment;
import com.itacademy.zenkou.jdb2project.service.dto.PaymentDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PaymentMapper extends BaseMapper<Payment, PaymentDTO> {
}
