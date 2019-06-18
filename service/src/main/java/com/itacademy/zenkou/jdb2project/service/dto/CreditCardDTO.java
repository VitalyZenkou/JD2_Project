package com.itacademy.zenkou.jdb2project.service.dto;

import com.itacademy.zenkou.jdb2project.database.entity.CreditCardType;
import com.itacademy.zenkou.jdb2project.database.entity.db.BankAccount;
import com.itacademy.zenkou.jdb2project.database.entity.db.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreditCardDTO extends BaseDTO {

    private BankAccount bankAccount;
    private String number;
    private String validityDate;
    private int pinCode;
    private int cvv;
    private boolean isBlocked;
    private CreditCardType creditCardType;
    private List<Payment> payments;
}
