package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(matchResult.getMatch().equals(target));
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
        assertTrue(matchResult.getMatch().equals(target));
    }

    @DisplayName("게임 종료 여부 판단 - 종료")
    @Test
    public void isGameComplete_success() throws Exception {
        //given
        MatchResult matchResult = new MatchResult();
        matchResult = matchResult.addMatchType(MatchType.STRIKE);
        matchResult = matchResult.addMatchType(MatchType.STRIKE);
        matchResult = matchResult.addMatchType(MatchType.STRIKE);

        //when
        boolean gameComplete = matchResult.isGameComplete();

        //then
        assertTrue(gameComplete);
    }

    @DisplayName("게임 종료 여부 판단 - 진행중")
    @Test
    public void isGameComplete_fail() throws Exception {
        //given
        MatchResult matchResult = new MatchResult();
        matchResult = matchResult.addMatchType(MatchType.STRIKE);
        matchResult = matchResult.addMatchType(MatchType.BALL);
        matchResult = matchResult.addMatchType(MatchType.BALL);

        //when
        boolean gameComplete = matchResult.isGameComplete();

        //then
        assertFalse(gameComplete);
    }

    @DisplayName("strike의 개수 확인")
    @Test
    public void getStrikeCount_success() throws Exception {
        //given
        MatchResult matchResult1 = new MatchResult();
        MatchResult matchResult2 = new MatchResult();

        //when
        matchResult1 = matchResult1.addMatchType(MatchType.STRIKE);
        matchResult2 = matchResult2.addMatchType(MatchType.STRIKE);
        matchResult2 = matchResult2.addMatchType(MatchType.STRIKE);

        //then
        assertTrue(matchResult1.getStrikeCount() == 1);
        assertTrue(matchResult2.getStrikeCount() == 2);
    }

    @DisplayName("ball 개수 확인")
    @Test
    public void getBallCount_success() throws Exception {
        //given
        MatchResult matchResult1 = new MatchResult();
        MatchResult matchResult2 = new MatchResult();

        //when
        matchResult1 = matchResult1.addMatchType(MatchType.BALL);
        matchResult2 = matchResult2.addMatchType(MatchType.BALL);
        matchResult2 = matchResult2.addMatchType(MatchType.BALL);
        matchResult2 = matchResult2.addMatchType(MatchType.BALL);

        //then
        assertTrue(matchResult1.getBallCount() == 1);
        assertTrue(matchResult2.getBallCount() == 3);
    }

    @DisplayName("nothing 개수 확인")
    @Test
    public void getNothingCount_success() throws Exception {
        //given
        MatchResult matchResult = new MatchResult();

        //when
        matchResult = matchResult.addMatchType(MatchType.NOTHING);
        matchResult = matchResult.addMatchType(MatchType.NOTHING);
        matchResult = matchResult.addMatchType(MatchType.NOTHING);

        //then
        assertTrue(matchResult.getNothingCount() == 3);
    }

}
