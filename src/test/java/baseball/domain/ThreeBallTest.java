package baseball.domain;

import baseball.domain.strategy.BallGenerateStrategy;
import baseball.domain.strategy.RandomNumberGenerateStrategy;
import baseball.domain.strategy.RandomNumberStrategy;
import baseball.domain.strategy.ThreeBallGenerateStrategy;
import baseball.exception.BallException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("공 생성 전략 - 주입 테스트")
    @Test
    public void strategy_fail() throws Exception {
        //then
        assertThatThrownBy(
                () -> new ThreeBall(null)
        ).isInstanceOf(BallException.class)
                .hasMessage("공 생성에 실패 하였습니다.");
    }

}
