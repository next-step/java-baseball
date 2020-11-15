package baseballgame;

import org.assertj.core.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseballGameTest {

    BaseballGame baseballGame = new BaseballGame();

    @DisplayName("초기화 후 게임 넘버 validation 체크")
    @Test
    void gameNumberCheckIsAllNumber() {
        baseballGame.initGame();
        String gameNumber = baseballGame.getBaseballNumber();
        Assertions.assertThat(gameNumber).isNotEmpty();
        Assertions.assertThat(gameNumber.length()).isEqualTo(3);
        for (char c : gameNumber.toCharArray()) {
            assertTrue(Character.isDigit(c));
        }
    }

    @DisplayName("랜덤 숫자 문자열 생성")
    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "10"})
    void getRandomNumberString(int size) {
        String gameNumber = baseballGame.getRandomNumberString(size);
        Assertions.assertThat(gameNumber.length()).isEqualTo(size);
        for (char c : gameNumber.toCharArray()) {
            assertTrue(Character.isDigit(c));
        }
    }

    @DisplayName("스트라이크 아웃 체크")
    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:true", "4:false"}, delimiter = ':')
    void isStrikeOut(int strikeCount, boolean expect) {
        assertEquals(expect, baseballGame.isStrikeOut(strikeCount));
    }
}
