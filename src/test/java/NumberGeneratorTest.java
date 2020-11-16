import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @Test
    @DisplayName("1~9 사이의 숫자 생성 테스트")
    void test1() {
        int randomSingleDigit = NumberGenerator.makeRandomSingleDigit();
        assertThat(randomSingleDigit).isNotZero();
        assertThat(randomSingleDigit).isPositive();
        assertThat(randomSingleDigit).isLessThan(10);
    }

    @Test
    @DisplayName("세자리 랜덤한 숫자 생성 테스트")
    void test2() {
        // 각 자리수가 1~9로 이루어진 세자리 수를 얻음
        int randomThreeDigit = NumberGenerator.makeRandomThreeDigit();
        assertThat(randomThreeDigit).isLessThan(1000);
        assertThat(randomThreeDigit).isGreaterThan(99);
        // 각 자리수를 분리하여 배열에 담음
        List<Integer> singleDigits = NumberGenerator.toSingleDigitArray(randomThreeDigit);

        assertThat(NumberGenerator.checkRightData(singleDigits)).isEqualTo(true);
    }

}