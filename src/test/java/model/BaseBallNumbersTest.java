package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallNumbersTest {

    @DisplayName("중복수가 포함된 숫자열의 검증")
    @Test
    void hasDuplicates() {
        assertThrows(IllegalArgumentException.class, () -> {
            BaseBallNumbers baseBallNumbers = BaseBallNumbers.of(
                    Arrays.asList(BallNumber.of(1),
                            BallNumber.of(1),
                            BallNumber.of(3)
                            )
            );
        });
    }

    @DisplayName("유효하지않은 숫자열 길이 검")
    @Test
    void wrongSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            BaseBallNumbers baseBallNumbers = BaseBallNumbers.of(
                    Arrays.asList(BallNumber.of(1)
                    )
            );
        });
    }

}