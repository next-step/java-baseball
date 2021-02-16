package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class BallNumbersTest {

    @DisplayName("유저가 규정에 맞게 입력한 숫자를 정확하게 생성하는지 확인")
    @Test
    void createBallNumbersTest() {
        BallNumbers ballNumbers = BallNumbers.of("123");
        BallNumbers expected = new BallNumbers(
                new ArrayList<Number>() {{
                    add(Number.of(1));
                    add(Number.of(2));
                    add(Number.of(3));
                }}
        );
        assertThat(ballNumbers).isEqualTo(expected);
        assertThat(ballNumbers.hashCode()).isEqualTo(expected.hashCode());
    }

    @DisplayName("유저가 입력한 숫자가 중복된 숫자를 가지고 있을때 에러를 잘 던지는지 확인")
    @Test
    void checkUniqueNumbersTest() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> BallNumbers.of("113"));
    }

    @DisplayName("유저가 세자리 숫자를 가지고 있지 않을때 에러를 잘 던지는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"13", "1345", "1344"})
    void checkCorrectSizeTest(String numbers) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> BallNumbers.of(numbers));
    }

    @DisplayName("유저의 숫자와 정답 숫자를 비교한다.")
    @ParameterizedTest
    @MethodSource("providerGetResultTestParam")
    void matchTest(String number, String expected) {
        BallNumbers answer = BallNumbers.of("123");
        BallNumbers guess = BallNumbers.of(number);

        assertThat(answer.match(new BallCount(), guess).toString()).hasToString(expected);
    }

    private static Stream<Arguments> providerGetResultTestParam() {
        return Stream.of(
                Arguments.of("132", "2볼 1스트라이크"),
                Arguments.of("456", "낫싱"),
                Arguments.of("123", "3스트라이크")
        );
    }
}