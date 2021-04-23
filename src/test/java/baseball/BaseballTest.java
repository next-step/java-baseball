package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BaseballTest {
    private Baseball baseball = new Baseball();

    @Test
    @DisplayName("만들어진 baseball 정답 숫자가 유효한 범위 내의 숫자로 잘 만들어지는지 테스트한다.")
    public void makeBaseballNumberRangeTest() {
        int baseballNumber = Integer.parseInt(baseball.makeBaseballNumberString());

        assertThat(baseballNumber).isGreaterThanOrEqualTo(111);
        assertThat(baseballNumber).isLessThanOrEqualTo(999);
    }

    @Test
    @DisplayName("만들어진 baseball 정답 숫자가 중복되는 수가 있는지 테스트한다.")
    public void makeBaseballNumberDigitCheckTest() {
        String baseballNumberString = baseball.makeBaseballNumberString();

        char firstDigit = baseballNumberString.charAt(0);
        char secondDigit = baseballNumberString.charAt(1);
        char thirdDigit = baseballNumberString.charAt(2);

        assertNotEquals(firstDigit, secondDigit);
        assertNotEquals(thirdDigit, secondDigit);
        assertNotEquals(firstDigit, thirdDigit);
    }


}