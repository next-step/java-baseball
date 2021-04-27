package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BaseballResultTest {

    private int NUMBER_SIZE = 3;
    
    @ParameterizedTest
    @CsvSource(value = {"1:2:1스트라이크 2볼", "0:1:1볼", "1:0:1스트라이크"}, delimiter = ':')
    @DisplayName("결과 메시지가 정상적인지 확인.")
    void getResultMessage(int strike, int ball, String result) {
        BaseballResult baseballResult = new BaseballResult(strike, ball, NUMBER_SIZE);
        assertThat(baseballResult.getResultMessage()).isEqualTo(result);
    }
}
