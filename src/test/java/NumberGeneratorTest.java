import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @RepeatedTest(100)
    public void 생성된수는3개이고1부터9까지의수이다() {
        final int[] threeNumbers = NumberGenerator.generate();
        assertThat(threeNumbers).hasSize(3)
                                .containsAnyOf(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void 같은수가나올확율10퍼센트미만이여야함() {
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
