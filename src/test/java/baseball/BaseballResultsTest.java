package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballResultsTest {

    @Test
    void 투구_결과_테스트() {
        //given
        final int EXPECTED_STRIKE_COUNT = 2;
        final int EXPECTED_BALL_COUNT = 1;
        final int EXPECTED_NOTHING_COUNT = 0;
        List<Pitching> pitchings = List.of(
                Pitching.STRIKE,
                Pitching.BALL,
                Pitching.STRIKE
        );
        BaseballResults baseballResults = new BaseballResults();

        //when
        for (Pitching pitching : pitchings) {
            baseballResults.addResult(pitching);
        }

        //then
        assertEquals(EXPECTED_STRIKE_COUNT, baseballResults.getCount(Pitching.STRIKE));
        assertEquals(EXPECTED_BALL_COUNT, baseballResults.getCount(Pitching.BALL));
        assertEquals(EXPECTED_NOTHING_COUNT, baseballResults.getCount(Pitching.NOTHING));
    }

    @Test
    void 정답_테스트() {
        //given
        BaseballResults baseballResults = new BaseballResults();

        //when
        baseballResults.addResult(Pitching.STRIKE);
        baseballResults.addResult(Pitching.STRIKE);
        baseballResults.addResult(Pitching.STRIKE);

        //then
        assertTrue(baseballResults.isAnswer());
    }

    @Test
    void 스트라이크1_볼2() {
        //given
        final String EXPECTED_STRING = "1스트라이크 2볼";
        BaseballResults baseballResults = new BaseballResults();

        //when
        baseballResults.addResult(Pitching.STRIKE);
        baseballResults.addResult(Pitching.BALL);
        baseballResults.addResult(Pitching.BALL);

        //then
        assertEquals(EXPECTED_STRING, baseballResults.toString());
    }

    @Test
    void 스트라이크2_볼1() {
        //given
        final String EXPECTED_STRING = "2스트라이크 1볼";
        BaseballResults baseballResults = new BaseballResults();

        //when
        baseballResults.addResult(Pitching.STRIKE);
        baseballResults.addResult(Pitching.STRIKE);
        baseballResults.addResult(Pitching.BALL);

        //then
        assertEquals(EXPECTED_STRING, baseballResults.toString());
    }

    @Test
    void 볼3() {
        //given
        final String EXPECTED_STRING = "3볼";
        BaseballResults baseballResults = new BaseballResults();

        //when
        baseballResults.addResult(Pitching.BALL);
        baseballResults.addResult(Pitching.BALL);
        baseballResults.addResult(Pitching.BALL);

        //then
        assertEquals(EXPECTED_STRING, baseballResults.toString());
    }

    @Test
    void 낫싱() {
        //given
        final String EXPECTED_STRING = "낫싱";
        BaseballResults baseballResults = new BaseballResults();

        //when
        baseballResults.addResult(Pitching.NOTHING);
        baseballResults.addResult(Pitching.NOTHING);
        baseballResults.addResult(Pitching.NOTHING);

        //then
        assertEquals(EXPECTED_STRING, baseballResults.toString());
    }
}