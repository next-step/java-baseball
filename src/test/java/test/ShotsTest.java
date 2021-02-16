package test;

import baseball.model.AnswerNumbers;
import baseball.model.shot.Shot;
import baseball.model.shot.Shots;
import baseball.model.strategy.LinearStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ShotsTest {
    @Test
    @DisplayName("3스트라이크가 들어왔을 때, 3스트라이크가 출력되는 테스트 추가")
    void getShotsStrikeTest() {
        final LinearStrategy linearStrategy = new LinearStrategy();
        final AnswerNumbers answerNumbers = new AnswerNumbers(linearStrategy);
        final Shots shots = new Shots("1,2,3", answerNumbers);

        assertThat(shots.getShots()).isEqualTo(new ArrayList<>(
                Arrays.asList(Shot.STRIKE, Shot.STRIKE, Shot.STRIKE)
        ));
    }

    @Test
    @DisplayName("3ball이 들어왔을 때, 3ball이 출력되는 테스트 추가")
    void getShotsBallTest() {
        final LinearStrategy linearStrategy = new LinearStrategy();
        final AnswerNumbers answerNumbers = new AnswerNumbers(linearStrategy);
        final Shots shots = new Shots("3,1,2", answerNumbers);

        assertThat(shots.getShots()).isEqualTo(new ArrayList<>(
                Arrays.asList(Shot.BALL, Shot.BALL, Shot.BALL)
        ));
    }
}