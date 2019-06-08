package com.itacademy.zenkou.jdb2project.dao;

import com.itacademy.zenkou.jdb2project.entity.db.Address;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressDao implements BaseDao<Long, Address> {

    private static final AddressDao INSTANCE = new AddressDao();

    public static AddressDao getInstance() {
        return INSTANCE;
    }
}
