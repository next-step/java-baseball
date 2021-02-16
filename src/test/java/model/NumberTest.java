package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @DisplayName("숫자 범위 유효성 테스")
    @Test
    void illegalNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            Number number = Number.of(-1);
        });
    }
}