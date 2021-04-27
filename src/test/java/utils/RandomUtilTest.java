package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilTest {

    @Test
    @DisplayName("무작위 숫자 1~9 획득 테스트")
    public void getRandomNumberTest() {
        // given
        int start = 1;
        int end = 9;

        // when
        int i = 0;
        while (i++ < 100) {
            int randomNumber = RandomUtil.getRandomNumber(1, 9);

            // then
            assertThat(randomNumber).isBetween(start, end);
        }
    }
}