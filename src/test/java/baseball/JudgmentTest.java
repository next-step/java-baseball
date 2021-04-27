package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class JudgmentTest {
    private static Judgment judgment = new Judgment();

    @DisplayName("separateNumber() : 각각의 자릿 수가 배열로 잘 반환되는지")
    @Test
    void testSeparateNumber() {
        int number = 573;
        int[] testSeparate = judgment.separateNumber(number);
        int merge = testSeparate[0] * 100 + testSeparate[1] * 10 + testSeparate[2];

        assertThat(merge).isEqualTo(number);
    }

    @DisplayName("getHint() : 스트라이크와 볼의 개수가 맞는지 확인")
    @Test
    void testHint() {
        int[] computerNumber1 = {1, 2, 3};
        int[] userNumber1 = {5, 4, 2};

        int[] computerNumber2 = {2, 3, 4};
        int[] userNumber2 = {5, 3, 2};

        int[] computerNumber3 = {5, 3, 2};
        int[] userNumber3 = {5, 3, 2};

        int[] hint1 = judgment.getHint(computerNumber1, userNumber1);
        int[] hint2 = judgment.getHint(computerNumber2, userNumber2);
        int[] hint3 = judgment.getHint(computerNumber3, userNumber3);

        assertThat(hint1).containsExactly(0, 1);
        assertThat(hint2).containsExactly(1, 1);
        assertThat(hint3).containsExactly(3, 0);
    }

    @DisplayName("checkBall() : 스트라이크가 아닌 것들 중 볼인 것을 확인")
    @Test
    void testCehckBall() {
        int number = 5;
        int index = 1;
        int[] compareArr = {5, 2, 3};

        int number2 = 5;
        int index2 = 1;
        int[] compareArr2 = {2, 5, 3};

        assertThat(judgment.checkBall(number, index, compareArr)).isEqualTo(1);
        assertThat(judgment.checkBall(number2, index2, compareArr2)).isEqualTo(0);
    }

    @DisplayName("checkBallIndex() : 스트라이크일 경우 0 스트라이크가 아니고 볼인 경우 1")
    @Test
    void testCheckBallIndex() {
        int number = 5;
        int index = 1;
        int compareNumber = 5;
        int comapreIndex = 1;

        int number2 = 5;
        int index2 = 2;
        int compareNumber2 = 5;
        int comapreIndex2 = 1;

        assertThat(judgment.checkBallIndex(number, index, compareNumber, comapreIndex)).isEqualTo(0);
        assertThat(judgment.checkBallIndex(number2, index2, compareNumber2, comapreIndex2)).isEqualTo(1);
    }

    @DisplayName("isEqual() : 두 값이 같으면 1 같지 않으면 0 확인")
    @Test
    void testIsEqaul() {
        int number = 6;
        int compareNumber = 6;

        int number2 = 5;
        int compareNumber2 = 9;

        assertThat(judgment.isEqual(number, compareNumber)).isEqualTo(1);
        assertThat(judgment.isEqual(number2, compareNumber2)).isEqualTo(0);
    }

    @DisplayName("isNothing() : 낫싱 확인")
    @Test
    void testIsNothing() {
        int[] hint = {0, 0};

        assertThat(judgment.isNothing(hint)).isTrue();
    }
}
