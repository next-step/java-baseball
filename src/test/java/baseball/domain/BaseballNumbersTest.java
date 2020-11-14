package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseballNumbersTest {
    private BaseballNumbers baseballNumbers;

    @BeforeEach
    void setUp() {
        baseballNumbers = new BaseballNumbers(Arrays.asList(
                BaseballNumber.of(1, 1),
                BaseballNumber.of(2, 2),
                BaseballNumber.of(3, 3)
        ));
    }

    @Test
    @DisplayName("숫자 입력을 통한 생성")
    void fromInt() {
        BaseballNumbers target = BaseballNumbers.from(123);
        assertThat(baseballNumbers).isEqualTo(target);
        assertThat(baseballNumbers.hashCode()).isEqualTo(target.hashCode());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 11, 1234, 54321})
    @DisplayName("세자리 수가 아닌 경우 예외 발생")
    void exceptFromInt(int number) {
        assertThrows(IllegalArgumentException.class, () -> {
            BaseballNumbers.from(number);
        });
    }

    @Test
    @DisplayName("세자리 수가 아닌 경우 예외 발생")
    void exceptNew() {
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumbers(Arrays.asList(
                BaseballNumber.of(1, 1),
                BaseballNumber.of(2, 2)
        )));
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumbers(Arrays.asList(
                BaseballNumber.of(1, 1),
                BaseballNumber.of(2, 2),
                BaseballNumber.of(3, 4),
                BaseballNumber.of(4, 5)
        )));
    }

    @Test
    @DisplayName("Number 컬렉션 입력을 통한 생성")
    void fromNumbers() {
        List<Number> numbers = Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(3)
        );
        assertThat(BaseballNumbers.from(numbers)).isEqualTo(baseballNumbers);
    }

    @ParameterizedTest
    @CsvSource(value = {"123,STRIKE,STRIKE,STRIKE", "421,NOTHING,STRIKE,BALL", "567,NOTHING,NOTHING,NOTHING"})
    @DisplayName("매칭 테스트")
    void match(int number, String frist, String second, String third) {
        BaseballNumbers target = BaseballNumbers.from(number);
        MatchResult expected = new MatchResult(Arrays.asList(
                State.valueOf(frist),
                State.valueOf(second),
                State.valueOf(third)));
        assertThat(baseballNumbers.match(target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "3,3"})
    @DisplayName("같은 BaseballNumber가 존재하면 Strike")
    void matchStrike(int index, int number) {
        BaseballNumber baseballNumber = BaseballNumber.of(index, number);
        assertThat(baseballNumbers.match(baseballNumber)).isEqualTo(State.STRIKE);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,1", "3,2", "1,3"})
    @DisplayName("Number가 같고 index가 다른 BaseballNumber 가 존재하면 Ball")
    void matchBall(int index, int number) {
        BaseballNumber baseballNumber = BaseballNumber.of(index, number);
        assertThat(baseballNumbers.match(baseballNumber)).isEqualTo(State.BALL);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,5", "2,4", "3,9"})
    @DisplayName("모두 같지 않으면 Nothing")
    void matchNothing(int index, int number) {
        BaseballNumber baseballNumber = BaseballNumber.of(index, number);
        assertThat(baseballNumbers.match(baseballNumber)).isEqualTo(State.NOTHING);
    }
}
