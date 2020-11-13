package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.domain.BaseballNumber.MAX_INDEX;
import static baseball.domain.BaseballNumber.MIN_INDEX;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseballNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,9", "3,5"})
    @DisplayName("BaseballNumber 는 1~3 사이의 index 와 Number 로 생성")
    void create(int index, int number) {
        assertThat(BaseballNumber.of(index, number)).isEqualTo(new BaseballNumber(index, new Number(number)));
    }

    @ParameterizedTest
    @ValueSource(ints = {MIN_INDEX - 1, 0, MAX_INDEX + 1})
    @DisplayName("index 가 1 ~ 3 사이가 아닐 경우 인덱스 예외 발생")
    void indexException(int index) {
        assertThrows(IllegalArgumentException.class, () -> {
            BaseballNumber.of(index, 1);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"2,5"})
    @DisplayName("index & number 가 같을 경우 Strike")
    void matchStrike(int index, int number) {
        BaseballNumber target = BaseballNumber.of(index, number);
        assertThat(target.match(BaseballNumber.of(index, number))).isEqualTo(State.STRIKE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,5", "3,5"})
    @DisplayName("index 가 다르고 number 가 같을 경우 Ball")
    void matchBall(int index, int number) {
        BaseballNumber target = BaseballNumber.of(2, 5);
        assertThat(target.match(BaseballNumber.of(index, number))).isEqualTo(State.BALL);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,9", "3,4"})
    @DisplayName("index & number 모두 다를 경우 Noting")
    void matchNothing(int index, int number) {
        BaseballNumber target = BaseballNumber.of(2, 5);
        assertThat(target.match(BaseballNumber.of(index, number))).isEqualTo(State.NOTING);
    }
}
