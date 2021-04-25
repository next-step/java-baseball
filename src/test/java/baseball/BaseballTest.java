package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BaseballTest {
    private Baseball baseball = new Baseball();

    @Test
    @DisplayName("만들어진 baseball 정답 숫자가 유효한 범위 내의 숫자로 잘 만들어지는지 테스트한다.")
    public void makeBaseballNumberRangeTest() {
        int baseballNumber = Integer.parseInt(baseball.makeBaseballNumberString());

        assertThat(baseballNumber).isGreaterThanOrEqualTo(111);
        assertThat(baseballNumber).isLessThanOrEqualTo(999);
    }

    @Test
    @DisplayName("만들어진 baseball 정답 숫자가 중복되는 수가 있는지 테스트한다.")
    public void makeBaseballNumberDigitCheckTest() {
        String baseballNumberString = baseball.makeBaseballNumberString();

        char firstDigit = baseballNumberString.charAt(0);
        char secondDigit = baseballNumberString.charAt(1);
        char thirdDigit = baseballNumberString.charAt(2);

        assertNotEquals(firstDigit, secondDigit);
        assertNotEquals(thirdDigit, secondDigit);
        assertNotEquals(firstDigit, thirdDigit);
    }

    @DisplayName("입력받는 baseball 정답 예측수가 유효한 숫자인지 테스트한다. (중복 수)")
    @ParameterizedTest
    @CsvSource(value = {"111:false", "999:false", "110:false", "555:false"}, delimiter = ':')
    public void isValidBaseballInputNumberDigitTest(int input, boolean expected) {
        assertEquals(baseball.isValidBaseballInputNumber(input), expected);
    }

    @DisplayName("입력받는 baseball 정답 예측수가 유효한 숫자인지 테스트한다. (0 포함 수)")
    @ParameterizedTest
    @CsvSource(value = {"200:false", "960:false", "201:false", "520:false"}, delimiter = ':')
    public void isValidBaseballInputNumberWithZeroTest(int input, boolean expected) {
        assertEquals(baseball.isValidBaseballInputNumber(input), expected);
    }

    @DisplayName("입력받는 baseball 정답 예측수가 유효한 숫자인지 테스트한다. (범위)")
    @ParameterizedTest
    @CsvSource(value = {"123:true", "987:true", "109:false", "1245:false", "13:false"}, delimiter = ':')
    public void isValidBaseballInputNumberRangeTest(int input, boolean expected) {
        assertEquals(baseball.isValidBaseballInputNumber(input), expected);
    }

    @DisplayName("정답,예측수,기대되는스트라이크개수 를 입력하여 베이스볼 게임 스트라이크 개수를 세는 메소드를 테스트 한다.")
    @ParameterizedTest
    @CsvSource(value = {"965,123,0", "456,456,3", "456,953,1", "693,492,1", "196,598,1", "356,956,2",
        "713,123,1", "713,145,0", "713,671,0", "713,216,1", "713,713,3"}, delimiter = ',')
    public void countStrikesTest(String baseballNumberString, String predictionNumberString, int expected) {
        assertEquals(baseball.countStrikes(baseballNumberString, predictionNumberString), expected);
    }

    @DisplayName("정답,예측수,기대되는 볼개수 를 입력하여 베이스볼 게임에서 볼 개수를 세는 메소드를 테스트 한다.")
    @ParameterizedTest
    @CsvSource(value = {"965,123,0", "456,456,0", "356,953,1", "289,492,2", "195,598,1", "356,635,3",
        "713,123,1", "713,145,1", "713,671,2", "713,216,0", "713,713,0"}, delimiter = ',')
    public void countBallsTest(String baseballNumberString, String predictionNumberString, int expected) {
        assertEquals(baseball.countBalls(baseballNumberString, predictionNumberString), expected);
    }

    @DisplayName("정답수와 예측수를 비교한 결과(스트라이크 개수, 볼 개수)출력 문자열 생성 중 올스트라이크 제외 테스트 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,1 스트라이크 2 볼", "2,0,2 스트라이크", "0,3,3 볼", "0,0,낫싱"}, delimiter = ',')
    public void makeComparisonResultStringTest(int strikeCount, int ballCount, String expected) {
        String resultString = baseball.makeComparisonResultString(new BaseballComparisonResult(strikeCount, ballCount));
        assertThat(resultString).isEqualTo(expected);
    }

    @DisplayName("정답수와 예측수를 비교한 결과(스트라이크 개수, 볼 개수)출력 문자열 생성 중 올스트라이크 테스트 한다.")
    @Test
    public void makeComparisonResultStringAllStrikeTest() {
        String resultString = baseball.makeComparisonResultString(new BaseballComparisonResult(3, 0));
        String allStrikeExpected = "3 스트라이크" +
                "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료" +
                "\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        assertThat(resultString).isEqualTo(allStrikeExpected);
    }
}