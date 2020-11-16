import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @RepeatedTest(100)
    public void testGeneratedNumbersByRepeat() {
        final int[] threeNumbers = NumberGenerator.generate();
        assertThat(threeNumbers).hasSize(3) /*숫자는 3개*/
                                .containsAnyOf(1, 2, 3, 4, 5, 6, 7, 8, 9) /*1부터 9까지의 숫자*/
                                .has(new Condition<int[]>("생성된 숫자는 중복되지 않는다") {
                                    @Override
                                    public boolean matches(int[] value) {
                                        return value[0] != value[1] &&
                                               value[0] != value[2] &&
                                               value[1] != value[2];
                                    }
                                });
    }

    @Test
    public void testDuplicationProbabilityForGeneratedNumber() {
        // 확율상 9 * 8 * 7 = 504 의 경우의 수가 있으므로 중복이 발생할 확율은 0.2% 미만이지만 상식선에서 10%를 오차범위로 둔다.
        final int[] firstNumbers = NumberGenerator.generate();
        int collisionCount = 0;
        final int tryCount = 1000;
        for (int i=0; i<tryCount; i++) {
            final int[] nextNumbers = NumberGenerator.generate();
            if (firstNumbers[0] == nextNumbers[0] &&
                firstNumbers[1] == nextNumbers[1] &&
                firstNumbers[2] == nextNumbers[2]) {
                collisionCount++;
            }
        }
        assertThat(collisionCount).isLessThan(tryCount / 10);
    }
}
