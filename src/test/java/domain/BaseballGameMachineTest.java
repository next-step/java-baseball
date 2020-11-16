package domain;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("숫자 야구 게임기 테스트")
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

    @DisplayName("유저의 입력에 따라 숫자 야구 게임 지속 여부의 값을 결정한다.")
    @Nested
    class GameContinueTest {

        @Test
        @DisplayName("유저가 1을 입력하면 숫자 야구 지속 여부를 true로 하고 새로운 숫자 야구 게임을 실행한다.")
        void continueTest() {
            BaseballGameMachine baseballGameMachine = BaseballGameMachine.initGame();
            BaseballGame beforeBaseballGame = baseballGameMachine.getBaseballGame();

            int userInput = 1;
            baseballGameMachine.continueGameByInput(userInput);

            assertThat(baseballGameMachine.isBaseballGameContinue()).isTrue();
            assertThat(baseballGameMachine.getBaseballGame()).isNotEqualTo(beforeBaseballGame);
        }

        @Test
        @DisplayName("유저가 2를 입력하면 숫자 야구 지속 여부를 false로 한다.")
        void stopTest() {
            BaseballGameMachine baseballGameMachine = BaseballGameMachine.initGame();
            BaseballGame beforeBaseballGame = baseballGameMachine.getBaseballGame();

            int userInput = 2;
            baseballGameMachine.continueGameByInput(userInput);

            assertThat(baseballGameMachine.isBaseballGameContinue()).isFalse();
            assertThat(baseballGameMachine.getBaseballGame()).isEqualTo(beforeBaseballGame);
        }
    }

    @Test
    @DisplayName("숫자 야구 게임 지속 여부를 제공한다.")
    void isContinueTest() {
        BaseballGameMachine baseballGameMachineContinue = new BaseballGameMachine(null, true);
        BaseballGameMachine baseballGameMachineNotContinue = new BaseballGameMachine(null, false);

        assertThat(baseballGameMachineContinue.isBaseballGameContinue()).isTrue();
        assertThat(baseballGameMachineNotContinue.isBaseballGameContinue()).isFalse();
    }
}
