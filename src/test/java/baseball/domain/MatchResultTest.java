package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class MatchResultTest {

    @DisplayName("매칭 결과 생성자")
    @Test
    public void constructor_success() throws Exception {
        //given
        Map<MatchType, Integer> target = new HashMap<>();
        target.put(MatchType.STRIKE, 0);
        target.put(MatchType.BALL, 0);
        target.put(MatchType.NOTHING, 0);

        //when
        MatchResult matchResult = new MatchResult();

        //then
        Assertions.assertTrue(matchResult.getMatch().equals(target));
    }

    @DisplayName("매칭 결과 더하기")
    @Test
    public void addMatchType_success() throws Exception {
        //given
        Map<MatchType, Integer> target = new HashMap<>();
        target.put(MatchType.STRIKE, 2);
        target.put(MatchType.BALL, 1);
        target.put(MatchType.NOTHING, 0);

        //when
        MatchResult matchResult = new MatchResult();
        matchResult = matchResult.addMatchType(MatchType.STRIKE);
        matchResult = matchResult.addMatchType(MatchType.STRIKE);
        matchResult = matchResult.addMatchType(MatchType.BALL);

        //then
        Assertions.assertTrue(matchResult.getMatch().equals(target));
    }

}
