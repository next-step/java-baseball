import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class BaseBallGameTest {

    @BeforeAll
    @DisplayName("야구 게임 시작")
    public static void start() {

    }

    @AfterAll
    @DisplayName("야구 게임 종료")
    public static void end() {

    }

    @Test
    @DisplayName("세 자리 숫자 생성 테스트")
    public void generateThreeNumbers() {
        Random random = new Random();
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        while (num1 == num2 || num1 == num3 || num2 == num3) {
            num1 = random.nextInt(9) + 1;
            num2 = random.nextInt(9) + 1;
            num3 = random.nextInt(9) + 1;
        }
        assertThat(String.valueOf(num1) + num2 + num3).isInstanceOf(String.class);
        assertThat(String.valueOf(num1) + num2 + num3).hasSize(3);
        assertThat((num1 > 0 && num1 < 10)
                && (num2 > 0 && num2 < 10)
                && (num3 > 0 && num3 < 10)).isTrue();
        assertThat((num1 != num2)
                && (num1 != num3)
                && (num2 != num3)).isTrue();
    }

    @Test
    @DisplayName("길이 검증 테스트")
    public void isValidLength() {
        String nums = "1234";

        assertThat(nums.length() != 3).isTrue();
    }

    @Test
    @DisplayName("형식 검증 테스트")
    public void isValidFormat() {
        String inputVal1 = "#12";
        String inputVal2 = "106";

        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> Integer.parseInt(inputVal1));
        assertThat(inputVal2).contains("0");
    }

    @Test
    @DisplayName("스트라이크 계산 테스트")
    public void calculateStrike() {
        char[] base = {'7', '1', '3'};
        char[] input = {'7', '9', '1'};
        int expectedCount = 1;
        int actualCount = 0;

        int baseLength = base.length;
        for (int i = 0; i < baseLength; i++) {
            actualCount += (base[i] == input[i] ? 1 : 0);
        }
        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("볼 계산 테스트")
    public void calculateBall() {
        char[] base = {'7', '1', '3'};
        char[] input = {'7', '9', '1'};
        int expectedCount = 1;
        int actualCount = 0;

        int baseLength = base.length;
        int inputLength = input.length;
        for (int i = 0; i < baseLength; i++) {
            for (int j = 0; j < inputLength; j++) {
                actualCount += (i != j && base[i] == input[j] ? 1 : 0);
            }
        }
        assertThat(actualCount).isEqualTo(expectedCount);
    }
}
