package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;

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

    @Test
    @DisplayName("볼 개수를 제공한다.")
    void ballTest() {
        assertThat(threeStrikeGuessResult.getBallCount()).isEqualTo(0);
        assertThat(twoStrikeOneBallGuessResult.getBallCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("3 스트라이크 여부를 제공한다.")
    void threeStrikeTest() {
        assertThat(threeStrikeGuessResult.isThreeStrike()).isTrue();
        assertThat(twoStrikeOneBallGuessResult.isThreeStrike()).isFalse();
    }

    @Test
    @DisplayName("낫띵 여부를 제공한다.")
    void testNothing() {
        GuessResult nothingGuessResult = makeGuessResult(0, 0);
        assertThat(threeStrikeGuessResult.isNothing()).isFalse();
        assertThat(twoStrikeOneBallGuessResult.isNothing()).isFalse();
        assertThat(nothingGuessResult.isNothing()).isTrue();
    }

    @Test
    @DisplayName("입력 받은 매치 타입(MatchType) 의 `매치 카운트`를 증가시킨다.")
    void increaseTest() {
        GuessResult init = GuessResult.init();
        init.increaseMatchCount(MatchType.STRIKE);

        assertThat(init.getStrikeCount()).isEqualTo(1);

        init.increaseMatchCount(MatchType.STRIKE);
        assertThat(init.getStrikeCount()).isEqualTo(2);

        init.increaseMatchCount(MatchType.BALL);
        assertThat(init.getStrikeCount()).isEqualTo(2);
        assertThat(init.getBallCount()).isEqualTo(1);
    }
}
