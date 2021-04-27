package baseball;

import baseball.BaseballResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BaseballResultTest {

    @DisplayName("스트라이크 상태 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void strikeTest(Integer input) {
        BaseballResult baseballResult = new BaseballResult();
        for (int i=0; i <input; i++){
            baseballResult.isStrike();
        }

        assertFalse(baseballResult.isEndGame());
        assertThat(baseballResult.getStrikeCount()).isEqualTo(input);
        assertThat(baseballResult.getBallCount()).isEqualTo(0);
    }

    @DisplayName("볼 상태 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void ballTest(Integer input) {
        BaseballResult baseballResult = new BaseballResult();
        for (int i=0; i <input; i++){
            baseballResult.isBall();
        }

        assertFalse(baseballResult.isEndGame());
        assertThat(baseballResult.getBallCount()).isEqualTo(input);
        assertThat(baseballResult.getStrikeCount()).isEqualTo(0);
    }

    @DisplayName("1 스트라이크 2 볼 상태 테스트")
    @Test
    void oneStrikeTwoBallTest() {
        BaseballResult baseballResult = new BaseballResult();
        baseballResult.isStrike();
        baseballResult.isBall();
        baseballResult.isBall();

        assertFalse(baseballResult.isEndGame());
        assertThat(baseballResult.getStrikeCount()).isEqualTo(1);
        assertThat(baseballResult.getBallCount()).isEqualTo(2);
    }

    @DisplayName("2 스트라이크 1 볼 상태 테스트")
    @Test
    void twoStrikeOneBallTest() {
        BaseballResult baseballResult = new BaseballResult();
        baseballResult.isStrike();
        baseballResult.isStrike();
        baseballResult.isBall();

        assertFalse(baseballResult.isEndGame());
        assertThat(baseballResult.getStrikeCount()).isEqualTo(2);
        assertThat(baseballResult.getBallCount()).isEqualTo(1);
    }

    @DisplayName("3스트라이크 게임끝 상태 테스트")
    @Test
    void threeStrikeEndGameTest() {
        BaseballResult baseballResult = new BaseballResult();
        baseballResult.isStrike();
        baseballResult.isStrike();
        baseballResult.isStrike();

        assertTrue(baseballResult.isEndGame());
        assertThat(baseballResult.getStrikeCount()).isEqualTo(3);
    }

    @DisplayName("포볼 상태 테스트")
    @Test
    void foulTest() {
        BaseballResult baseballResult = new BaseballResult();

        assertTrue(baseballResult.isNothing());
        assertFalse(baseballResult.isEndGame());
    }

    @DisplayName("초기상태값 테스트")
    @Test
    void initBaseResultTest() {
        BaseballResult baseballResult = new BaseballResult();
        assertFalse(baseballResult.isEndGame());
    }
}
