package baseball;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import custommodel.DecisionResult;
import customtypes.Decision;

public class DecisionCounterTest {

    private DecisionCounter decisionCounter;

    @BeforeEach
    void setup() {
        this.decisionCounter = new DecisionCounter();
    }

    @Test
    @DisplayName("Decision 취합 - 2 스트라이크 1 볼인 경우 스트라이크 값이 2, 볼 값이 1인 DecisionResult를 리턴")
    void countDecisions_TwoStrikesOneBall_ResultHasSameCount() {
        // given
        List<Decision> decisions = new ArrayList<Decision>();
        decisions.add(Decision.STRIKE);
        decisions.add(Decision.STRIKE);
        decisions.add(Decision.BALL);

        // when
        DecisionResult result = this.decisionCounter.countDecisions(decisions);

        // then
        Assertions.assertThat(result.getStrikeCount()).isEqualTo(2);
        Assertions.assertThat(result.getBallCount()).isEqualTo(1);
        Assertions.assertThat(result.getNothingCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("Decision 취합 - 3 스트라이크인 경우 스트라이크 값이 3인 DecisionResult를 리턴")
    void countDecisions_ThreeStrikes_ResultHasSameCount() {
        // given
        List<Decision> decisions = new ArrayList<Decision>();
        decisions.add(Decision.STRIKE);
        decisions.add(Decision.STRIKE);
        decisions.add(Decision.STRIKE);

        // when
        DecisionResult result = this.decisionCounter.countDecisions(decisions);

        // then
        Assertions.assertThat(result.getStrikeCount()).isEqualTo(3);
        Assertions.assertThat(result.getBallCount()).isEqualTo(0);
        Assertions.assertThat(result.getNothingCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("Decision 취합 - 3 볼인 경우 볼 값이 3인 DecisionResult를 리턴")
    void countDecisions_ThreeBalls_ResultHasSameCount() {
        // given
        List<Decision> decisions = new ArrayList<Decision>();
        decisions.add(Decision.BALL);
        decisions.add(Decision.BALL);
        decisions.add(Decision.BALL);

        // when
        DecisionResult result = this.decisionCounter.countDecisions(decisions);

        // then
        Assertions.assertThat(result.getStrikeCount()).isEqualTo(0);
        Assertions.assertThat(result.getBallCount()).isEqualTo(3);
        Assertions.assertThat(result.getNothingCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("Decision 취합 - 낫싱인 경우 낫싱 값이 3인 DecisionResult를 리턴")
    void countDecisions_ThreeNothings_ResultHasSameCount() {
        // given
        List<Decision> decisions = new ArrayList<Decision>();
        decisions.add(Decision.NOTHING);
        decisions.add(Decision.NOTHING);
        decisions.add(Decision.NOTHING);

        // when
        DecisionResult result = this.decisionCounter.countDecisions(decisions);

        // then
        Assertions.assertThat(result.getStrikeCount()).isEqualTo(0);
        Assertions.assertThat(result.getBallCount()).isEqualTo(0);
        Assertions.assertThat(result.getNothingCount()).isEqualTo(3);
    }
}
