package com.itacademy.zenkou.jdb2project.dao;

import com.itacademy.zenkou.jdb2project.entity.bd.CreditCard;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditCardDao implements BaseDao<Long, CreditCard> {

    private static final CreditCardDao INSTANCE = new CreditCardDao();

    public static CreditCardDao getInstance() {
        return INSTANCE;
    }
}
