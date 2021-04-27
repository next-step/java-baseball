package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseNumbersTest {
    String[] dumyData = {"5","4","3"};
    BaseNumbers baseNumbers = new BaseNumbers(dumyData);

    @Test
    @DisplayName("매개 변수 index에 0 미만의 수를 넣을 경우 false 리턴 여부 확인.")
    void isStrike_indexUnderZero() {
        assertThat(baseNumbers.isStrike("5", -3)).isFalse();
    }

    @Test
    @DisplayName("매개 변수 index에 BaseNumbers안의 list값보다 큰 수를 넣었을때 false 리턴 여부 확인.")
    void isStrike_indexExcess() {
        assertThat(baseNumbers.isStrike("5", 9)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"5:0:true", "4:1:true", "3:2:true", "5:2:false", "9:1:false"}, delimiter = ':')
    @DisplayName("사용자가 입력한 숫자가 스트라이크 인지 여부 확인.")
    void isStrike(String digit, int index, boolean result) {
        assertThat(baseNumbers.isStrike(digit, index)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:true", "4:true", "3:true", "9:false", "1:false"}, delimiter = ':')
    @DisplayName("사용자가 입력한 숫자가 볼 인지 여부 확인.")
    void isBall(String digit, boolean result) {
        assertThat(baseNumbers.isBall(digit)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"543:3", "519:1", "503:2", "789:0"}, delimiter = ':')
    @DisplayName("사용자가 입력한 숫자에 스트라이크 포함 수 확인.")
    void checkNumbers_strike(String input, int strike) {
        BaseballResult result = baseNumbers.checkNumbers(input);

        assertThat(result.getStrike()).isEqualTo(strike);
    }

    @ParameterizedTest
    @CsvSource(value = {"345:2", "435:3", "126:0", "530:1"}, delimiter = ':')
    @DisplayName("사용자가 입력한 숫자에 볼 포함 수 확인.")
    void checkNumbers_ball(String input, int ball) {
        BaseballResult result = baseNumbers.checkNumbers(input);

        assertThat(result.getBall()).isEqualTo(ball);
    }

}
