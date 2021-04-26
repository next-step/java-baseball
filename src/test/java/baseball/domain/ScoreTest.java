package baseball.domain;

import baseball.generator.TestAnswerGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {

    @DisplayName("초기화하면 strike와 ball count 0이 된다")
    @Test
    void initScore() {
        // given
        Answer answer = Answer.from(new TestAnswerGenerator());
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        baseballNumbers.add(BaseballNumber.from(1));
        baseballNumbers.add(BaseballNumber.from(3));
        baseballNumbers.add(BaseballNumber.from(2));

        // when
        Score score = Score.newInstance();
        score.countScore(answer, baseballNumbers);
        score.initScore();

        // then
        assertThat(score.getStrike()).isEqualTo(0);
        assertThat(score.getBall()).isEqualTo(0);
    }

    @DisplayName("3스트라이크 일때 모두 스트라이크인지 물어보면 true 반환, 그렇지 않을 경우 false 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,true", "1,2,4,false", "1,4,5,false", "4,5,6,false"})
    void isAllStrike(int firstNum, int secondNum, int thirdNum, boolean expected) {
        // given
        Answer answer = Answer.from(new TestAnswerGenerator());
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        baseballNumbers.add(BaseballNumber.from(firstNum));
        baseballNumbers.add(BaseballNumber.from(secondNum));
        baseballNumbers.add(BaseballNumber.from(thirdNum));

        // when
        Score score = Score.newInstance();
        score.countScore(answer, baseballNumbers);

        // then
        assertThat(score.isAllStrike()).isEqualTo(expected);
    }

    @DisplayName("0스트라이크 0볼일때 nothing 인지 물어보면 true 반환, 그렇지 않을 경우 false 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"4,5,6,true", "1,2,3,false", "1,4,5,false", "3,4,5,false"})
    void isNothing(int firstNum, int secondNum, int thirdNum, boolean expected) {
        // given
        Answer answer = Answer.from(new TestAnswerGenerator());
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        baseballNumbers.add(BaseballNumber.from(firstNum));
        baseballNumbers.add(BaseballNumber.from(secondNum));
        baseballNumbers.add(BaseballNumber.from(thirdNum));

        // when
        Score score = Score.newInstance();
        score.countScore(answer, baseballNumbers);

        // then
        assertThat(score.isNothing()).isEqualTo(expected);
    }
}
