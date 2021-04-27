package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeJudgementTest {

    @Test
    @DisplayName("스트라이크가 해당 index에 존재하는 경우 맞춘 개수를 증가시킨다.")
    void addMatchCount() {
        StrikeJudgement judgement = new StrikeJudgement();
        JudgementCountPair result
                = judgement.addMatchCount(new Numbers("123"), new Numbers("126"), new JudgementCountPair(), 1);

        assertThat(result.retrieveCountOfStrike()).isEqualTo(1);
    }
}
