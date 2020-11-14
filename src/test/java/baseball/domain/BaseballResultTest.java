package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("야구게임 결과 테스트")
class BaseballResultTest {

    @DisplayName("스트라이크 입력 테스트")
    @Test
    void getCountOfStrike() {
        BaseballResult baseballResult = new BaseballResult();
        baseballResult.add(ResultType.STRIKE);
        baseballResult.add(ResultType.STRIKE);
        assertThat(baseballResult.getCountOfStrike()).isEqualTo(2);
    }

    @DisplayName("볼 입력 테스트")
    @Test
    void getCountOfBall() {
        BaseballResult baseballResult = new BaseballResult();
        baseballResult.add(ResultType.BALL);
        assertThat(baseballResult.getCountOfBall()).isEqualTo(1);
    }

    @DisplayName("끝났는지 확인(3스트라이크)")
    @Test
    void isEnd() {
        BaseballResult baseballResult = new BaseballResult();
        baseballResult.add(ResultType.STRIKE);
        baseballResult.add(ResultType.STRIKE);
        baseballResult.add(ResultType.STRIKE);
        assertThat(baseballResult.isEnd()).isEqualTo(true);
    }

}
