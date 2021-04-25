package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBallGenerationStrategyTest {
    @Test
    @DisplayName("개수를 지정하면 그 숫자만큼 만들어져야 한다")
    public void 개수를_지정하면_그_숫자만큼_만들어져야_한다() {
        RandomBallGenerationStrategy randomBallGenerationStrategy = new RandomBallGenerationStrategy();

        Balls generate = randomBallGenerationStrategy.generate(3);

        assertThat(generate.size())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("공 개수를 최대한으로 계산하여 넣을경우 모든 공이 만들어질것이다.")
    public void 공_개수를_최대한으로_계산하여_넣을경우_모든_공이_만들어질것이다() {
        int maxBallSize = Ball.MAXIMUM_NUMBER - Ball.MINIMUM_NUMBER + 1;

        RandomBallGenerationStrategy randomBallGenerationStrategy = new RandomBallGenerationStrategy();

        Balls generate = randomBallGenerationStrategy.generate(maxBallSize);

        assertThat(generate.size())
                .isEqualTo(maxBallSize);

        for(int i = Ball.MINIMUM_NUMBER; i<=Ball.MAXIMUM_NUMBER; i++) {
            assertThat(generate.findPositionByBall(Ball.of(i)))
                    .isNotEqualTo(Position.NOT_FOUND);
        }
    }
}