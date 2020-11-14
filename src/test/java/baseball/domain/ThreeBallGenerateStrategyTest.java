package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ThreeBallGenerateStrategyTest {

    private static final int BALL_GENERATOR_RESULT_SIZE = 3;

    @DisplayName("생성된 숫자가 3가지 인치 체크")
    @Test
    public void generate() throws Exception {
        //given
        BallGenerateStrategy generator = new ThreeBallGenerateStrategy();

        //when
        List<Integer> result = generator.generate();

        //then
        Assertions.assertTrue(result.size() == BALL_GENERATOR_RESULT_SIZE);
    }
}
