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
    @CsvSource(value = {"248:낫싱", "378:낫싱", "246:낫싱", "134:1 스트라이크", "589:1 스트라이크"}, delimiter = ':')
    void all_numbers_mismatch(String input, String expected) {
        BaseBallGame baseBallGame = new BaseBallGame(new RandomNumberGeneratorStub("159"));
        String message = baseBallGame.guess(input);
        assertThat(message).isEqualTo(expected);
    }

    @DisplayName("같은 수가 같은 자리에 있으면 스트라이크를 출력하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"367:2 스트라이크", "123:낫싱", "346:1 스트라이크"}, delimiter = ':')
    void match_index_and_number(String input, String expected) {
        BaseBallGame baseBallGame = new BaseBallGame(new RandomNumberGeneratorStub("369"));
        String message = baseBallGame.guess(input);
        assertThat(message).isEqualTo(expected);
    }

    @DisplayName("스트라이크 카운트를 출력하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"127:2 스트라이크", "124:1 스트라이크"}, delimiter = ':')
    void match_index_and_number_return_message(String input, String expected) {
        BaseBallGame baseBallGame = new BaseBallGame(new RandomNumberGeneratorStub("137"));
        String message = baseBallGame.guess(input);
        assertThat(message).isEqualTo(expected);
    }

    @DisplayName("3 스트라이크일 경우 게임이 종료되는지 테스트")
    @Test
    void game_end_when_three_strike() {
        BaseBallGame baseBallGame = new BaseBallGame(new RandomNumberGeneratorStub("369"));
        baseBallGame.guess("369");
        assertThat(baseBallGame.isCompleted()).isTrue();
        BaseBallGame baseBallGame2 = new BaseBallGame(new RandomNumberGeneratorStub("369"));
        baseBallGame.guess("362");
        assertThat(baseBallGame.isCompleted()).isFalse();
    }
}