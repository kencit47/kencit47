package com.spring.springbootone.domain;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.EnumUtils;

import static java.util.Optional.ofNullable;

@UtilityClass
public class Utils {

    public static <E extends Enum<E>, V extends Enum<V>> E fromEnum(final Class<E> enumClass, final V nullableValue) {
        return mapEnum(enumClass, nullableValue);
    }

    private static <V extends Enum<V>, E extends Enum<E>> E mapEnum(final Class<E> enumClass, final V nullableValue) {
        return ofNullable(nullableValue).map(V::name).map(v -> {
            if (!EnumUtils.isValidEnum(enumClass, v)) {
                System.err.println("not found mtf");
            }
            return EnumUtils.getEnum(enumClass, v);
        }).orElse(null);
    }
}
