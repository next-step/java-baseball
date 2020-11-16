package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    @Test
    @DisplayName("게임의 정답이 같다면 두 게임은 동일한 게임이다.")
    void equalTest() {
        GameNumber answer = makeAnswer();
        BaseballGame baseballGame = new BaseballGame(answer);
        BaseballGame baseballGame2 = new BaseballGame(answer);
        assertThat(baseballGame).isEqualTo(baseballGame2);
    }

    @Test
    @DisplayName("게임을 새로 시작한다 > 랜덤한 게임 숫자(GameNumber) 를 `정답`으로 가진 숫자 야구 게임(BaseballGame) 을 제공한다.")
    void createGameTest() {
        BaseballGame baseballGame = new BaseballGame(makeAnswer());
        BaseballGame newGame = BaseballGame.startNewGame();

        assertThat(baseballGame).isNotEqualTo(newGame);
    }

    @ParameterizedTest
    @CsvSource(value = {"012:3:0", "021:1:2", "201:0:3", "789:0:0"}, delimiter = ':')
    @DisplayName("(정답이 012 인 케이스) 유저가 입력한 게임 숫자(GameNumber) 를 받아 정답 추측 결과(GuessResult) 를 제공한다.")
    void getGuessResultTest(String userGameNumberRaw, int strikeCount, int ballCount) {
        BaseballGame baseballGame = new BaseballGame(makeAnswer());
        GameNumber userGameNumber = GameNumber.ofByRaw(userGameNumberRaw);
        GuessResult expectedResult = makeGuessResult(strikeCount, ballCount);

        GuessResult guessResult = baseballGame.getGuessResult(userGameNumber);

        assertThat(guessResult).isEqualTo(expectedResult);
    }

    private GameNumber makeAnswer() {
        List<GameDigit> gameDigits = new ArrayList<>();
        gameDigits.add(new GameDigit(0));
        gameDigits.add(new GameDigit(1));
        gameDigits.add(new GameDigit(2));
        return new GameNumber(gameDigits);
    }

    private GuessResult makeGuessResult(int strikeCount, int ballCount) {
        GuessResult expectedResult = GuessResult.init();
        for (int i = 0; i < strikeCount; i++) {
            expectedResult.increaseMatchCount(MatchType.STRIKE);
        }
        for (int i = 0; i < ballCount; i++) {
            expectedResult.increaseMatchCount(MatchType.BALL);
        }
        return expectedResult;
    }
}
