package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @DisplayName("중복수가 포함된 숫자열의 검증")
    @Test
    void hasDuplicates() {
        assertThrows(IllegalArgumentException.class, () -> {
            Numbers numbers = Numbers.of(
                    Arrays.asList(Number.of(1),
                            Number.of(1),
                            Number.of(3)
                            )
            );
        });
    }

    @DisplayName("유효하지않은 숫자열 길이 검")
    @Test
    void wrongSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            Numbers numbers = Numbers.of(
                    Arrays.asList(Number.of(1)
                    )
            );
        });
    }

}