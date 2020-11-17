package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameHintTest {

    @Test
    @DisplayName("정답과 입력받은 숫자의 자리 수와 값이 일치할 경우 스트라이크 힌트 출력하기")
    public void getStrikeHint() {
        ArrayList<Integer> correctNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> inputNumbers = new ArrayList<>(Arrays.asList(1, 2, 5));
        BaseballGameHint hint = new BaseballGameHint(correctNumbers, inputNumbers);

        Strike strike = new Strike();
        for (int index = 0; index < hint.NUMBER_SIZE; index++) {
            hint.setStrike(index, strike);
        }
        assertThat(strike.getCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("입력받은 숫자가 정답을 포함하면 볼 힌트 출력하기 (스트라이크 숫자 제외)")
    public void getBallHint() {
        ArrayList<Integer> correctNumbers = new ArrayList<>(Arrays.asList(4, 2, 5));
        ArrayList<Integer> inputNumbers = new ArrayList<>(Arrays.asList(4, 5, 2));
        BaseballGameHint hint = new BaseballGameHint(correctNumbers, inputNumbers);

        Strike strike = new Strike();
        for (int index = 0; index < hint.NUMBER_SIZE; index++) {
            hint.setStrike(index, strike);
        }
        assertThat(strike.getCount()).isEqualTo(1);

        Ball ball = new Ball();
        for (int index = 0; index < hint.NUMBER_SIZE; index++) {
            hint.setBall(index, ball);
        }
        assertThat(ball.getCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("입력받은 숫자가 정답을 포함하지 않은면 포볼 혹은 낫싱 힌트 출력하기 (스트라이크, 볼 숫자 제외)")
    public void getNothingHint() {
        ArrayList<Integer> correctNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> inputNumbers = new ArrayList<>(Arrays.asList(4, 5, 6));
        BaseballGameHint hint = new BaseballGameHint(correctNumbers, inputNumbers);

        Strike strike = new Strike();
        for (int index = 0; index < hint.NUMBER_SIZE; index++) {
            hint.setStrike(index, strike);
        }
        hint.setStrike(strike);
        assertThat(strike.getCount()).isEqualTo(0);

        Ball ball = new Ball();
        for (int index = 0; index < hint.NUMBER_SIZE; index++) {
            hint.setBall(index, ball);
        }
        hint.setBall(ball);
        assertThat(ball.getCount()).isEqualTo(0);

        Nothing nothing = new Nothing();
        if (strike.getCount() == 0 && ball.getCount() == 0) {
            hint.setNothing(nothing);
        }

    }

}
