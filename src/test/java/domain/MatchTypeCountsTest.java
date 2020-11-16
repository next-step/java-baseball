package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTypeCountsTest {
    private MatchTypeCounts oneStrikeOneBallMatchCounts;

    @BeforeEach
    void setUp() {
        Map<MatchType, Integer> map = new HashMap<>();
        map.put(MatchType.STRIKE, 1);
        map.put(MatchType.BALL, 1);
        map.put(MatchType.NO_MATCH, 0);
        oneStrikeOneBallMatchCounts = new MatchTypeCounts(map);
    }

    @Test
    @DisplayName("매치 타입(MatchType) 별로 `매치 카운트`를 제공한다.")
    void getCountTest() {
        assertThat(oneStrikeOneBallMatchCounts.getCountOfMatchType(MatchType.STRIKE)).isEqualTo(1);
        assertThat(oneStrikeOneBallMatchCounts.getCountOfMatchType(MatchType.BALL)).isEqualTo(1);
        assertThat(oneStrikeOneBallMatchCounts.getCountOfMatchType(MatchType.NO_MATCH)).isEqualTo(0);
    }

    @Test
    @DisplayName("입럭받은 매치 타입(MatchType) 의 `매치 카운트` 를 증가시킨다.")
    void increaseTest() {
        oneStrikeOneBallMatchCounts.increaseCount(MatchType.BALL);
        assertThat(oneStrikeOneBallMatchCounts.getCountOfMatchType(MatchType.STRIKE)).isEqualTo(1);
        assertThat(oneStrikeOneBallMatchCounts.getCountOfMatchType(MatchType.BALL)).isEqualTo(2);
        assertThat(oneStrikeOneBallMatchCounts.getCountOfMatchType(MatchType.NO_MATCH)).isEqualTo(0);
    }
}
