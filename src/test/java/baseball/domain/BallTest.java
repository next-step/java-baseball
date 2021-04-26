package baseball.domain;

import baseball.generator.TestAnswerGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    @DisplayName("인덱스는 불일치, 숫자는 동일하면 ball로 판단한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,0", "1,3,4,1", "1,3,2,2", "3,1,2,3"})
    void count_strike(int firstNum, int secondNum, int thirdNum, int expectedCount) {
        // given
        Answer answer = Answer.from(new TestAnswerGenerator());
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        baseballNumbers.add(BaseballNumber.from(firstNum));
        baseballNumbers.add(BaseballNumber.from(secondNum));
        baseballNumbers.add(BaseballNumber.from(thirdNum));

        // when
        Ball ball = Ball.newInstance();
        ball.countBall(answer, baseballNumbers);

        // then
        assertThat(ball.getCount()).isEqualTo(expectedCount);
    }

    @DisplayName("count 초기화하면 0이 된다")
    @Test
    void init_count() {
        // given
        Ball ball = Ball.newInstance();

        // when
        ball.initCount();

        // then
        assertThat(ball.getCount()).isEqualTo(0);
    }

    @DisplayName("0볼 일때 nothing 인지 물어보면 true를 반환, 그렇지 않을 경우 false를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,true", "1,3,4,false", "1,3,2,false", "3,1,2,false"})
    void isNothing(int firstNum, int secondNum, int thirdNum, boolean expected) {
        // given
        Answer answer = Answer.from(new TestAnswerGenerator());
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        baseballNumbers.add(BaseballNumber.from(firstNum));
        baseballNumbers.add(BaseballNumber.from(secondNum));
        baseballNumbers.add(BaseballNumber.from(thirdNum));

        // when
        Ball ball = Ball.newInstance();
        ball.countBall(answer, baseballNumbers);

        // then
        assertThat(ball.isNothing()).isEqualTo(expected);
    }
}
