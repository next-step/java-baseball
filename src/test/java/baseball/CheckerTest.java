package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CheckerTest {
    private List<Integer> answer;

    @BeforeEach
    public void setUp() {
        answer = new ArrayList<>();
        answer.add(1);
        answer.add(2);
        answer.add(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"123, 3, 0", "132, 1, 2", "231, 0, 3", "321, 1, 2"})
    @DisplayName("입력받은 값에 따라 answer와 비교하여 스트라이크 또는 볼을 판단한다")
    public void testCheckStrikeOrBall(int input, int expectedStrike, int expectedBall) {
        Result result = new Result();
        Checker.checkStrikeOrBall(input, answer, result);
        assertThat(result.getStrike()).isEqualTo(expectedStrike);
        assertThat(result.getBall()).isEqualTo(expectedBall);
    }
}
