package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fixtures.FakeBaseballNumbers.FOUR_FIVE_SIX;
import static fixtures.FakeBaseballNumbers.ONE_TWO_FIVE;
import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTests {
    @DisplayName("BaseballNumbersGenerator를 주입 받아 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        MockBaseballNumbersGenerator generator = new MockBaseballNumbersGenerator(1, 2, 3);

        BaseballGame baseballGame = BaseballGame.init(generator);

        assertThat(baseballGame).isNotNull();
        assertThat(generator.isGenerated()).isTrue();
    }

    @DisplayName("게임을 1회 진행하고 결과를 확인할 수 있다.")
    @ParameterizedTest
    @MethodSource("playResources")
    void playTest(BaseballNumbersGenerator generator, BaseballNumbers playerBalls, BaseballResult expectedResult) {
        BaseballGame baseballGame = BaseballGame.init(generator);

        assertThat(baseballGame.play(playerBalls)).isEqualTo(expectedResult);
    }
    public static Stream<Arguments> playResources() {
        return Stream.of(
                Arguments.of(new MockBaseballNumbersGenerator(1, 2, 3), FOUR_FIVE_SIX,
                        BaseballResult.makeFourBall()),
                Arguments.of(new MockBaseballNumbersGenerator(9, 3, 4), ONE_TWO_FIVE,
                        BaseballResult.makeFourBall()),
                Arguments.of(new MockBaseballNumbersGenerator(5, 1, 2), ONE_TWO_FIVE,
                        BaseballResult.of(3, 0)),
                Arguments.of(new MockBaseballNumbersGenerator(5, 1, 7), ONE_TWO_FIVE,
                        BaseballResult.of(2, 0))
        );
    }
}
