package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GuessResultTest {
    GuessResult threeStrikeGuessResult;
    GuessResult twoStrikeOneBallGuessResult;

    @BeforeEach
    void setUp() {
        threeStrikeGuessResult = makeGuessResult(3, 0);
        twoStrikeOneBallGuessResult = makeGuessResult(1, 2);
    }
    private GuessResult makeGuessResult(int strikeCount, int ballCount) {
        Map<MatchType, Integer> map = new HashMap<>();
        map.put(MatchType.STRIKE, strikeCount);
        map.put(MatchType.BALL, ballCount);
        MatchTypeCounts ThreeStrikeMatchCounts = new MatchTypeCounts(map);
        return new GuessResult(ThreeStrikeMatchCounts);
    }


    @Test
    @DisplayName("스트라이크 개수를 제공한다.")
    void strikeTest() {
        assertThat(threeStrikeGuessResult.getStrikeCount()).isEqualTo(3);
        assertThat(twoStrikeOneBallGuessResult.getStrikeCount()).isEqualTo(1);
    }


}