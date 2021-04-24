import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class BaseBallGameTest {

    @Test
    @DisplayName("야구 게임 시작")
    public void start() {

    }

    @Test
    @DisplayName("세 자리 숫자 생성 테스트")
    public void generateThreeNumbers() {
        Random random = new Random();
        int num1 = random.nextInt(9) + 1;
        int num2 = random.nextInt(9) + 1;
        int num3 = random.nextInt(9) + 1;

        assertThat((num1 > 0 && num1 < 10)
                && (num2 > 0 && num2 < 10)
                && (num3 > 0 && num3 < 10)).isTrue();
    }

    @Test
    @DisplayName("길이 검증 테스트")
    public void isValidLength() {
        String nums = "1234";

        assertThat(nums.length() != 3).isTrue();
    }

}
