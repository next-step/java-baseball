package precourse.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseballsTest {

    @DisplayName("두 야구공 세트를 비교하여 스트라이크 개수를 센다.")
    @ParameterizedTest(name = "{0} vs {1}일 떄, 스트라이크 수는 {2}이다.")
    @CsvSource(value = {"123,123,3", "123,124,2", "123,145,1"})
    void countStrike(String answer, String numberAsString, int expectedStrike) {
        BaseballGenerator generator = new BaseballGenerator();
        Baseballs baseballs1 = generator.createBaseballs(answer);
        Baseballs baseballs2 = generator.createBaseballs(numberAsString);

        int strike = baseballs1.countStrike(baseballs2);

        assertThat(strike).isEqualTo(expectedStrike);
    }

    @DisplayName("두 야구공 세트를 비교하여 볼 개수를 센다.")
    @ParameterizedTest(name = "{0} vs {1}일 떄, 볼 개수는 {2}이다.")
    @CsvSource(value = {"123,123,0", "123,142,1", "123,132,2"})
    void countBall(String answer, String numberAsString, int expectedBall) {
        BaseballGenerator generator = new BaseballGenerator();
        Baseballs baseballs1 = generator.createBaseballs(answer);
        Baseballs baseballs2 = generator.createBaseballs(numberAsString);

        int ball = baseballs1.countBall(baseballs2);

        assertThat(ball).isEqualTo(expectedBall);
    }

}