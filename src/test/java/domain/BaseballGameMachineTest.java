package domain;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameMachineTest {
    @Test
    @DisplayName("게임 지속 여부가 참이고, `정답`을 가지고 있는 숫자 야구 게임을 시작한다.")
    void gameStartTest() {
        BaseballGameMachine baseballGameMachine = BaseballGameMachine.initGame();

        assertThat(baseballGameMachine).extracting("baseballGame")
                .isNotNull();
        assertThat(baseballGameMachine).extracting("baseballGame")
                .extracting("answer")
                .isNotNull();
        assertThat(baseballGameMachine.isBaseballGameContinue()).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"012:3:0", "021:1:2", "201:0:3", "789:0:0"}, delimiter = ':')
    @DisplayName("유저가 입력한 게임 숫자(GameNumber) 를 받아 추측 결과(GuessResult) 를 반환한다.")
    void guessTest(String userGameNumberRaw, int strikeCount, int ballCount) {
        BaseballGameMachine baseballGameMachine = makeBaseballGameMachine();
        GuessResult expectedResult = makeGuessResult(strikeCount, ballCount);
        GameNumber userNumber = GameNumber.ofByRaw(userGameNumberRaw);

        GuessResult guessResult = baseballGameMachine.getGuessResult(userNumber);

        assertThat(guessResult).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:0:false", "1:2:true", "0:3:true", "0:0:true"}, delimiter = ':')
    @DisplayName("추측 결과(GuessResult) 에 따라 `추측` 을 계속할지 말지 여부를 제공한다.")
    void guessContinueTest(int strikeCount, int ballCount, boolean expectedContinueGuess) {
        BaseballGameMachine baseballGameMachine = BaseballGameMachine.initGame();
        GuessResult guessResult = makeGuessResult(strikeCount, ballCount);
        boolean continueGuess = baseballGameMachine.isContinueGuess(guessResult);

        assertThat(continueGuess).isEqualTo(expectedContinueGuess);
    }

    private BaseballGameMachine makeBaseballGameMachine() {
        List<GameDigit> gameDigits = new ArrayList<>();
        gameDigits.add(new GameDigit(0));
        gameDigits.add(new GameDigit(1));
        gameDigits.add(new GameDigit(2));
        GameNumber answer = new GameNumber(gameDigits);
        BaseballGame baseballGame = new BaseballGame(answer);
        return new BaseballGameMachine(baseballGame, true);
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
