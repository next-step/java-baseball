package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    @ParameterizedTest
    @CsvSource(value = {"123:123:3", "123:124:2", "123:145:1", "123:456:0"}, delimiter = ':')
    @DisplayName("입력받은 두 숫자의 스트라이크가 몇 개인지 리턴한다.")
    void calculateStrikeTest(int userNumber, int answerNumber, int expectedCountOfStrike) {
        Referee referee = new Referee(new AnswerNumber(answerNumber));
        assertThat(referee.getCountOfStrike(new UserNumber(userNumber)))
                .isEqualTo(expectedCountOfStrike);
    }

}