package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class InningInfoTest {
    @ParameterizedTest
    @DisplayName("Test play message by Inning info")
    @CsvSource({
        "0, 0, '낫싱\n'",
        "1, 0, '1볼\n'",
        "0, 2, '2스트라이크\n'",
        "2, 1, '2볼 1스트라이크\n'",
    })
    void playMessage(int ball, int strike, String expected) {
        InningInfo info = new InningInfo(strike, ball, 3);

        assertEquals(expected, info.playMessage());
    }

    @ParameterizedTest
    @DisplayName("Test end message by Inning info")
    @CsvSource({
        "2, 1, ''",
        "0, 3, '3개의 숫자를 모두 맞히셨습니다! 게임 종료\n'",
    })
    void endMessage(int ball, int strike, String expected) {
        InningInfo info = new InningInfo(strike, ball, 3);

        assertEquals(expected, info.endMessage());
    }
}
