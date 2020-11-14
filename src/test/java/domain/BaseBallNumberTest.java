package domain;

import exception.OutOfRangeBBNException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("생성자에 넘긴 수를 저장하고 꺼낸다.")
    void get(int n) {
        BaseBallNumber baseBallNumber = new BaseBallNumber(n);
        assertThat(baseBallNumber.get()).isEqualTo(n);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 11, 12, 13, 19, 100})
    @DisplayName("1~9 범위에 유효하지 않은 수를 입력하려고 할 때 OutOfRangeBBNException 예외를 발생시킨다.")
    void isInRange(int n) {
        assertThrows(OutOfRangeBBNException.class, () -> {
            BaseBallNumber baseBallNumber = new BaseBallNumber(n);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, true",
            "1, 2, false",
            "2, 2, true",
            "3, 4, false",
            "4, 4, true"
    })
    @DisplayName("equals 비교시 생성한 정수필드로 비교됀다.")
    void testEquals(int n, int m, boolean excepted) {
        BaseBallNumber baseBallNumber1 = new BaseBallNumber(n);
        BaseBallNumber baseBallNumber2 = new BaseBallNumber(m);
        assertThat(baseBallNumber1.equals(baseBallNumber2)).isEqualTo(excepted);
    }
}