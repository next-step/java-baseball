package checkor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballCheckorTest {

    private BaseballCheckor baseballCheckor;

    @BeforeEach
    void setUp() {
        int[] numbers = new int[]{1,7,9};
        baseballCheckor = new BaseballCheckor(numbers);
    }

    @ParameterizedTest
    @MethodSource("generateCheckData")
    @DisplayName("숫자를 입력하면 통과(3스트라이크)인지 확인하는 테스트")
    public void check(String input, boolean expected) {
        assertThat(baseballCheckor.check(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("generateStrikeAndBallData")
    @DisplayName("strike, ball 개수 맞추기 기능 테스트")
    public void countStrike(int[] input, int strikeExpected, int ballExpected) {
        baseballCheckor.initSet(input);
        int strike = baseballCheckor.strike(input);
        int ball = baseballCheckor.ball(input, strike);
        assertThat(strike).isEqualTo(strikeExpected);
        assertThat(ball).isEqualTo(ballExpected);
    }

    static Stream<Arguments> generateCheckData() {
        return Stream.of(
                Arguments.of("123", false),
                Arguments.of("179", true),
                Arguments.of("791", false),
                Arguments.of("258", false)
        );
    }

    static Stream<Arguments> generateStrikeAndBallData() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, 1, 0),
                Arguments.of(new int[]{1,7,9}, 3, 0),
                Arguments.of(new int[]{1,9,7}, 1, 2),
                Arguments.of(new int[]{1,7,2}, 2, 0),
                Arguments.of(new int[]{7,9,1}, 0, 3),
                Arguments.of(new int[]{2,5,8}, 0, 0)
        );
    }
}