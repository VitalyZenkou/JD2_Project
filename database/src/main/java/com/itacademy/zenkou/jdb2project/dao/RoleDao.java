package com.itacademy.zenkou.jdb2project.dao;

import com.itacademy.zenkou.jdb2project.entity.bd.Role;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleDao implements BaseDao<Long, Role> {

    private static final RoleDao INSTANCE = new RoleDao();

    public static RoleDao getInstance() {
        return INSTANCE;
    }
}
