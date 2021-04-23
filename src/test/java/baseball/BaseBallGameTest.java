package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.RandomNumberGeneratorStub;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallGameTest {

    @DisplayName("정답과 같은 수가 전혀 없는 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"248:낫싱", "378:낫싱", "246:낫싱"}, delimiter = ':')
    void all_numbers_mismatch(String input, String expected) {
        BaseBallGame baseBallGame = new BaseBallGame(new RandomNumberGeneratorStub("159"));
        inputExpected(baseBallGame.guess(input), expected);
    }

    @DisplayName("자리수와 값이 일치하는 경우 스트라이크 카운트를 출력하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"127:2 스트라이크", "124:1 스트라이크"}, delimiter = ':')
    void match_index_and_number_return_message(String input, String expected) {
        BaseBallGame baseBallGame = new BaseBallGame(new RandomNumberGeneratorStub("137"));
        inputExpected(baseBallGame.guess(input), expected);
    }

    @DisplayName("3 스트라이크일 경우 게임이 종료되는지 테스트")
    @Test
    void game_end_when_three_strike() {
        BaseBallGame baseBallGame = new BaseBallGame(new RandomNumberGeneratorStub("369"));
        baseBallGame.guess("369");
        assertThat(baseBallGame.isCompleted()).isTrue();
        BaseBallGame baseBallGame2 = new BaseBallGame(new RandomNumberGeneratorStub("369"));
        baseBallGame.guess("362");
        assertThat(baseBallGame2.isCompleted()).isFalse();
    }

    @DisplayName("자리수와 상관없이 정답과 숫자가 일치하면 볼 카운트를 출력하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"137:3 볼", "372:2 볼"}, delimiter = ':')
    void match_number_count(String input, String expected) {
        BaseBallGame baseBallGame = new BaseBallGame(new RandomNumberGeneratorStub("713"));
        inputExpected(baseBallGame.guess(input), expected);
    }

    @DisplayName("볼과 스트라이크가 같이 있을 경우 모두 출력하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"137:1 스트라이크 2 볼", "372:1 스트라이크 1 볼", "127:1 스트라이크 1 볼", "973:2 스트라이크"}, delimiter = ':')
    void strike_ball_mixed_match(String input, String expected) {
        BaseBallGame baseBallGame = new BaseBallGame(new RandomNumberGeneratorStub("173"));
        inputExpected(baseBallGame.guess(input), expected);
    }

    private void inputExpected(String input, String expected) {
        assertThat(input).isEqualTo(expected);
    }
}