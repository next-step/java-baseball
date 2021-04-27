package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallJudgementTest {
    @Test
    @DisplayName("볼이 해당 index에 존재하는 경우 맞춘 개수를 증가시킨다.")
    void addMatchCount() {
        BallJudgement judgement = new BallJudgement();
        JudgementCountPair result
                = judgement.addMatchCount(new Numbers("784"), new Numbers("847"), new JudgementCountPair(), 1);

        assertThat(result.retrieveCountOfBall()).isEqualTo(1);
    }
}
