package com.itacademy.zenkou.jdb2project.dao;

import com.itacademy.zenkou.jdb2project.entity.db.BankAccount;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BankAccountDao implements BaseDao<Long, BankAccount> {

    private static final BankAccountDao INSTANCE = new BankAccountDao();

    public static BankAccountDao getInstance() {
        return INSTANCE;
    }
}
