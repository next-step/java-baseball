import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @Test
    @DisplayName("야구게임 테스트 - NOTHING")
    void test1() {
        int testInput1 = 345;
        int testInput2 = 678;

        BaseballCompareResult result = NumberComparator.compare(testInput1, testInput2);
        BaseballCompareResultStatus status = result.getStatus();
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        assertThat(ballCount).isEqualTo(0);
        assertThat(strikeCount).isEqualTo(0);
        assertThat(status).isEqualTo(BaseballCompareResultStatus.NOTHING);
    }

    @Test
    @DisplayName("야구게임 테스트 - 볼 존재O, 스트라이크 존재X")
    void test2() {
        int testInput1 = 365;
        int testInput2 = 678;

        BaseballCompareResult result = NumberComparator.compare(testInput1, testInput2);
        BaseballCompareResultStatus status = result.getStatus();
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        assertThat(ballCount).isEqualTo(1);
        assertThat(strikeCount).isEqualTo(0);
        assertThat(status).isEqualTo(BaseballCompareResultStatus.EXIST);
    }

    @Test
    @DisplayName("야구게임 테스트 - 볼 존재X, 스트라이크 존재O")
    void test3() {
        int testInput1 = 375;
        int testInput2 = 678;

        BaseballCompareResult result = NumberComparator.compare(testInput1, testInput2);
        BaseballCompareResultStatus status = result.getStatus();
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        assertThat(ballCount).isEqualTo(0);
        assertThat(strikeCount).isEqualTo(1);
        assertThat(status).isEqualTo(BaseballCompareResultStatus.EXIST);
    }

    @Test
    @DisplayName("야구게임 테스트 - 볼, 스트라이크 둘 다 존재O")
    void test4() {
        int testInput1 = 875;
        int testInput2 = 678;

        BaseballCompareResult result = NumberComparator.compare(testInput1, testInput2);
        BaseballCompareResultStatus status = result.getStatus();
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        assertThat(ballCount).isEqualTo(1);
        assertThat(strikeCount).isEqualTo(1);
        assertThat(status).isEqualTo(BaseballCompareResultStatus.EXIST);
    }

    @Test
    @DisplayName("야구게임 테스트 - 정답과 동일")
    void test5() {
        int testInput1 = 678;
        int testInput2 = 678;

        BaseballCompareResult result = NumberComparator.compare(testInput1, testInput2);
        BaseballCompareResultStatus status = result.getStatus();
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        assertThat(ballCount).isEqualTo(0);
        assertThat(strikeCount).isEqualTo(3);
        assertThat(status).isEqualTo(BaseballCompareResultStatus.MATCHED);
    }

}