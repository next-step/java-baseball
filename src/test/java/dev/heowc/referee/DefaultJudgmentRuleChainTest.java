package dev.heowc.referee;

import dev.heowc.ball.Ball;
import dev.heowc.ball.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("판정 체인에 대해 테스트한다.")
class DefaultJudgmentRuleChainTest {

    private final List<JudgmentRule> strike = Collections.singletonList(new StrikeRule());
    private final List<JudgmentRule> ball = Collections.singletonList(new BallRule());
    private final List<JudgmentRule> strikeAndBall = Arrays.asList(new StrikeRule(), new BallRule());

    @DisplayName("스트라이크를 판정할 수 있다. (그 외는 미스)")
    @ParameterizedTest
    @MethodSource("provideStrikeMethodArguments")
    void strike(Balls balls, Balls otherBalls, Judgment expected) {
        for (int i = 0; i < Balls.SIZE; i++) {
            final JudgmentRuleChain ruleChain = JudgmentRuleChain.ofDefault(strike);
            final Judgment judgment = ruleChain.judge(balls, otherBalls, i);
            assertThat(judgment).isEqualTo(expected);
        }
    }

    private static Stream<? extends Arguments> provideStrikeMethodArguments() {
        return Stream.of(
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Judgment.STRIKE
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Balls.of(Arrays.asList(Ball.valueOf(3), Ball.valueOf(1), Ball.valueOf(2))),
                        Judgment.MISS
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(4), Ball.valueOf(5), Ball.valueOf(6))),
                        Balls.of(Arrays.asList(Ball.valueOf(7), Ball.valueOf(8), Ball.valueOf(9))),
                        Judgment.MISS
                )
        );
    }

    @DisplayName("볼를 판정할 수 있다. (그 외는 미스)")
    @ParameterizedTest
    @MethodSource("provideBallMethodArguments")
    void ball(Balls balls, Balls otherBalls, Judgment expected) {
        for (int i = 0; i < Balls.SIZE; i++) {
            final JudgmentRuleChain ruleChain = JudgmentRuleChain.ofDefault(ball);
            final Judgment judgment = ruleChain.judge(balls, otherBalls, i);
            assertThat(judgment).isEqualTo(expected);
        }
    }

    private static Stream<? extends Arguments> provideBallMethodArguments() {
        return Stream.of(
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Judgment.MISS
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Balls.of(Arrays.asList(Ball.valueOf(3), Ball.valueOf(1), Ball.valueOf(2))),
                        Judgment.BALL
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(4), Ball.valueOf(5), Ball.valueOf(6))),
                        Balls.of(Arrays.asList(Ball.valueOf(7), Ball.valueOf(8), Ball.valueOf(9))),
                        Judgment.MISS
                )
        );
    }

    @DisplayName("스트라이크와 볼을 판정할 수 있다. (그 외는 미스)")
    @ParameterizedTest
    @MethodSource("provideStrikeAndBallMethodArguments")
    void strikeAndBall(Balls balls, Balls otherBalls, Judgment expected) {
        for (int i = 0; i < Balls.SIZE; i++) {
            final JudgmentRuleChain ruleChain = JudgmentRuleChain.ofDefault(strikeAndBall);
            final Judgment judgment = ruleChain.judge(balls, otherBalls, i);
            assertThat(judgment).isEqualTo(expected);
        }
    }

    private static Stream<? extends Arguments> provideStrikeAndBallMethodArguments() {
        return Stream.of(
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Judgment.STRIKE
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Balls.of(Arrays.asList(Ball.valueOf(3), Ball.valueOf(1), Ball.valueOf(2))),
                        Judgment.BALL
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(4), Ball.valueOf(5), Ball.valueOf(6))),
                        Balls.of(Arrays.asList(Ball.valueOf(7), Ball.valueOf(8), Ball.valueOf(9))),
                        Judgment.MISS
                )
        );
    }
}