package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallTest {

    private final BaseBall baseBall = new BaseBall();

    @ParameterizedTest
    @CsvSource({
            "1, 2, 1스트라이크 2볼",
            "2, 0, 2스트라이크",
            "0, 1, 1볼",
            "0, 0, nothing"})
    @DisplayName("힌트 문자열을 반환한다.")
    public void makeHintStrTest(int strike, int ball, String hintStr) {
        String actual = baseBall.makeHindStr(strike, ball);
        assertThat(actual).isEqualTo(hintStr);
    }

    @Test
    @DisplayName("컴퓨터와 유저의 숫자가 같은 경우 true를 반환한다.")
    public void getResultWhenCorrectAnswerTest() {
        List<Integer> computer = List.of(8, 3, 5);
        List<Integer> user = List.of(8, 3, 5);
        boolean result = baseBall.getResult(computer, user);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("컴퓨터와 유저의 숫자가 다른 경우 true를 반환한다.")
    public void getResultWhenNotCorrectAnswerTest() {
        List<Integer> computer = List.of(8, 3, 5);
        List<Integer> user = List.of(3, 7, 5);
        boolean result = baseBall.getResult(computer, user);
        assertThat(result).isFalse();
    }
}
