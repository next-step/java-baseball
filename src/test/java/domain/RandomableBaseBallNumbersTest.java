package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomableBaseBallNumbersTest {

    @Test
    @DisplayName("생성된 랜덤어블 숫자야구볼의 사이즈는 항상 3이다.")
    void sizeCheckTest() {
        for(int i = 0; i < 100; i++) {
            BaseBallNumbers baseBallNumbers = new RandomableBaseBallNumbers();
            assertThat(baseBallNumbers.getBaseBallNumbers().length).isEqualTo(3);
        }
    }

    @Test
    @DisplayName("생성된 랜덤어블 숫자야구볼의 값들은 항상 1 ~ 9 사위의 범위이다.")
    void rangeValidateFromBaseBallNumberValue() {
        for(int i = 0; i < 100; i++) {
            BaseBallNumbers baseBallNumbers = new RandomableBaseBallNumbers();
            int first = baseBallNumbers.getBaseBallNumber(0).get();
            int second = baseBallNumbers.getBaseBallNumber(1).get();
            int third = baseBallNumbers.getBaseBallNumber(2).get();
            assertThat(first).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
            assertThat(second).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
            assertThat(third).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
        }
    }

    @Test
    @DisplayName("생성된 랜덤어블 숫쟈야구볼의 값들은 항상 중복되지 않는다.")
    void duplicatedTest() {
        for(int i = 0; i < 100; i++) {
            BaseBallNumbers baseBallNumbers = new RandomableBaseBallNumbers();
            int first = baseBallNumbers.getBaseBallNumber(0).get();
            int second = baseBallNumbers.getBaseBallNumber(1).get();
            int third = baseBallNumbers.getBaseBallNumber(2).get();
            assertThat(first != second).isTrue();
            assertThat(second != third).isTrue();
            assertThat(first != third).isTrue();
        }
    }

}