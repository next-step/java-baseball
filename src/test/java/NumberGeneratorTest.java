import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    @DisplayName("올바른 데이터인지 확인하는 메소드를 테스트 - 파라미터가 int형인 경우")
    void test3() {
        // 숫자가 네자리 수 이므로 잘못된 데이터
        int wrongThreeDigit1 = 1234;
        boolean isRightData1 = NumberGenerator.checkRightData(wrongThreeDigit1);
        assertThat(isRightData1).isEqualTo(false);

        // 동일한 숫자가 존재하므로 잘못된 데이터
        int wrongThreeDigit2 = 133;
        boolean isRightData2 = NumberGenerator.checkRightData(wrongThreeDigit2);
        assertThat(isRightData2).isEqualTo(false);

        // 올바른 데이터
        int rightThreeData3 = 123;
        boolean isRightData3 = NumberGenerator.checkRightData(rightThreeData3);
        assertThat(isRightData3).isEqualTo(true);
    }

    @Test
    @DisplayName("올바른 데이터인지 확인하는 메소드를 테스트 - 파라미터가 List형인 경우")
    void test4() {
        // 숫자가 네자리 수 이므로 잘못된 데이터
        List<Integer> wrongThreeDigit1 = new ArrayList<>();
        wrongThreeDigit1.add(1);
        wrongThreeDigit1.add(2);
        wrongThreeDigit1.add(3);
        wrongThreeDigit1.add(4);
        boolean isRightData1 = NumberGenerator.checkRightData(wrongThreeDigit1);
        assertThat(isRightData1).isEqualTo(false);

        // 동일한 숫자가 존재하므로 잘못된 데이터
        List<Integer> wrongThreeDigit2 = new ArrayList<>();
        wrongThreeDigit2.add(1);
        wrongThreeDigit2.add(3);
        wrongThreeDigit2.add(3);
        boolean isRightData2 = NumberGenerator.checkRightData(wrongThreeDigit2);
        assertThat(isRightData2).isEqualTo(false);

        // 올바른 데이터
        List<Integer> rightThreeDigit3 = new ArrayList<>();
        rightThreeDigit3.add(1);
        rightThreeDigit3.add(2);
        rightThreeDigit3.add(3);
        boolean isRightData3 = NumberGenerator.checkRightData(rightThreeDigit3);
        assertThat(isRightData3).isEqualTo(true);
    }

}