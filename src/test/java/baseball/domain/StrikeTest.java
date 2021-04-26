package baseball.domain;

import baseball.generator.TestAnswerGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeTest {

    @DisplayName("숫자와 인덱스 모두 동일하면 strike로 판단한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,3", "1,2,4,2", "1,4,5,1", "4,5,6,0"})
    void count_strike(int firstNum, int secondNum, int thirdNum, int expectedCount) {
        // given
        Answer answer = Answer.from(new TestAnswerGenerator());
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        baseballNumbers.add(BaseballNumber.from(firstNum));
        baseballNumbers.add(BaseballNumber.from(secondNum));
        baseballNumbers.add(BaseballNumber.from(thirdNum));

        // when
        Strike strike = Strike.newInstance();
        strike.countStrike(answer, baseballNumbers);

        // then
        assertThat(strike.getCount()).isEqualTo(expectedCount);
    }

    @DisplayName("count 초기화하면 0이 된다")
    @Test
    void init_count() {
        // given
        Strike strike = Strike.newInstance();

        // when
        strike.initCount();

        // then
        assertThat(strike.getCount()).isEqualTo(0);
    }
}