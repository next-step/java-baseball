package baseball;

import baseball.numbergenerator.NumberGenerator;
import baseball.numbergenerator.ThreeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.any;

class BaseballGameModelTest {

    BaseballGameModel sut;
    NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new ThreeNumberGenerator();
    }

    @Test
    void 사용자로부터_값을_입력받는다() {
        String userInput = "123";
        sut = new BaseballGameModel(userInput, numberGenerator);
        String value = sut.userInput();
        assertThat(value).isEqualTo(userInput);
    }

    @Test
    void 사용자로부터_입력받은_값은_3자리_숫자여야한다() {
        String _123 = "123";
        sut = new BaseballGameModel(_123, numberGenerator);
        String value = sut.userInput();
        char[] chars = value.toCharArray();
        for (char c : chars) {
            assertThat(Character.isDigit(c)).isTrue();
        }
    }

    @ParameterizedTest(name = "[{index}] 사용자값 {argumentsWithNames}이 3자리 숫자가 아닐 경우 IllegalArgumentException 발생한다 ")
    @ValueSource(strings = {"1", "12", "1234"})
    void 사용자_값이_3자리_숫자가_아닐경우_IllegalArgumentException_을_던진다(String input) {
        sut = new BaseballGameModel(input, numberGenerator);
        assertThatThrownBy(() -> sut.userInput()).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("3자리 숫자만 허용합니다.");
    }

    @ParameterizedTest(name = "[{index}] 사용자값 {argumentsWithNames}가 숫자가 아닐 경우 IllegalArgumentException 발생한다 ")
    @ValueSource(strings = {"a", "abc", "abc123", "1qa"})
    void 사용자_값이_숫자가_아닐경우_IllegalArgumentException_을_던진다(String input) {
        sut = new BaseballGameModel(input, numberGenerator);
        assertThatThrownBy(() -> sut.userInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("3자리 숫자만 허용합니다.");
    }

    private void init(String input, String target) {
        sut = new BaseballGameModel(input, numberGenerator);
        sut.setTarget(target);
    }

    @ParameterizedTest(name = "사용자입력: {0}, 시스템 입력: {1} > 결과: {2}스{3}볼")
    @MethodSource("guessNumberResult")
    @DisplayName("사용자 숫자과 시스템 숫자 비교")
    void 사용자_숫자과_시스템_숫자_를_비교한다(String input, String target, int strikeResult, int ballResult) {
        init(input, target);

        int[] countResult = sut.guessNumber();

        int strike = countResult[0];
        int ball = countResult[1];

        assertThat(strike).isEqualTo(strikeResult);
        assertThat(ball).isEqualTo(ballResult);
    }

    private static Stream<Arguments> guessNumberResult() {
        return Stream.of(
                Arguments.of("123", "123", "3", "0", "세 자리 모두 일치"),
                Arguments.of("123", "312", "0", "3", "세 자리 모두 자리 불일치"),
                Arguments.of("123", "132", "1", "2", "한 자리 일치, 나머지 두자리 위치 불일치"),
                Arguments.of("124", "125", "2", "0", "두자리 일치"),
                Arguments.of("123", "134", "1", "1", "한 자리 일치, 한 자리 위치 불일치"),
                Arguments.of("123", "342", "0", "2", "두 자리 위치 불일치"),
                Arguments.of("134", "125", "1", "0", "한 자리 일치"),
                Arguments.of("134", "356", "0", "1","한 자리 위치 불일치"),
                Arguments.of("134", "677", "0", "0", "모든 자리 불일치")
        );
    }

    @ParameterizedTest(name = "strike: {0}, ball: {1} > 출력: {2}")
    @MethodSource("printNumberResult")
    void baseBallGame__결과_출력값_테스트(int strike, int ball, String message) {
        init(any(), any());
        String actual = sut.printBallCountMessages(strike, ball);
        assertThat(actual).isEqualTo(message);
    }

    private static Stream<Arguments> printNumberResult() {
        return Stream.of(
                Arguments.of("3", "0", "3 스트라이크"),
                Arguments.of("0", "3", "3 볼"),
                Arguments.of("1", "2", "1 스트라이크 2 볼"),
                Arguments.of("2", "0", "2 스트라이크"),
                Arguments.of("1", "1", "1 스트라이크 1 볼"),
                Arguments.of("0", "2", "2 볼"),
                Arguments.of("1", "0", "1 스트라이크"),
                Arguments.of("0", "1", "1 볼"),
                Arguments.of("0", "0", "낫씽")
        );
    }
}