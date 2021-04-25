import exception.BaseballException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import player.BaseballPitcher;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("투수 테스트")
public class PitcherTest {

    @Test
    @DisplayName("문자열에서 숫자로 변환")
    void successParseNumber() {
        String str = "123";
        Integer number = 123;

        assertEquals(BaseballPitcher.parseNumber(str), number);
    }

    @Test
    @DisplayName("잘못된 값을 받았을때 ParseNumberException을 전달")
    void failedParseNumber() {
        String str = "abc";

        assertThatExceptionOfType(BaseballException.ParseNumberException.class)
                .isThrownBy(() -> BaseballPitcher.parseNumber(str))
                .withMessageMatching(BaseballException.PARSE_NUMBER_ERROR);
    }
}
