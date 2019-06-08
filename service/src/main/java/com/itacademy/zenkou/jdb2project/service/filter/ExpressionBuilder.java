package com.itacademy.zenkou.jdb2project.service.filter;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.function.Function;

@NoArgsConstructor
public class ExpressionBuilder {

    @Getter
    private BooleanExpression expression;

    public <V> void add(V value, Function<V, BooleanExpression> function) {
        if (Objects.nonNull(value) && !checkIsEmptyIfString(value)) {
            expression = Objects.isNull(expression) ? function.apply(value) : expression.and(function.apply(value));
        }
    }

    private <V> boolean checkIsEmptyIfString(V value) {
        return value instanceof String && ((String) value).isEmpty();
    }
}
