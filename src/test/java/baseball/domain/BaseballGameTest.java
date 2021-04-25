package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("야구게임을 테스트한다")
class BaseballGameTest {
    private BaseballGame baseballGame;
    private BaseballResult baseballResult;
    private Map<BaseballEnum, Integer> baseballCounts;

    private void setUp(String randoms, String users) {
        final Numbers randomNumbers = Numbers.valueOf(randoms);
        final Numbers userNumbers = Numbers.valueOf(users);
        baseballGame = new BaseballGame(randomNumbers, userNumbers);
        baseballResult = baseballGame.playOneRound();
        baseballCounts = baseballResult.getBaseballCounts();
    }

    @DisplayName("스트라이크가 3개일 경우를 테스트한다")
    @ParameterizedTest
    @ValueSource(strings = {"123", "523", "496"})
    void strike3(final String value) {
        setUp(value, value);

        assertThat(baseballResult.isNothing()).isFalse();
        assertThat(baseballCounts.get(BaseballEnum.STRIKE)).isEqualTo(3);
        assertThat(baseballCounts.get(BaseballEnum.BALL)).isEqualTo(0);
    }

    @DisplayName("스트라이크가 1개 볼 2개인 경우를 테스트한다")
    @ParameterizedTest
    @CsvSource(value = {"123,132", "523,325", "496,946"})
    void strike1ball2(final String randoms, final String users) {
        setUp(randoms, users);

        assertThat(baseballResult.isNothing()).isFalse();
        assertThat(baseballCounts.get(BaseballEnum.STRIKE)).isEqualTo(1);
        assertThat(baseballCounts.get(BaseballEnum.BALL)).isEqualTo(2);
    }

    @DisplayName("볼 3개인 경우를 테스트한다")
    @ParameterizedTest
    @CsvSource(value = {"123,312", "523,352", "496,649"})
    void ball3(final String randoms, final String users) {
        setUp(randoms, users);

        assertThat(baseballResult.isNothing()).isFalse();
        assertThat(baseballCounts.get(BaseballEnum.STRIKE)).isEqualTo(0);
        assertThat(baseballCounts.get(BaseballEnum.BALL)).isEqualTo(3);
    }

    @DisplayName("낫싱(스트라이크 0개 볼 0개)인 경우를 테스트한다")
    @ParameterizedTest
    @CsvSource(value = {"123,456", "523,189", "496,378"})
    void nothing(final String randoms, final String users) {
        setUp(randoms, users);

        assertThat(baseballResult.isNothing()).isTrue();
        assertThat(baseballCounts.get(BaseballEnum.STRIKE)).isEqualTo(0);
        assertThat(baseballCounts.get(BaseballEnum.BALL)).isEqualTo(0);
    }
}
