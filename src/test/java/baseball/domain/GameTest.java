package baseball.domain;

import baseball.domain.fixture.MatchingBalls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GameTest {
    @Test
    @DisplayName("게임이 생성과 동시에 Ball이 생성된다.")
    public void 게임이_생성과_동시에_Ball이_생성된다() {
        AtomicBoolean isGenerateCalled = new AtomicBoolean(false);

        new Game((size) -> {
            isGenerateCalled.set(true);

            List<Ball> balls = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                balls.add(Ball.of(Ball.MINIMUM_NUMBER + i));
            }

            return new Balls(balls);
        });

        assertThat(isGenerateCalled.get())
                .isTrue();
    }

    @Test
    @DisplayName("매칭시 정해진 개수가 아니면 Exception 이 발생한다.")
    public void 매칭시_정해진_개수가_아니면_Exception이_발생한다() {
        Game game = new Game();

        Balls balls = new Balls(
                Ball.of(1), Ball.of(2)
        );

        assertThatIllegalArgumentException().isThrownBy(() -> game.match(balls));
    }

    @ParameterizedTest
    @MethodSource("baseball.domain.fixture.MatchingBalls#createMatchingPackageSource")
    public void 공을_받아_게임결과를_볼_수_있다(MatchingBalls.MatchingPackage matchingPackage) {
        Game game = new Game((size) -> new Balls(Ball.of(7), Ball.of(1), Ball.of(3)));

        Score match = game.match(matchingPackage.getDest());

        assertThat(match.countOfStrike()).isEqualTo(matchingPackage.getCountOfStrike());
        assertThat(match.countOfBall()).isEqualTo(matchingPackage.getCountOfBall());
        assertThat(match.countOfMissing()).isEqualTo(matchingPackage.getCountOfMissing());
    }

}
