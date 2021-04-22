import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {

    @ParameterizedTest
    @CsvSource({"0, 0, '낫싱'",
                "1, 0, '1 스트라이크'",
                "0, 3, '3볼'"})
    void testToString(ArgumentsAccessor argumentsAccessor) {
        Judge judge = new Judge();
        judge.strike = argumentsAccessor.getInteger(0);
        judge.ball = argumentsAccessor.getInteger(1);

        String expected = argumentsAccessor.getString(2);

        assertEquals(expected, judge.toString());
    }
}