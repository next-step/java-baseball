package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {

    @DisplayName("숫자 생성 후 저장 테스트")
    @Test
    void generateNumbers() {
        Numbers input = Numbers.valueOf(1,2,3);
        Computer computer = new Computer(input);
        Numbers result = computer.getNumbers();

        assertThat(input).isEqualTo(result);
    }

    @DisplayName("사용자가 맞추려는 번호 매칭 메소드 테스트 -스트라이크 숫자")
    @ParameterizedTest
    @CsvSource(value = {"123:123:3", "365:345:2", "968:458:1"}, delimiter = ':')
    void matches_strike(String input, String expected, int strikeCount) {
        Computer computer = new Computer(Numbers.valueOf(input));
        Result result = computer.matches(Numbers.valueOf(expected));

        int strike = result.getStrikeCount();
        assertThat(strike).isEqualTo(strikeCount);
    }

    @DisplayName("사용자가 맞추려는 번호 매칭 메소드 테스트 -볼 숫자")
    @ParameterizedTest
    @CsvSource(value = {"123:341:2", "426:264:3", "967:378:1", "567:891:0"}, delimiter = ':')
    void matches_ball(String input, String expected, int ballCount) {
        Computer computer = new Computer(Numbers.valueOf(input));
        Result result = computer.matches(Numbers.valueOf(expected));

        int ball = result.getBallCount();
        assertThat(ball).isEqualTo(ballCount);
    }

    @DisplayName("사용자가 맞추려는 번호 매칭 메소드 테스트 -아무것도 포함 안되었을 때")
    @Test
    void contains() {
        Numbers input = Numbers.valueOf(1,2,3);
        Computer computer = new Computer(input);

        Numbers userNumbers = Numbers.valueOf(4,5,6);
        Result result = computer.matches(userNumbers);

        assertThat(result.isNothing()).isTrue();
    }
}
