package baseball.game.referee;

import baseball.game.scoreBoard.ScoreBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    private Referee referee;

    @BeforeEach
    void setup() {
        referee = new Referee();
    }

    @Test
    @DisplayName("숫자값을 비교해 판정 객체를 생성 한다")
    void should_createJudgement_When_judgement_number() {

        // Given
        Referee referee = new Referee();

        // When
        ScoreBoard scoreBoard = referee.judgement("123", "123");

        // Then
        assertThat(scoreBoard).isNotNull();
    }

    @ParameterizedTest
    @DisplayName("두 숫자를 비교하여 게임 판정을 진행한다")
    @CsvSource(value = {"123:3 스트라이크", "124:2 스트라이크", "145:1 스트라이크",
            "312:3 볼", "345:1 볼", "315:2 볼", "678:낫싱"}, delimiter = ':')
    void should_hasScoringData_When_judgement(String hitterNum, String message) {

        // Given
        String pitcherNum = "123";

        // When
        ScoreBoard scoreBoard = referee.judgement(pitcherNum, hitterNum);
        // Then
        assertThat(scoreBoard.getBoard()).contains(message);
    }

}