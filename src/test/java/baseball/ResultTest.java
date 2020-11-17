package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ResultTest {
    private Result result;

    @ParameterizedTest
    @CsvSource(value = {"1, 0, 1스트라이크", "2, 0, 2스트라이크", "1, 1, 1스트라이크1볼", "0, 0, 낫싱"})
    @DisplayName("스트라이크와 볼에 따라서 알맞은 메시지가 나오는지 확인한다")
    public void testGetResultMessage(int strike, int ball, String expectedMessage) {
        result = new Result();
        result.setStrike(strike);
        result.setBall(ball);
        assertThat(result.getResultMessage()).isEqualTo(expectedMessage);
    }
}
