package baseball;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로직 테스트")
public class BaseballGameTest {
    private BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        this.baseballGame = new BaseballGame();
    }

    @ParameterizedTest
    @DisplayName("플레이어가 입력한 숫자 검증 - 정상 입력한 경우")
    @ValueSource(ints = {123, 692})
    void validNumberPassTest(int number) {
        assertThat(baseballGame.confirmNumber(number));
    }

    @ParameterizedTest
    @DisplayName("플레이어가 입력한 숫자 검증 - 잘못 입력한 경우")
    @ValueSource(ints = {444, 2512, 5})
    void validNumberFailTest(int number) {
        assertThat(baseballGame.confirmNumber(number).isEmpty())
                .isTrue();
    }

    @Test
    @DisplayName("볼 카운트 테스트")
    void ballCount() {
        assertThat(baseballGame.checkNumbers(new BaseballNumbers(123), new BaseballNumbers(132)))
                .extracting(BaseballResult::getStrike, BaseballResult::getBall).containsExactly(1, 2);
        assertThat(baseballGame.checkNumbers(new BaseballNumbers(576), new BaseballNumbers(576)))
                .extracting(BaseballResult::getStrike, BaseballResult::getBall).containsExactly(3, 0);
        assertThat(baseballGame.checkNumbers(new BaseballNumbers(194), new BaseballNumbers(419)))
                .extracting(BaseballResult::getStrike, BaseballResult::getBall).containsExactly(0, 3);
        assertThat(baseballGame.checkNumbers(new BaseballNumbers(456), new BaseballNumbers(789)))
                .extracting(BaseballResult::getStrike, BaseballResult::getBall).containsExactly(0, 0);
    }
}
