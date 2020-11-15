import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

    @Test
    public void setCorrectNumbers() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.setCorrectNumbers();
        assertThat(baseballGame.getCorrectNumbers()).doesNotHaveDuplicates();
    }

    @Test
    public void setInputNumbers() {
        BaseballGame baseballGame = new BaseballGame();
        String inputNumberString = "123";
        baseballGame.setInputNumbers(inputNumberString);
        assertThat(baseballGame.getInputNumbers()).contains(1, 2, 3);
        assertThat(baseballGame.getInputNumbers()).containsExactly(1, 2, 3);
    }

    @Test
    public void strike_Hint() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.setCorrectNumbers(new ArrayList<>(Arrays.asList(4, 5, 6)));
        String inputNumberString = "456";
        baseballGame.setInputNumbers(inputNumberString);
        baseballGame.setHint();
        assertThat(baseballGame.getHint().getStrike().getCount()).isEqualTo(3);
        baseballGame.printHint();
    }

    @Test
    public void ball_Hint() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.setCorrectNumbers(new ArrayList<>(Arrays.asList(4, 5, 6)));
        String inputNumberString = "645";
        baseballGame.setInputNumbers(inputNumberString);
        baseballGame.setHint();
        assertThat(baseballGame.getHint().getBall().getCount()).isEqualTo(3);
        baseballGame.printHint();
    }

    @Test
    public void strike_And_Ball_Hint() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.setCorrectNumbers(new ArrayList<>(Arrays.asList(4, 5, 6)));
        String inputNumberString = "465";
        baseballGame.setInputNumbers(inputNumberString);
        baseballGame.setHint();
        assertThat(baseballGame.getHint().getStrike().getCount()).isEqualTo(1);
        assertThat(baseballGame.getHint().getBall().getCount()).isEqualTo(2);
        baseballGame.printHint();
    }

    @Test
    public void nothing_Hint() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.setCorrectNumbers(new ArrayList<>(Arrays.asList(4, 5, 6)));
        String inputNumberString = "123";
        baseballGame.setInputNumbers(inputNumberString);
        baseballGame.setHint();
        assertThat(baseballGame.getHint().getNothing().getCount()).isEqualTo(1);
        baseballGame.printHint();
    }

}
