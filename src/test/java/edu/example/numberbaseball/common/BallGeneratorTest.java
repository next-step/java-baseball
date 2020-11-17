package edu.example.numberbaseball.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("`Inning`에 필요한 `Ball`을 생성하기 위한 기능 테스트")
class BallGeneratorTest {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int TEN = 10;

    @DisplayName("`Inning`에 필요한 갯수의 `Ball`을 입력된 input만큼 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {THREE})
    void generateRandomBallList(int input) {
        List<Ball> ballList = new BallGenerator().generateRandomBallList(input);
        int ballListSize = ballList.size();

        assertEquals(input, ballListSize);
    }

    @DisplayName("`Inning`에 필요한 갯수에 맞지 않는 `Ball`을 생성하면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {ONE, TWO, TEN})
    void generateInvalidRandomBallList(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BallGenerator().generateRandomBallList(input));
    }
}
