package com.itacademy.zenkou.jdb2project.service.dto;

import com.itacademy.zenkou.jdb2project.database.entity.Currency;
import com.itacademy.zenkou.jdb2project.database.entity.db.CreditCard;
import com.itacademy.zenkou.jdb2project.database.entity.db.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BankAccountDTO extends BaseDTO {

    private User user;
    private BigDecimal balance;
    private boolean isBlocked;
    private Currency currency;
    private List<CreditCard> creditCards;
}
