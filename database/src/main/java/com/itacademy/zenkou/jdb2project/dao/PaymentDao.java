package com.itacademy.zenkou.jdb2project.dao;

import com.itacademy.zenkou.jdb2project.entity.db.Payment;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentDao implements BaseDao<Long, Payment> {

    private static final PaymentDao INSTANCE = new PaymentDao();

    public static PaymentDao getInstance() {
        return INSTANCE;
    }
}
