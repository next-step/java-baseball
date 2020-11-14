package baseball.domain.strategy;

import baseball.exception.IllegalBallNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ThreeBallGenerateStrategyTest {

    private static final int BALL_GENERATOR_RESULT_SIZE = 3;

    @DisplayName("생성된 숫자가 3가지 인치 체크")
    @Test
    public void generate_success() throws Exception {
        //given
        BallGenerateStrategy generator = new ThreeBallGenerateStrategy(new RandomNumberGenerateStrategy());

        //when
        List<Integer> result = generator.generate();

        //then
        Assertions.assertTrue(result.size() == BALL_GENERATOR_RESULT_SIZE);
    }

    @DisplayName("미 중복 랜덤 숫자가 3개가 안나왔을 때")
    @Test
    public void generate_fail() throws Exception {
        //given
        BallGenerateStrategy generator = new ThreeBallGenerateStrategy(() -> 1);

        //then
        assertThatThrownBy(
                () -> generator.generate()
        ).isInstanceOf(IllegalBallNumberException.class)
                .hasMessage("랜덤 숫자 3개가 생성 되어야 합니다.");
    }

}
