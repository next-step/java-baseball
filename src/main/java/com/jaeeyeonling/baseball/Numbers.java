package com.jaeeyeonling.baseball;

import static java.util.Objects.isNull;

public final class Numbers {

    static final char MIN_CHAR = '0';
    static final char MAX_CHAR = '9';

    private Numbers() {
    }

    public static boolean isNumber(final String value) {
        if (isNull(value)) {
            return false;
        }
        if (value.isBlank()) {
            return false;
        }

        var isNumber = true;
        for (final var charValue : value.toCharArray()) {
            isNumber &= Numbers.isNumber(charValue);
        }

        return isNumber;
    }

    public static boolean isNumber(final char value) {
        return MIN_CHAR <= value && value <= MAX_CHAR;
    }
}
