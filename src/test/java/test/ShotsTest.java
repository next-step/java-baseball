package test;

import baseball.model.AnswerNumbers;
import baseball.model.InningResult;
import baseball.model.shot.Shots;
import baseball.model.strategy.LinearStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShotsTest {
    @Test
    @DisplayName("3스트라이크가 들어왔을 때, 3스트라이크가 출력되는 테스트 추가")
    void getShotsStrikeTest() {
        final LinearStrategy linearStrategy = new LinearStrategy();
        final AnswerNumbers answerNumbers = new AnswerNumbers(linearStrategy);
        final Shots shots = new Shots(answerNumbers);

        final InningResult inningResult = shots.makeResult("1,2,3");

        assertThat(inningResult.getMessage()).isEqualTo("3스트라이크 ");
    }

    @Test
    @DisplayName("3ball이 들어왔을 때, 3ball이 출력되는 테스트 추가")
    void getShotsBallTest() {
        final LinearStrategy linearStrategy = new LinearStrategy();
        final AnswerNumbers answerNumbers = new AnswerNumbers(linearStrategy);
        final Shots shots = new Shots(answerNumbers);

        final InningResult inningResult = shots.makeResult("3,1,2");

        assertThat(inningResult.getMessage()).isEqualTo("3볼 ");
    }
}