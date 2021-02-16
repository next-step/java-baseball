package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BaseballDigitTest {
    @Test
    @DisplayName("숫자 생성 테스트")
    public void baseballDigitTest() throws Exception {
        BaseballDigit baseballDigit = new BaseballDigit("123");
        List<Integer> DIGITS = new ArrayList<>();
        DIGITS.add(1);
        DIGITS.add(2);
        DIGITS.add(3);
        Assertions.assertThat(baseballDigit.getBaseballValues().toString()).isEqualTo(DIGITS.toString());
    }
}