package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
        assertThat(matchResult.hashCode()).isEqualTo(newMatchResult.hashCode());
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

    @Test
    @DisplayName("스트라이크가 3개면 끝난 게임이다.")
    void finish() {
        MatchResult matchResult = matchResult(3, 0);
        assertThat(matchResult.isFinish()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("스트라이크가 3개가 아니면 끝난 게임이 아니다.")
    void notFinish(int strikeCount) {
        MatchResult matchResult = matchResult(strikeCount, 0);
        assertThat(matchResult.isFinish()).isFalse();
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
