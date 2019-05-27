package com.itacademy.zenkou.jdb2project.entity.bd;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "payment", schema = "payment_system_storage")
public class Payment extends BaseEntity<Long> {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_card_id", nullable = false)
    private CreditCard creditCard;

    @Column(name = "cost", nullable = false)
    private BigDecimal bigDecimal;

    @Column(name = "organization", length = 128)
    private String organization;

    @Column(name = "to_credit_card_number", length = 50)
    private String toCreditCardNumber;

    @Column(name = "is_transaction", nullable = false)
    private boolean isTransaction;
}
