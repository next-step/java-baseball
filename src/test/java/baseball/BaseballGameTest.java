package baseball;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import customtypes.GameResult;

public class BaseballGameTest {

    private BaseballReferee baseballReferee;
    private RandomGenerator randomGenerator;

    private BaseballGame baseballGame;

    @BeforeEach
    void setup() {
        this.baseballReferee = new BaseballReferee();
        this.randomGenerator = mock(RandomGenerator.class);
    }

    @Test
    @DisplayName("경기 진행 - 사용자가 모든 숫자를 맞춘 경우")
    void play_returnsWin_playerInsertThreeStrikes() {
        // given
        String playerInput = "123";
        when(this.randomGenerator.getRandomDigits(3)).thenReturn(playerInput);
        this.baseballGame = new BaseballGame(this.baseballReferee, this.randomGenerator);

        // when
        GameResult gameResult = this.baseballGame.play(playerInput);

        // then
        Assertions.assertThat(gameResult).isEqualTo(GameResult.WIN);
    }

    @ParameterizedTest
    @CsvSource(value = {"134", "234", "423", "125", "456", "789"})
    @DisplayName("경기 진행 - 사용자가 3개 숫자 모두를 맞추지 못한 경우")
    void play_returnsLose_playerNotInsertThreeStrikes(String playerInput){
        // given
        when(this.randomGenerator.getRandomDigits(3)).thenReturn("123");
        this.baseballGame = new BaseballGame(this.baseballReferee, this.randomGenerator);

        // when
        GameResult gameResult = this.baseballGame.play(playerInput);

        // then
        Assertions.assertThat(gameResult).isEqualTo(GameResult.LOSE);
    }

    @ParameterizedTest
    @CsvSource(value = {"!df", "34", "$$$", "4125", "45698354", "aa789"})
    @DisplayName("경기 진행 - 사용자가 유효하지 않은 값을 입력한 경우")
    void play_returnsInvalidInput_playerInsertInvalidInput(String playerInput){
        // given
        this.baseballGame = new BaseballGame(this.baseballReferee, this.randomGenerator);

        // when
        GameResult gameResult = this.baseballGame.play(playerInput);

        // then
        Assertions.assertThat(gameResult).isEqualTo(GameResult.INVALID_INPUT);
    }
}
