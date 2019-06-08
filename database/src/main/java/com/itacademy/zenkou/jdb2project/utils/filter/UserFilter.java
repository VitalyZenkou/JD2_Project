package com.itacademy.zenkou.jdb2project.utils.filter;

import com.itacademy.zenkou.jdb2project.entity.db.User;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.Builder;

import java.time.LocalDate;

import static com.itacademy.zenkou.jdb2project.entity.db.QUser.user;

@Builder(toBuilder = true)
public class UserFilter {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private int limit;
    private int offset;

    public JPAQuery<User> apply(JPAQuery<User> query) {
        return new UserQueryBuilder().buildQuery(query);
    }

    private class UserQueryBuilder {
        private JPAQuery<User> buildQuery(JPAQuery<User> query) {
            if (!name.isEmpty()) {
                query.where(user.name.eq(name));
            }
            if (!surname.isEmpty()) {
                query.where(user.surname.eq(surname));
            }
            if (birthDate != null) {
                query.where(user.birthDate.after(birthDate));
            }
            if (limit != 0) {
                query.limit(limit);
            }
            if (offset != 0) {
                query.offset(offset);
            }
            return query;
        }
    }
}
