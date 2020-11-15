import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballHintMakerTest {

    @Test
    public void getStrikeHint() {
        ArrayList<Integer> correctNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> inputNumbers = new ArrayList<>(Arrays.asList(1, 2, 5));
        BaseballHintMaker hintMaker = new BaseballHintMaker(correctNumbers, inputNumbers);

        Strike strike = new Strike();
        for (int index = 0; index < hintMaker.NUMBER_SIZE; index++) {
            hintMaker.getStrikeHint(index, strike);
        }
        assertThat(strike.getCount()).isEqualTo(2);
    }

    @Test
    public void getBallHint() {
        ArrayList<Integer> correctNumbers = new ArrayList<>(Arrays.asList(4, 2, 5));
        ArrayList<Integer> inputNumbers = new ArrayList<>(Arrays.asList(4, 5, 2));
        BaseballHintMaker hintMaker = new BaseballHintMaker(correctNumbers, inputNumbers);

        Strike strike = new Strike();
        for (int index = 0; index < hintMaker.NUMBER_SIZE; index++) {
            hintMaker.getStrikeHint(index, strike);
        }
        assertThat(strike.getCount()).isEqualTo(1);

        Ball ball = new Ball();
        for (int index = 0; index < hintMaker.NUMBER_SIZE; index++) {
            hintMaker.getBallHint(index, ball);
        }
        assertThat(ball.getCount()).isEqualTo(2);
    }

}
