package baseball.domain;

import baseball.domain.strategy.BallGenerateStrategy;
import baseball.domain.strategy.RandomNumberGenerateStrategy;
import baseball.domain.strategy.RandomNumberStrategy;
import baseball.domain.strategy.ThreeBallGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThreeBallTest {

    @DisplayName("게임용 공 정상 생성")
    @Test
    public void constructor_success() throws Exception {
        //given
        RandomNumberStrategy numberStrategy = new RandomNumberGenerateStrategy();
        BallGenerateStrategy ballStrategy = new ThreeBallGenerateStrategy(numberStrategy);

        //when
        new ThreeBall(ballStrategy);
    }

}
