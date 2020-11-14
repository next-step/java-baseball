package game.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseBallNumbersTest {

    @Test
    @DisplayName("직접 생성 시 0이 존재하면 예외 발생")
    void testHasZeroThrowException() {
        assertThatThrownBy(() -> new BaseBallNumbers("109")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("직접 생성 시 같은 수가 존재하면 예외 발생")
    void testHasSameNumbersThrowException() {
        assertThatThrownBy(() -> new BaseBallNumbers("111")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("직접 생성 시 3자리가 아닐 경우 예외 발생")
    void testOverLengthThrowException() {
        assertThatThrownBy(() -> new BaseBallNumbers("1234")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BaseBallNumbers("15")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("직접 생성 시 숫자가 아닌 값 존재 시 예외")
    void testHasNotNumber() {
        assertThatThrownBy(() -> new BaseBallNumbers("ㅁ09")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("스트라이크 판정")
    void testStrike() {
        // given
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers("123");
        // when
        BaseBallNumber number = BaseBallNumber.of(1);
        // then
        assertThat(baseBallNumbers.getDecisionResult(number, 0)).isEqualTo(Decision.STRIKE);
    }

    @Test
    @DisplayName("볼 판정")
    void testBall() {
        // given
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers("123");
        // when
        BaseBallNumber number = BaseBallNumber.of(1);
        // then
        assertThat(baseBallNumbers.getDecisionResult(number, 1)).isEqualTo(Decision.BALL);
    }

    @Test
    @DisplayName("판정 결과 없음")
    void testNone() {
        // given
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers("123");
        // when
        BaseBallNumber number = BaseBallNumber.of(4);
        // then
        assertThat(baseBallNumbers.getDecisionResult(number, 1)).isEqualTo(Decision.NONE);
    }

    @Test
    @DisplayName("숫자 힌트: 낫싱")
    void testNothing() {
        // given
        BaseBallNumbers computerNumbers = new BaseBallNumbers("123");
        BaseBallNumbers userNumbers = new BaseBallNumbers("456");
        // when
        NumberHint hint = computerNumbers.getHint(userNumbers);
        // then
        assertThat(hint.isNothing()).isTrue();
        assertThat(hint.isThreeStrike()).isFalse();
    }

    @Test
    @DisplayName("숫자 힌트: 1스트라이크 0볼")
    void testOneStrikeAndZeroBall() {
        // given
        BaseBallNumbers computerNumbers = new BaseBallNumbers("123");
        BaseBallNumbers userNumbers = new BaseBallNumbers("156");
        // when
        NumberHint hint = computerNumbers.getHint(userNumbers);
        // then
        assertNumberHint(hint, 1, 0, false);
    }

    @Test
    @DisplayName("숫자 힌트: 3스트라이크 0볼 (정답 발견)")
    void testThreeStrikeAndZeroBall() {
        // given
        BaseBallNumbers computerNumbers = new BaseBallNumbers("123");
        BaseBallNumbers userNumbers = new BaseBallNumbers("123");
        // when
        NumberHint hint = computerNumbers.getHint(userNumbers);
        // then
        assertNumberHint(hint, 3, 0, true);
    }


    @Test
    @DisplayName("숫자 힌트: 1스트라이크 1볼")
    void testOneStrikeAndOneBall() {
        // given
        BaseBallNumbers computerNumbers = new BaseBallNumbers("123");
        BaseBallNumbers userNumbers = new BaseBallNumbers("136");
        // when
        NumberHint hint = computerNumbers.getHint(userNumbers);
        // then
        assertNumberHint(hint, 1, 1, false);
    }

    @Test
    @DisplayName("숫자 힌트: 0스트라이크 3볼")
    void testThreeBall() {
        // given
        BaseBallNumbers computerNumbers = new BaseBallNumbers("123");
        BaseBallNumbers userNumbers = new BaseBallNumbers("312");
        // when
        NumberHint hint = computerNumbers.getHint(userNumbers);
        // then
        assertNumberHint(hint, 0, 3, false);
    }

    private void assertNumberHint(NumberHint hint, int strikeCount, int ballCount, boolean allMatch) {
        assertThat(hint.strikeCount()).isEqualTo(strikeCount);
        assertThat(hint.ballCount()).isEqualTo(ballCount);
        assertThat(hint.isThreeStrike()).isEqualTo(allMatch);
    }

}
