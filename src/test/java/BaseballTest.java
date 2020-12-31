import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballTest {

    private final static Baseball baseball = new Baseball();

//    @Test
//    @DisplayName("사용자가 입력한 야구 숫자의 유효성 탐지")

    public void getInputNumber() {
        Assertions.assertThat(Baseball.isValidNumber(Baseball.getInputNumber())).isTrue();
        Assertions.assertThat(Baseball.isValidNumber(Baseball.getInputNumber())).isTrue();
        Assertions.assertThat(Baseball.isValidNumber(Baseball.getInputNumber())).isTrue();
        Assertions.assertThat(Baseball.isValidNumber(Baseball.getInputNumber())).isTrue();
        Assertions.assertThat(Baseball.isValidNumber(Baseball.getInputNumber())).isTrue();
    }


    public void isValidNumber() {
        Assertions.assertThat(Baseball.isValidNumber(123)).isTrue();
        Assertions.assertThat(Baseball.isValidNumber(987)).isTrue();
        Assertions.assertThat(Baseball.isValidNumber(745)).isTrue();
        Assertions.assertThat(Baseball.isValidNumber(543)).isTrue();
        Assertions.assertThat(Baseball.isValidNumber(127)).isTrue();

        Assertions.assertThat(Baseball.isValidNumber(111)).isFalse();
        Assertions.assertThat(Baseball.isValidNumber(12)).isFalse();
        Assertions.assertThat(Baseball.isValidNumber(133)).isFalse();
        Assertions.assertThat(Baseball.isValidNumber(899)).isFalse();
        Assertions.assertThat(Baseball.isValidNumber(-5)).isFalse();
    }


    public void getGameResult() {
        Assertions.assertThat(Baseball.getGameResult(123, 456)).isEqualTo("Nothing");
        Assertions.assertThat(Baseball.getBallCount(123, 234)).isEqualTo("2 ball");
        Assertions.assertThat(Baseball.getBallCount(785, 420)).isEqualTo("Nothing");
        Assertions.assertThat(Baseball.getBallCount(123, 321)).isEqualTo("1 strike 2 ball");
        Assertions.assertThat(Baseball.getBallCount(123, 120)).isEqualTo("2 strike ");
    }


    public void getStrikeCount() {
        Assertions.assertThat(Baseball.getBallCount(123, 456)).isEqualTo(0);
        Assertions.assertThat(Baseball.getBallCount(123, 234)).isEqualTo(0);
        Assertions.assertThat(Baseball.getBallCount(785, 420)).isEqualTo(0);
        Assertions.assertThat(Baseball.getBallCount(123, 321)).isEqualTo(1);
        Assertions.assertThat(Baseball.getBallCount(123, 120)).isEqualTo(2);
    }


    public void getBallCount() {
        Assertions.assertThat(Baseball.getBallCount(123, 456)).isEqualTo(0);
        Assertions.assertThat(Baseball.getBallCount(123, 234)).isEqualTo(2);
        Assertions.assertThat(Baseball.getBallCount(785, 420)).isEqualTo(0);
        Assertions.assertThat(Baseball.getBallCount(123, 321)).isEqualTo(2);
        Assertions.assertThat(Baseball.getBallCount(123, 120)).isEqualTo(0);
    }


    public void generateRandomNumber() {
        Assertions.assertThat(Baseball.isValidNumber(Baseball.generateRandomNumber())).isTrue();
        Assertions.assertThat(Baseball.isValidNumber(Baseball.generateRandomNumber())).isTrue();
        Assertions.assertThat(Baseball.isValidNumber(Baseball.generateRandomNumber())).isTrue();
        Assertions.assertThat(Baseball.isValidNumber(Baseball.generateRandomNumber())).isTrue();
        Assertions.assertThat(Baseball.isValidNumber(Baseball.generateRandomNumber())).isTrue();
    }


//    void askUserContinue() {
//        Assertions.assertThat(Baseball.askUserContinue()).isEqualTo(0);
//    }


    public void isThreeStrike() {
        Assertions.assertThat(Baseball.isThreeStrike("3 strike")).isTrue();
        Assertions.assertThat(Baseball.isThreeStrike("Nothing")).isFalse();
        Assertions.assertThat(Baseball.isThreeStrike("1 strike")).isFalse();
        Assertions.assertThat(Baseball.isThreeStrike("2 strike")).isFalse();
        Assertions.assertThat(Baseball.isThreeStrike("1 strike 2 ball")).isFalse();
    }
}
