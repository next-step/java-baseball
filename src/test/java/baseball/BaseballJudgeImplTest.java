package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BaseballJudgeImplTest {

    @Test
    @DisplayName("주입받은 digits 를 정확히 반환하는지 테스트")
    void getGameDigitCount() {
        // given
        int digits = 7;
        BaseballJudgeImpl baseballJudge = new BaseballJudgeImpl(digits);

        // when & then
        assertThat(baseballJudge.getGameDigitCount()).isEqualTo(digits);
    }

    @Test
    @DisplayName("strike 계산 테스트")
    void calculateStrikeCount() {
        // given
        BaseballJudge baseballJudge = new BaseballJudgeImpl(3);
        List<String> answer = Arrays.asList("1", "5", "3");
        List<String> strikeNo = Arrays.asList("9", "8", "7");
        List<String> strike1 = Arrays.asList("5", "4", "3");
        List<String> strike2 = Arrays.asList("1", "4", "3");

        // when & then
        assertThat(baseballJudge.calculateStrikeCount(strikeNo, answer)).isEqualTo(0);
        assertThat(baseballJudge.calculateStrikeCount(strike1, answer)).isEqualTo(1);
        assertThat(baseballJudge.calculateStrikeCount(strike2, answer)).isEqualTo(2);
    }

    @Test
    @DisplayName("ball 계산 테스트")
    void calculateBallCount() {
        // given
        BaseballJudge baseballJudge = new BaseballJudgeImpl(3);
        List<String> answer = Arrays.asList("1", "5", "3");
        List<String> ballNo = Arrays.asList("9", "8", "7");
        List<String> ball1 = Arrays.asList("1", "3", "4");
        List<String> ball2 = Arrays.asList("5", "3", "4");
        List<String> ball3 = Arrays.asList("5", "3", "1");

        // when & then
        assertThat(baseballJudge.calculateBallCount(ballNo, answer)).isEqualTo(0);
        assertThat(baseballJudge.calculateBallCount(ball1, answer)).isEqualTo(1);
        assertThat(baseballJudge.calculateBallCount(ball2, answer)).isEqualTo(2);
        assertThat(baseballJudge.calculateBallCount(ball3, answer)).isEqualTo(3);
    }

    @Test
    @DisplayName("심판 메세지 생성 테스트")
    void createJudgementMessage() {
        // given
        int digits = 3;
        BaseballJudge baseballJudge = new BaseballJudgeImpl(digits);

        // when
        String strike1Ball1 = baseballJudge.createJudgementMessage(1, 1, digits);
        String strike2Ball0 = baseballJudge.createJudgementMessage(2, 0, digits);
        String strike0Ball2 = baseballJudge.createJudgementMessage(0, 2, digits);
        String right = baseballJudge.createJudgementMessage(3, 0, digits);

        // then
        assertThat(strike1Ball1).isEqualTo("1스트라이크 1볼");
        assertThat(strike2Ball0).isEqualTo("2스트라이크");
        assertThat(strike0Ball2).isEqualTo("2볼");
        assertThat(right).isEqualTo(String.format("%s개의 숫자를 모두 맞히셨습니다! 게임 종료", digits));
    }
}