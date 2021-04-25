package io.mwkwon.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CreateComputerNumbersTest {

    private String computerNumbers;

    @BeforeEach
    void setUp() {
        BaseBallGame baseBallGame = new BaseBallGame();
        computerNumbers = baseBallGame.createComputerNumbers();
    }

    @Test
    @DisplayName("생성된 computerNumbers의 길이가 3인지 테스트")
    void computerNumbersLengthTest() {
        assertThat(computerNumbers.length()).isEqualTo(BaseBallGame.MAX_VALUE_LENGTH);
    }

    @ParameterizedTest
    @DisplayName("생성된 computerNumber가 0보다 크고 10보다 작은 수로 이루어져있는지 테스트")
    @CsvSource({"1, 9"})
    void computerNumbersRangeTest(int start, int end) {
        String[] computerNumbersArr = computerNumbers.split("");
        for (String number : computerNumbersArr) {
            assertThat(Integer.valueOf(number)).isBetween(start, end);
        }
    }
}
