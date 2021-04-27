import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculationTest {

    @Test
    public void countBall() {
        int[] balls1 = {1, 3, 5};
        int userInput1 = 253;

        int[] balls2 = {1, 3, 5};
        int userInput2 = 351;

        Calculation calculation1 = new Calculation(balls1, userInput1);
        Calculation calculation2 = new Calculation(balls2, userInput2);

        assertThat(calculation1.getBall()).isEqualTo(2);
        assertThat(calculation2.getBall()).isEqualTo(3);
    }

    @Test
    public void countStrike() {
        int[] balls1 = {1, 3, 5};
        int userInput1 = 137;

        int[] balls2 = {2, 7, 9};
        int userInput2 = 279;

        Calculation calculation1 = new Calculation(balls1, userInput1);
        Calculation calculation2 = new Calculation(balls2, userInput2);

        assertThat(calculation1.getStrike()).isEqualTo(2);
        assertThat(calculation2.getStrike()).isEqualTo(3);
    }

    @Test
    public void getResultString() {
        int[] balls = {1, 3, 5};
        int userInput = 153;

        Calculation calculation = new Calculation(balls, userInput);

        assertThat(calculation.getResultString()).isEqualTo("1 스트라이크 2 볼");
    }
}
