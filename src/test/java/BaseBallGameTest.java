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
        assertThat(num1).isBetween(1, 9);
        assertThat(num2).isBetween(1, 9);
        assertThat(num3).isBetween(1, 9);
        assertThat(num1).isNotEqualTo(num2);
        assertThat(num1).isNotEqualTo(num3);
        assertThat(num2).isNotEqualTo(num3);
    }

    @Test
    @DisplayName("길이 검증 테스트")
    public void isValidLength() {
        String nums = "1234";
        assertThat(nums.length()).isNotEqualTo(3);
    }

    @Test
    @DisplayName("형식 검증 테스트")
    public void isValidFormat() {
        char[] correctChars = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] wrongChars = {'0', '!', '@', '*', 'a', 'A'};
        for (char c : correctChars) {
            assertThat((int) c).isBetween(49, 57);
        }
        for (char c : wrongChars) {
            assertThat((int) c).isNotIn(49, 50, 51, 52, 53, 54, 55, 56, 57);
        }
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
