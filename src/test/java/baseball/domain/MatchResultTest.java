package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchResultTest {
    @Test
    @DisplayName("MatchResult 생성")
    void create() {
        MatchResult matchResult = new MatchResult(Arrays.asList(State.STRIKE, State.BALL));
        MatchResult newMatchResult = new MatchResult(Arrays.asList(State.STRIKE, State.BALL));
        assertThat(matchResult).isEqualTo(newMatchResult);
        assertThat(matchResult).isNotSameAs(newMatchResult);
    }

    @ParameterizedTest
    @DisplayName("MatchResult Strike 수 집계")
    @CsvSource(value = {"3,5", "5,0,", "10,1"})
    void strikeCount(int strikeCount, int ballCount) {
        MatchResult matchResult = matchResult(strikeCount, ballCount);
        assertThat(matchResult.strikeCount()).isEqualTo(strikeCount);
    }

    @ParameterizedTest
    @DisplayName("MatchResult Ball 수 집계")
    @CsvSource(value = {"3,5", "5,0,", "10,1"})
    void ballCount(int strikeCount, int ballCount) {
        MatchResult matchResult = matchResult(strikeCount, ballCount);
        assertThat(matchResult.ballCount()).isEqualTo(ballCount);
    }

    private MatchResult matchResult(int strikeCount, int ballCount) {
        List<State> states = new ArrayList<>();
        for (int i = 0; i < strikeCount; i++) {
            states.add(State.STRIKE);
        }

        for (int i = 0; i < ballCount; i++) {
            states.add(State.BALL);
        }

        return new MatchResult(states);
    }
}
