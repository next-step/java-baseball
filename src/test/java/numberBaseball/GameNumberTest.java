package numberBaseball;

import numberBaseball.exception.ContainsDuplicationException;
import numberBaseball.exception.ContainsZeroException;
import numberBaseball.GameNumber;
import numberBaseball.exception.NotThreeDigitException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.discovery.SelectorResolver;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class GameNumberTest {
    @Test
    @DisplayName("랜덤으로 생성된 숫자가 예외를 발생시키지 않는다.")
    void checkRandomGenerateTest() throws ContainsZeroException {
        GameNumber.randomGenerate();
    }

    @Test
    @DisplayName("0이 포함되면 ContainsZeroException을 출력한다.")
    void ofContainsZeroTest() {
        //given
        Integer[] inputContainsZero = new Integer[]{0, 1, 2};

        assertThatThrownBy(() -> {
            // when
            GameNumber.of(Arrays.asList(inputContainsZero)); })
                // then
                .isInstanceOf(ContainsZeroException.class)
                .hasMessageContaining("숫자에 0을 포함해서는 안됩니다.");
    }

    @Test
    @DisplayName("서로 다른 수가 아닌 값을 입력하였을 때 예외를 출력한다.")
    void ofDuplicationTest() {
        //given
        Integer[] inputDuplication = new Integer[]{1, 1, 2};

        assertThatThrownBy(() -> {
            // when
            GameNumber.of(Arrays.asList(inputDuplication)); })
                // then
                .isInstanceOf(ContainsDuplicationException.class)
                .hasMessageContaining("숫자가 중복되어서는 안됩니다.");
    }

    @Test
    @DisplayName("세 자리 수가 아닌 값을 입력하였을 때 예외를 출력한다.")
    void ofSizeTest() {
        //given
        Integer[] inputTwoNumbers = new Integer[]{1, 2};
        assertThatThrownBy(() -> {
            // when
            GameNumber.of(Arrays.asList(inputTwoNumbers)); })
            // then
                .isInstanceOf(NotThreeDigitException.class)
                .hasMessageContaining("세 자리 수만 입력할 수 있습니다");
    }

    @Test
    @DisplayName("스트라이크와 볼의 개수를 구하라")
    void computeMatchResult() {
        // given
        GameNumber gameNumber1 =  GameNumber.of(Arrays.asList(1, 2, 3));
        GameNumber gameNumber2 =  GameNumber.of(Arrays.asList(1, 4, 2));
        // when
        MatchResult matchResult = gameNumber1.computeMatchResult(gameNumber2);
        // then
        assertThat(matchResult.getStrikes()).isEqualTo(1);
        assertThat(matchResult.getBalls()).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크와 볼의 개수를 구하라")
    void computeMatchResult2() {
        // given
        GameNumber gameNumber1 =  GameNumber.of(Arrays.asList(1, 2, 3));
        GameNumber gameNumber2 =  GameNumber.of(Arrays.asList(3, 1, 2));
        // when
        MatchResult matchResult = gameNumber1.computeMatchResult(gameNumber2);
        // then
        assertThat(matchResult.getStrikes()).isEqualTo(0);
        assertThat(matchResult.getBalls()).isEqualTo(3);
    }
}