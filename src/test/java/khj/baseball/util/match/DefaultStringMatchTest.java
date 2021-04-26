package khj.baseball.util.match;

import khj.baseball.Record;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DefaultStringMatchTest {
    StringMatch match = new DefaultStringMatch();

    @DisplayName("문자열 두개를 비교 같을 경우 완료 처리한다.")
    @Test
    void matchStringIsComplete() {
        Record record = match.matchString("123", "123");
        assertTrue(record.isComplete(3));
    }

    @ParameterizedTest(name = "정답이 맞는 지 확인한다.")
    @CsvSource({"124,2,0", "213,1,2"})
    void matchString(String input, int strike, int ball) {
        Record record = match.matchString(input, "123");
        assertEquals(strike, record.getStrike());
        assertEquals(ball, record.getBall());
    }

    @DisplayName("문자열이 전부 맞지 않으면 낫싱인지 확인한다.")
    @Test
    void matchStringIsNoting() {
        Record record = match.matchString("123", "456");
        assertTrue(record.isNoting());
    }
}
