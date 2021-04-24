package com.woowahan.precourse.baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {

    @Test
    @DisplayName("세자리의 수는 서로 다른 수여야 한다.")
    void shouldBeThreeNumberIsDifferentNumbers() {

        for (int i = 0; i < 10000; i++) {
            String[] gameNumber = new BaseBallGame().getGameNumber();
            assertThat(isDifferentNumbers(gameNumber)).isTrue();
        }
    }

    @Test
    @DisplayName("shouldBeThreeNumberIsDifferentNumbers()에서 사용된 isDifferentNumbers()가 세개의 서로다른 수를 정확히 검증하고 있는지 확인")
    void isDifferentNumbersTest() {
        // 3자리가 모두 다른지 확인 가능한 모든 경우의 수는 아래 4개 뿐이다.
        String[] str1 = new String[] { "1", "1", "1" };
        String[] str2 = new String[] { "1", "1", "2" };
        String[] str3 = new String[] { "1", "2", "2" };
        String[] str4 = new String[] { "1", "2", "1" };

        assertThat(isDifferentNumbers(str1)).isFalse();
        assertThat(isDifferentNumbers(str2)).isFalse();
        assertThat(isDifferentNumbers(str3)).isFalse();
        assertThat(isDifferentNumbers(str4)).isFalse();
    }

    private boolean isDifferentNumbers(String[] gameNumber) {
        String firstNumber = gameNumber[0];
        String secondNumber = gameNumber[1];
        String thirdNumber = gameNumber[2];
        return !firstNumber.equals(secondNumber) && !firstNumber.equals(thirdNumber) && !secondNumber.equals(thirdNumber);
    }
}
