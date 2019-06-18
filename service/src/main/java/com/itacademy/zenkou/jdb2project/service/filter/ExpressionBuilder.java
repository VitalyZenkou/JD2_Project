package com.itacademy.zenkou.jdb2project.service.filter;

import com.itacademy.zenkou.jdb2project.database.entity.db.BaseEntity;
import com.itacademy.zenkou.jdb2project.service.filter.dto.BaseFilterDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.function.Function;

@RequiredArgsConstructor
public class ExpressionBuilder<T extends BaseEntity> {

    private final JPAQuery<T> query;
    private BooleanExpression expression;

    public <V> void add(V value, Function<V, BooleanExpression> function) {
        if (Objects.nonNull(value) && !isEmptyIfString(value)) {
            expression = Objects.isNull(expression) ? function.apply(value) : expression.and(function.apply(value));
        }
    }

    @SuppressWarnings("unchecked")
    public <E extends EntityPathBase> JPAQuery<T> getPreparedQueryWithLimitOffset(BaseFilterDto filterDTO, E e) {
        query.select(e)
                .from(e)
                .where(expression);
        setLimit(filterDTO);
        setOffset(filterDTO);
        return query;
    }

    private void setLimit(BaseFilterDto filterDTO) {
        long limit = Long.valueOf(filterDTO.getLimit());
        if (limit != 0) {
            query.limit(limit);
        }
    }

    private void setOffset(BaseFilterDto filterDTO) {
        long offset = Long.valueOf(filterDTO.getOffset());
        if (offset != 0) {
            query.offset(offset);
        }
    }

    private <V> boolean isEmptyIfString(V value) {
        return value instanceof String && ((String) value).isEmpty();
    }
}
