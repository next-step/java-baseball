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
        assertThat(singleDigits.size()).isEqualTo(3);

        // 같은 수가 존재하지 않음을 확인하는 테스트
        for (int i = 0; i < singleDigits.size(); i++) {
            for (int k = i + 1; k < singleDigits.size(); k++) {
                assertThat(singleDigits.get(i)).isNotEqualTo(singleDigits.get(k));
            }
        }
    }

    @Test
    @DisplayName("각 자리수의 숫자를 분리하여 배열로 얻는 테스트")
    void test3() {
        // 각 자리수가 1~9로 이루어진 세자리 수를 얻음
        int randomThreeDigit = NumberGenerator.makeRandomThreeDigit();
        List<Integer> singleDigits = NumberGenerator.toSingleDigitArray(randomThreeDigit);

        // 전부 1~9 사이의 숫자인지 테스트
        for (int digit : singleDigits) {
            assertThat(digit).isNotZero();
            assertThat(digit).isPositive();
            assertThat(digit).isLessThan(10);
        }
    }

}