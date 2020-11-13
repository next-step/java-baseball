package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static baseball.domain.TrialResult.FINISH_MESSAGE;
import static baseball.domain.TrialResult.NOTHING_MESSAGE;
import static baseball.validator.TrialResultValidator.INVALID_TRIAL_RESULT_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrialResultTest {

    @DisplayName("toString() - NOTHING 케이스")
    @Test
    void toStringForNothing() {
        TrialResult trialResult = new TrialResult(0, 0);

        assertThat(trialResult.toString()).isEqualTo(NOTHING_MESSAGE);
    }

    @DisplayName("toString() - FINISH 케이스")
    @Test
    void toStringForFinish() {
        int strikeCount = 3;

        TrialResult trialResult = new TrialResult(strikeCount, 0);

        assertThat(trialResult.toString()).isEqualTo(strikeCount + FINISH_MESSAGE);
    }

    @DisplayName("toString() - 잘못된 결과 케이스")
    @ParameterizedTest(name = "({index}) {displayName} number={0}, index={1}")
    @CsvSource({"4, 0", "3, 1", "3, 2", "3, 3", "1, 3", "2, 3", "3, 3", "0, 4"})
    void toStringForInvalidCases(int strikeCount, int ballCount) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new TrialResult(strikeCount, ballCount));

        assertThat(exception.getMessage()).isEqualTo(INVALID_TRIAL_RESULT_MESSAGE);
    }


    @DisplayName("toString() - Strike 나 Ball 이 존재하는 케이스")
    @ParameterizedTest(name = "({index}) {displayName} number={0}, index={1}")
    @CsvSource({"0, 1", "0, 2", "0, 3", "1, 0", "1, 1", "1, 2", "2, 0", "2, 1"})
    void toString(int strikeCount, int ballCount) {
        TrialResult trialResult = new TrialResult(strikeCount, ballCount);

        assertThat(trialResult.toString()).isEqualTo(trialResult.getMatchedResultString());
    }
}