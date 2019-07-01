package com.itacademy.zenkou.jdb2project.service.dto;

import com.itacademy.zenkou.jdb2project.database.entity.db.CreditCard;
import com.itacademy.zenkou.jdb2project.database.entity.db.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PaymentDto extends BaseDto<Long> {

    private User user;
    private CreditCard creditCard;
    private BigDecimal bigDecimal;
    private String organization;
    private String toCreditCardNumber;
    private boolean isTransaction;
}
