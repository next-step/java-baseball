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

@DisplayName("심판에 대해 테스트한다.")
class RefereeTest {

    private final List<JudgmentRule> judgmentRules = Arrays.asList(new StrikeRule(), new BallRule());

    @DisplayName("볼들을 비교한 결과에 대한 리포트를 가져올 수 있다.")
    @ParameterizedTest
    @MethodSource("provideJudgeMethodArguments")
    void judge(Balls balls, Balls otherBalls, boolean isCompleted) {
        final Referee referee = new Referee(judgmentRules);
        final JudgmentReport report = referee.judge(balls, otherBalls);
        assertThat(report.isCompleted()).isEqualTo(isCompleted);
    }

    private static Stream<? extends Arguments> provideJudgeMethodArguments() {
        return Stream.of(
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        true
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Balls.of(Arrays.asList(Ball.valueOf(3), Ball.valueOf(1), Ball.valueOf(2))),
                        false
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(4), Ball.valueOf(5), Ball.valueOf(6))),
                        Balls.of(Arrays.asList(Ball.valueOf(7), Ball.valueOf(8), Ball.valueOf(9))),
                        false
                )
        );
    }
}
