package baseball.game.referee;

import baseball.game.scoreBoard.ScoreBoard;
import baseball.ui.impl.TestUiSystem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreBoardTest {

    private final TestUiSystem uiSystem = new TestUiSystem();

    @ParameterizedTest
    @DisplayName("게임 종료 판정을 할 수 있다")
    @CsvSource(value = {"score1:true", "score2:false"}, delimiter = ':')
    void should_checkGameOver_When_createScoreBard(String score, boolean gameOver) {

        // When
        ScoreBoard scoreBoard = new ScoreBoard(score, gameOver);

        // Then
        assertThat(scoreBoard.getBoard()).isEqualTo(score);
        assertThat(scoreBoard.isGameOver()).isEqualTo(gameOver);

    }

    @Test
    @DisplayName("스코어링 데이터를 Ui 시스템에 출력할 수 있다")
    void should_printUi_When_displayScoring() {

        // Given
        String scoring = "score";

        // When
        ScoreBoard scoreBoard = new ScoreBoard(scoring, false);
        scoreBoard.display(uiSystem);

        // Then
        assertThat(scoreBoard.getBoard()).isEqualTo(scoring);
        assertThat(uiSystem.getDisplayData()).contains("[Judge]");
    }

}