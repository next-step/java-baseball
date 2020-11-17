import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @Test
    @DisplayName("야구게임 테스트 - NOTHING")
    void test1() {
        // 하나도 맞지 않는 두 값으로 테스트
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
        // 비교결과가 1볼, 0스트라이크인 데이터로 테스트
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
        // 비교결과가 0볼, 1스트라이크인 데이터로 테스트
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
        // 비교결과가 1볼, 1스트라이크인 데이터로 테스트
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
        // 비교결과가 동일한 데이터로 테스트
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

    @Test
    @DisplayName("볼카운트 계산하는 메소드 테스트")
    void test6() {
        int testInput1 = 123;
        int testInput2 = 456;
        int ballCount1 = NumberComparator.calculateBallCount(testInput1, testInput2);
        assertThat(ballCount1).isEqualTo(0);

        int testInput3 = 123;
        int testInput4 = 345;
        int ballCount2 = NumberComparator.calculateBallCount(testInput3, testInput4);
        assertThat(ballCount2).isEqualTo(1);

        int testInput5 = 123;
        int testInput6 = 341;
        int ballCount3 = NumberComparator.calculateBallCount(testInput5, testInput6);
        assertThat(ballCount3).isEqualTo(2);

        int testInput7 = 123;
        int testInput8 = 312;
        int ballCount4 = NumberComparator.calculateBallCount(testInput7, testInput8);
        assertThat(ballCount4).isEqualTo(3);
    }

    @Test
    @DisplayName("스트라이크카운트 계산하는 메소드 테스트")
    void test7(){
        int test1 = 123;
        int test2 = 456;
        int strikeCount1 = NumberComparator.calculateStrikeCount(test1, test2);
        assertThat(strikeCount1).isEqualTo(0);

        int test3 = 123;
        int test4 = 156;
        int strikeCount2 = NumberComparator.calculateStrikeCount(test3, test4);
        assertThat(strikeCount2).isEqualTo(1);

        int test5 = 123;
        int test6 = 153;
        int strikeCount3 = NumberComparator.calculateStrikeCount(test5, test6);
        assertThat(strikeCount3).isEqualTo(2);

        int test7 = 123;
        int test8 = 123;
        int strikeCount4 = NumberComparator.calculateStrikeCount(test7, test8);
        assertThat(strikeCount4).isEqualTo(3);
    }

}