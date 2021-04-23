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
    @CsvSource(value = {"248:낫싱", "378:낫싱", "246:낫싱", "134:알수없음", "589:알수없음"}, delimiter = ':')
    void all_numbers_mismatch(String input, String expected) {
        BaseBallGame baseBallGame = new BaseBallGame(new RandomNumberGeneratorStub(new int[]{1, 5, 9}));
        String message = baseBallGame.guess(input);
        assertThat(message).isEqualTo(expected);
    }
}