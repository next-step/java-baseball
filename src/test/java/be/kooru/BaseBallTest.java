package be.kooru;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseBallTest {
    private int[] numbers;
    private BaseBall baseBall;

    @BeforeEach
    void setUp() {
        numbers = new int[]{1, 2, 3};
        baseBall = new BaseBall();
    }

    @DisplayName("입력한 숫자 스트라이크 개수 확인")
    @ParameterizedTest
    @CsvSource({"123,3", "124,2", "134,1", "234,0"})
    void verifyStrikeCount(String input, String expected) {
        int[] uValue = Util.convertStringToIntArray(input);
        int expectedNumber = Integer.parseInt(expected);
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(baseBall.verifyStrike(numbers[i], i, uValue)) count++;
        }
        Assertions.assertThat(count)
                .isNotNull()
                .isEqualTo(expectedNumber);
    }

    @DisplayName("입력한 숫자 볼 개수 확인")
    @ParameterizedTest
    @CsvSource({"123,0", "124,0", "134,1", "234,2", "231,3"})
    void verifyBallCount(String input, String expected) {
        int[] uValue = Util.convertStringToIntArray(input);
        int expectedNumber = Integer.parseInt(expected);
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(baseBall.verifyBall(numbers[i], i, uValue)) count++;
        }
        
        Assertions.assertThat(count)
                .isNotNull()
                .isEqualTo(expectedNumber);

    }

    @DisplayName("입력한 숫자의 점수 확인")
    @ParameterizedTest
    @CsvSource({"123,30", "124,20", "134,11", "234,2", "231,3"})
    void scoreCalculator(String input, String expected) {
        int[] uValue = Util.convertStringToIntArray(input);
        int expectedNumber = Integer.parseInt(expected);

        Assertions.assertThat(baseBall.scoreCalculator(numbers,uValue))
                .isNotNull()
                .isEqualTo(expectedNumber);

    }
}