//import org.junit.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballTest {


    Baseball baseball = new Baseball();

//    @Test
//    @DisplayName("랜덤 숫자 유효성 테스트")
//    void getInputNumber() {
////        assertEquals(78, 78);
////        Assertions.assertTrue(baseball.isValidNumber(baseball.getInputNumber()));
//        Assertions.assertThat(baseball.isValidNumber(baseball.getInputNumber())).isTrue();
//        Assertions.assertThat(baseball.isValidNumber(baseball.getInputNumber())).isTrue();
//        Assertions.assertThat(baseball.isValidNumber(baseball.getInputNumber())).isTrue();
//        Assertions.assertThat(baseball.isValidNumber(baseball.getInputNumber())).isFalse();
//    }

    @Test
    @DisplayName("숫자 유효성 검사 테스트")
    void isValidNumber() {
        Assertions.assertThat(baseball.isValidNumber(123)).isTrue();
        Assertions.assertThat(baseball.isValidNumber(987)).isTrue();
        Assertions.assertThat(baseball.isValidNumber(745)).isTrue();
        Assertions.assertThat(baseball.isValidNumber(543)).isTrue();
        Assertions.assertThat(baseball.isValidNumber(127)).isTrue();

        Assertions.assertThat(baseball.isValidNumber(111)).isFalse();
        Assertions.assertThat(baseball.isValidNumber(12)).isFalse();
        Assertions.assertThat(baseball.isValidNumber(133)).isFalse();
        Assertions.assertThat(baseball.isValidNumber(899)).isFalse();
        Assertions.assertThat(baseball.isValidNumber(-5)).isFalse();
    }


    @Test
    @DisplayName("결과 테스트")
    public void getGameResult() {
        Assertions.assertThat(baseball.getGameResult(123, 456)).isEqualTo("Nothing");
        Assertions.assertThat(baseball.getGameResult(123, 234)).isEqualTo("2 ball");
        Assertions.assertThat(baseball.getGameResult(785, 420)).isEqualTo("Nothing");
        Assertions.assertThat(baseball.getGameResult(123, 321)).isEqualTo("1 strike 2 ball");
        Assertions.assertThat(baseball.getGameResult(123, 120)).isEqualTo("2 strike ");
    }

    @Test
    @DisplayName("strike 갯수 테스트")
    public void getStrikeCount() {
        Assertions.assertThat(baseball.getStrikeCount(123, 456)).isEqualTo(0);
        Assertions.assertThat(baseball.getStrikeCount(123, 234)).isEqualTo(0);
        Assertions.assertThat(baseball.getStrikeCount(785, 420)).isEqualTo(0);
        Assertions.assertThat(baseball.getStrikeCount(123, 321)).isEqualTo(1);
        Assertions.assertThat(baseball.getStrikeCount(123, 120)).isEqualTo(2);
    }

    @Test
    @DisplayName("ball 갯수 테스트")
    public void getBallCount() {
        Assertions.assertThat(baseball.getBallCount(123, 456)).isEqualTo(0);
        Assertions.assertThat(baseball.getBallCount(123, 234)).isEqualTo(2);
        Assertions.assertThat(baseball.getBallCount(785, 420)).isEqualTo(0);
        Assertions.assertThat(baseball.getBallCount(123, 321)).isEqualTo(2);
        Assertions.assertThat(baseball.getBallCount(123, 120)).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    public void generateRandomNumber() {
        Assertions.assertThat(baseball.isValidNumber(baseball.generateRandomNumber())).isTrue();
        Assertions.assertThat(baseball.isValidNumber(baseball.generateRandomNumber())).isTrue();
        Assertions.assertThat(baseball.isValidNumber(baseball.generateRandomNumber())).isTrue();
        Assertions.assertThat(baseball.isValidNumber(baseball.generateRandomNumber())).isTrue();
        Assertions.assertThat(baseball.isValidNumber(baseball.generateRandomNumber())).isTrue();
    }


//    void askUserContinue() {
//        Assertions.assertThat(baseball.askUserContinue()).isEqualTo(0);
//    }

    @Test
    @DisplayName("3 strike 검사 테스트")
    public void isThreeStrike() {
        Assertions.assertThat(baseball.isThreeStrike("3 strike ")).isTrue();
        Assertions.assertThat(baseball.isThreeStrike("Nothing")).isFalse();
        Assertions.assertThat(baseball.isThreeStrike("1 strike ")).isFalse();
        Assertions.assertThat(baseball.isThreeStrike("2 strike ")).isFalse();
        Assertions.assertThat(baseball.isThreeStrike("1 strike 2 ball")).isFalse();
    }

}
