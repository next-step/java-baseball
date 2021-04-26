package dev.heowc.referee;

import dev.heowc.ball.Ball;
import dev.heowc.ball.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("스트라이크 판정에 대해 테스트한다.")
class StrikeRuleTest {

    private final JudgmentRuleChain stubRuleChain = (my, other, index) -> Judgment.MISS;
    private final JudgmentRule strikeRule = new StrikeRule();

    @DisplayName("동일한 위치에 동일한 볼이 존재할 경우 스트라이크로 판정한다.")
    @ParameterizedTest
    @MethodSource("provideStrikeMethodArguments")
    void strike(List<Ball> ballList) {
        final Balls balls = Balls.of(ballList);
        final Balls otherBalls = Balls.of(ballList);

        for (int i = 0; i < Balls.SIZE; i++) {
            final Judgment judgment = strikeRule.doJudge(balls, otherBalls, i, stubRuleChain);
            assertThat(judgment).isEqualTo(Judgment.STRIKE);
        }
    }

    private static Stream<? extends Arguments> provideStrikeMethodArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                Arguments.of(Arrays.asList(Ball.valueOf(5), Ball.valueOf(6), Ball.valueOf(7))),
                Arguments.of(Arrays.asList(Ball.valueOf(8), Ball.valueOf(5), Ball.valueOf(2)))
        );
    }

    @DisplayName("동일한 위치에 동일한 볼이 존재하지 않을 경우 스트라이크로 판정하지 않는다.")
    @ParameterizedTest
    @MethodSource("provideNotStrikeMethodArguments")
    void notStrike(Balls balls, Balls otherBalls) {
        for (int i = 0; i < Balls.SIZE; i++) {
            final Judgment judgment = strikeRule.doJudge(balls, otherBalls, i, (my, other, index) -> Judgment.MISS);
            assertThat(judgment).isNotEqualTo(Judgment.STRIKE);
        }
    }

    private static Stream<? extends Arguments> provideNotStrikeMethodArguments() {
        return Stream.of(
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Balls.of(Arrays.asList(Ball.valueOf(4), Ball.valueOf(5), Ball.valueOf(6)))
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(4), Ball.valueOf(5), Ball.valueOf(6))),
                        Balls.of(Arrays.asList(Ball.valueOf(7), Ball.valueOf(8), Ball.valueOf(9)))
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(4))),
                        Balls.of(Arrays.asList(Ball.valueOf(7), Ball.valueOf(8), Ball.valueOf(9)))
                )
        );
    }
}
