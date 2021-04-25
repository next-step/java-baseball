package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallRefereeTest {
    @ParameterizedTest
    @ValueSource(strings = {"189", "928", "893"})
    @DisplayName("숫자와 자리수가 일치하면 스트라이크이다 - 1")
    public void strike(String candidate) {
        assertEquals(1, BaseBallReferee.calculate("123", candidate).getStrikeCount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"120", "023", "103"})
    @DisplayName("숫자와 자리수가 일치하면 스트라이크이다 - 2")
    public void strike2(String candidate) {
        assertEquals(2, BaseBallReferee.calculate("123", candidate).getStrikeCount());
    }

    @Test
    @DisplayName("숫자와 자리수가 일치하면 스트라이크이다 - 3")
    public void strike3() {
        assertEquals(3, BaseBallReferee.calculate("123", "123").getStrikeCount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"456", "567", "678", "789", "890"})
    @DisplayName("숫자가 일치하지 않으면 스트라이크가 아니다")
    public void notStrike2(String candidate) {
        assertEquals(0, BaseBallReferee.calculate("123", candidate).getStrikeCount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"312", "231"})
    @DisplayName("숫자가 일치해도 자리수가 맞지 않으면 스트라이크가 아니다")
    public void notStrike(String candidate) {
        assertEquals(0, BaseBallReferee.calculate("123", candidate).getStrikeCount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"901", "019", "902", "209", "309", "039"})
    @DisplayName("다른 자리에 같은 숫자가 있으면 볼이다 - 1")
    public void ball1(String candidate) {
        assertEquals(1, BaseBallReferee.calculate("123", candidate).getBallCount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"032", "210", "301"})
    @DisplayName("다른 자리에 같은 숫자가 있으면 볼이다 - 2")
    public void ball2(String candidate) {
        assertEquals(2, BaseBallReferee.calculate("123", candidate).getBallCount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"312", "231"})
    @DisplayName("다른 자리에 같은 숫자가 있으면 볼이다 - 3")
    public void ball3(String candidate) {
        assertEquals(3, BaseBallReferee.calculate("123", candidate).getBallCount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "023", "120", "103", "109", "029", "903"})
    @DisplayName("같은 자리에 같은 숫자가 있으면 볼이 아니다")
    public void notBall(String candidate) {
        assertEquals(0, BaseBallReferee.calculate("123", candidate).getBallCount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"456", "567", "678", "789", "890"})
    @DisplayName("같은 수가 전혀 없으면 포볼이다")
    public void fourBall(String candidate) {
        assertTrue(BaseBallReferee.calculate("123", candidate).isFourBall());
    }

    @ParameterizedTest
    @ValueSource(strings = {"184", "815", "961", "294", "724", "582", "395", "930", "853"})
    @DisplayName("같은 수가 하나라도 있으면 포볼이 아니다")
    public void notFourBall(String candidate) {
        assertFalse(BaseBallReferee.calculate("123", candidate).isFourBall());
    }
}