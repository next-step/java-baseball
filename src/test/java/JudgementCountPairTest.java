import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class JudgementCountPairTest {

    @ParameterizedTest
    @CsvSource({
            "STRIKE, 1",
            "BALL, 1"
    })
    @DisplayName("판정 개수를 한개 증가시킨다.")
    void putJudgement(Judgements judgement, int expectedCount) {
        JudgementCountPair pair = new JudgementCountPair();
        JudgementCountPair addedPair = pair.putJudgement(judgement);

        assertThat(addedPair.get(judgement)).isEqualTo(expectedCount);
    }
}
