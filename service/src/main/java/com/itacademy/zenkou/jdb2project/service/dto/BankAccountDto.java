package com.itacademy.zenkou.jdb2project.service.dto;

import com.itacademy.zenkou.jdb2project.database.entity.Currency;
import com.itacademy.zenkou.jdb2project.database.entity.db.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BankAccountDto extends BaseDto<Long> {

    private User user;
    private BigDecimal balance;
    private boolean isBlocked;
    private Currency currency;
    private List<CreditCardDto> creditCards;
}
