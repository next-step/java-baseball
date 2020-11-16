package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ResultGameTest {
    private ResultGame resultGame;

    @BeforeEach
    void setup() {
        resultGame = new ResultGame();
    }

    @DisplayName("STRIKE, BALL, NOTHING 생길 때마다 기존 해당 count에 1을 더한다.")
    @Test
    void add() {
        resultGame.add(Score.STRIKE);
        resultGame.add(Score.STRIKE);
        resultGame.add(Score.BALL);

        assertThat(resultGame.count(Score.STRIKE)).isEqualTo(2);
        assertThat(resultGame.count(Score.BALL)).isEqualTo(1);
    }

    @DisplayName("STRIKE 개수가 3개일 경우, 3 스트라이크이므로 true 리턴.")
    @ParameterizedTest
    @CsvSource(value = {"3:true"}, delimiter = ':')
    void isAllStrike(int count, boolean expected) {
        for (int i = 0; i < count; i++) {
            resultGame.add(Score.STRIKE);
        }
        assertThat(resultGame.isAllStrike()).isEqualTo(expected);
    }

    @DisplayName("STRIKE 또는 BALL 개수가 1개라도 있을 경우, 낫싱이 아니므로 false 리턴.")
    @Test
    void isNothing_FALSE() {
        resultGame.add(Score.STRIKE);
        assertThat(resultGame.isNothing()).isEqualTo(false);
    }

    @DisplayName("STRIKE, BALL 개수가 모두 0개일 경우, 낫싱이므로 true 리턴.")
    @Test
    void isNothing_TRUE() {
        assertThat(resultGame.isNothing()).isEqualTo(true);
    }
}
