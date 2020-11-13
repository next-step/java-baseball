package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    @ParameterizedTest
    @CsvSource(value = {"123:123:3", "123:124:2", "123:145:1", "123:456:0"}, delimiter = ':')
    @DisplayName("입력받은 숫자의 스트라이크 개수를 반환한다.")
    void calculateStrikeTest(int userNumber, int answerNumber, int expectedCount) {
        Referee referee = new Referee(new AnswerNumber(answerNumber));
        assertThat(referee.getCountOfStrike(new UserNumber(userNumber)))
                .isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:312:3", "123:341:2", "123:345:1", "123:456:0"}, delimiter = ':')
    @DisplayName("입력받은 숫자의 볼 개수를 반환한다.")
    void calculateBallTest(int userNumber, int answerNumber, int expectedCount) {
        Referee referee = new Referee(new AnswerNumber(answerNumber));
        assertThat(referee.getCountOfBall(new UserNumber(userNumber)))
                .isEqualTo(expectedCount);
    }
}
