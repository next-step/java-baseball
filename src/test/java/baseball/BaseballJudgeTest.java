package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BaseballJudgeTest {

    @Test
    @DisplayName("strike 와 digit 을 비교하여 정답을 체크하는 메소드 테스트")
    void isRightAnswer() {
        // given
        int digitCount = 5;
        BaseballJudgeMock mock = new BaseballJudgeMock(digitCount, 0, 0, "");

        // when & then
        assertThat(mock.getGameDigitCount()).isEqualTo(digitCount);
        assertThat(mock.isRightAnswer(4)).isFalse();
        assertThat(mock.isRightAnswer(5)).isTrue();
    }

    @Test
    @DisplayName("BaseballJudge 가 생성하는 result 검증")
    void createBaseBallResult() {
        // given
        int digitCount = 6;
        int strikeCount = digitCount;
        int ballCount = 0;
        String judgementMessage = "hi";
        BaseballJudgeMock mock = new BaseballJudgeMock(digitCount, strikeCount, ballCount, judgementMessage);

        // when
        BaseballResult baseballResult = mock.createBaseBallResult(createAny(), createAny());

        // then
        assertThat(baseballResult.isRightAnswer()).isTrue();
        assertThat(baseballResult.getBallCount()).isEqualTo(ballCount);
        assertThat(baseballResult.getStrikeCount()).isEqualTo(strikeCount);
        assertThat(baseballResult.getJudgementMessage()).isEqualTo(judgementMessage);
    }

    <T> List<T> createAny() {
        return new ArrayList<>();
    }

}