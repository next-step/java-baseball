package baseball.models;

import baseball.configures.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    AppConfig appConfig = new AppConfig();
    Calculator calculator = appConfig.calculator();

    @Test
    @DisplayName("3 스트라이크 성공 테스트")
    void stirke3Success() {
        String random = "123";
        String input = "123";

        Integer[] strikeAndBall = calculator.calculateStrikesBallsOrNothing(random, input);
        int strike = strikeAndBall[0];
        int ball = strikeAndBall[1];

        Assertions.assertThat(strike).isEqualTo(3);
        Assertions.assertThat(ball).isEqualTo(0);

    }

    @Test
    @DisplayName("3볼 성공 테스트")
    void ball3Success() {
        String random = "123";
        String input = "312";

        Integer[] strikeAndBall = calculator.calculateStrikesBallsOrNothing(random, input);
        int strike = strikeAndBall[0];
        int ball = strikeAndBall[1];

        Assertions.assertThat(strike).isEqualTo(0);
        Assertions.assertThat(ball).isEqualTo(3);
    }

    @Test
    @DisplayName("2 볼 성공 테스트")
    void Ball2Success() {
        String random = "123";
        String input = "251";

        Integer[] strikeAndBall = calculator.calculateStrikesBallsOrNothing(random, input);
        int strike = strikeAndBall[0];
        int ball = strikeAndBall[1];

        Assertions.assertThat(strike).isEqualTo(0);
        Assertions.assertThat(ball).isEqualTo(2);
    }

    @Test
    @DisplayName("1 볼 성공 테스트")
    void Ball1Success() {
        String random = "123";
        String input = "451";

        Integer[] strikeAndBall = calculator.calculateStrikesBallsOrNothing(random, input);
        int strike = strikeAndBall[0];
        int ball = strikeAndBall[1];

        Assertions.assertThat(strike).isEqualTo(0);
        Assertions.assertThat(ball).isEqualTo(1);
    }


    @Test
    @DisplayName("1 스트라이크 2볼 성공 테스트")
    void strike1ball2Success() {
        String random = "123";
        String input = "132";

        Integer[] strikeAndBall = calculator.calculateStrikesBallsOrNothing(random, input);
        int strike = strikeAndBall[0];
        int ball = strikeAndBall[1];

        Assertions.assertThat(strike).isEqualTo(1);
        Assertions.assertThat(ball).isEqualTo(2);
    }

    @Test
    @DisplayName("2 스트라이크 성공 테스트")
    void strike2Ball1Success() {
        String random = "123";
        String input = "124";

        Integer[] strikeAndBall = calculator.calculateStrikesBallsOrNothing(random, input);
        int strike = strikeAndBall[0];
        int ball = strikeAndBall[1];

        Assertions.assertThat(strike).isEqualTo(2);
        Assertions.assertThat(ball).isEqualTo(0);
    }


    @Test
    @DisplayName("낫씽 성공 테스트")
    void nothingSuccess() {
        String random = "123";
        String input = "456";

        Integer[] strikeAndBall = calculator.calculateStrikesBallsOrNothing(random, input);
        int strike = strikeAndBall[0];
        int ball = strikeAndBall[1];

        Assertions.assertThat(strike).isEqualTo(0);
        Assertions.assertThat(ball).isEqualTo(0);
    }
}