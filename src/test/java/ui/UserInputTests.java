package ui;

import domain.BaseballNumbers;
import domain.exceptions.OutOfBoundBaseballNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ui.exceptions.InvalidSizeException;

import java.util.stream.Stream;

import static fixtures.FakeBaseballNumbers.FIVE_ONE_TWO;
import static fixtures.FakeBaseballNumbers.ONE_TWO_THREE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTests {
    @DisplayName("문자열로 사용자의 입력을 받아 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        UserInput userInput = new UserInput("123");

        assertThat(userInput).isNotNull();
    }

    @DisplayName("사용자가 입력한 문자열의 크기가 3이 아닌 경우 예외가 발생한다.")
    @Test
    void createFailTest() {
        assertThatThrownBy(() -> new UserInput("1234")).isInstanceOf(InvalidSizeException.class);
    }

    @DisplayName("입력값을 야구게임숫자 일급컬렉션으로 변환할 수 있다.")
    @ParameterizedTest()
    @MethodSource("convertToBaseballNumbersResource")
    void convertToBaseballNumbersTest(UserInput userInput, BaseballNumbers expectedResult) {
        assertThat(userInput.convertToBaseballNumbers()).isEqualTo(expectedResult);
    }
    public static Stream<Arguments> convertToBaseballNumbersResource() {
        return Stream.of(
                Arguments.of(new UserInput("123"), ONE_TWO_THREE),
                Arguments.of(new UserInput("512"), FIVE_ONE_TWO)
        );
    }

    @DisplayName("1 ~ 9를 벗어난 숫자가 포함된 입력값으로 일급컬렉션 변환 시도 시 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("convertToBaseballNumbersWithOutOfBoundResource")
    void convertToBaseballNumbersWithOutOfBoundTest(UserInput userInput) {
        assertThatThrownBy(userInput::convertToBaseballNumbers).isInstanceOf(OutOfBoundBaseballNumberException.class);
    }
    public static Stream<Arguments> convertToBaseballNumbersWithOutOfBoundResource() {
        return Stream.of(
                Arguments.of(new UserInput("103")),
                Arguments.of(new UserInput("012")),
                Arguments.of(new UserInput("780"))
        );
    }

    @DisplayName("숫자와 문자열이 섞인 입력값으로 일급컬렉션 변환 시도 시 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("convertToBaseballNumbersWithNotIntResource")
    void convertToBaseballNumbersWithNotIntTest(UserInput userInput) {
        assertThatThrownBy(userInput::convertToBaseballNumbers).isInstanceOf(NumberFormatException.class);
    }
    public static Stream<Arguments> convertToBaseballNumbersWithNotIntResource() {
        return Stream.of(
                Arguments.of(new UserInput("17b")),
                Arguments.of(new UserInput("a8b")),
                Arguments.of(new UserInput("ab9")),
                Arguments.of(new UserInput("a39"))
        );
    }
}
