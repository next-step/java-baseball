package baseball.domain;

import baseball.domain.strategy.BallGenerateStrategy;
import baseball.domain.strategy.RandomNumberGenerateStrategy;
import baseball.domain.strategy.RandomNumberStrategy;
import baseball.domain.strategy.ThreeBallGenerateStrategy;
import baseball.exception.BallException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreeBallTest {

    private ThreeBall threeBall =
            new ThreeBall(() -> new ArrayList<>(Arrays.asList(1, 2, 3)));

    @DisplayName("게임용 공 정상 생성")
    @Test
    public void constructor_success() throws Exception {
        //given
        RandomNumberStrategy numberStrategy = new RandomNumberGenerateStrategy();
        BallGenerateStrategy ballStrategy = new ThreeBallGenerateStrategy(numberStrategy);

        //when
        new ThreeBall(ballStrategy);
    }

    @DisplayName("전략주입-list 전달 생성자의 결과 비교")
    @Test
    public void constructor_compare_success() throws Exception {
        //when
        ThreeBall threeBall2 = new ThreeBall(Arrays.asList(1, 2, 3));

        //then
        assertTrue(threeBall.equals(threeBall2));
    }

    @DisplayName("공 생성 전략 - 주입 테스트")
    @Test
    public void strategy_fail() throws Exception {
        //then
        assertThatThrownBy(
                () -> new ThreeBall(new ArrayList<>())
        ).isInstanceOf(BallException.class)
                .hasMessage("공의 사이즈가 3개가 되어야 합니다.");
    }

    @DisplayName("공의 개수가 3개인지 validate")
    @Test
    public void ball_size_fail() throws Exception {
        //given
        BallGenerateStrategy generator = () -> new ArrayList<>(Arrays.asList(1, 2));

        //then
        assertThatThrownBy(
                () -> new ThreeBall(generator)
        ).isInstanceOf(BallException.class)
                .hasMessage("공의 사이즈가 3개가 되어야 합니다.");
    }

    @DisplayName("공 번호를 비교하고 결과 반환 - 3 strike")
    @Test
    public void compareAll1_3strike_success() throws Exception {
        //given
        BallGenerateStrategy generator2 = () -> new ArrayList<>(Arrays.asList(1, 2, 3));
        ThreeBall balls = new ThreeBall(generator2);

        Map<MatchType, Integer> target = new HashMap<>();
        target.put(MatchType.STRIKE, 3);
        target.put(MatchType.BALL, 0);
        target.put(MatchType.NOTHING, 0);

        //when
        MatchResult result = threeBall.compareAll(balls);

        //then
        assertTrue(result.getMatch().equals(target));
    }

    @DisplayName("공 번호를 비교하고 결과 반환 - 2 strike, 1 nothing")
    @Test
    public void compareAll_2strike_success() throws Exception {
        //given
        BallGenerateStrategy generator1 = () -> new ArrayList<>(Arrays.asList(1, 2, 4));
        ThreeBall balls1 = new ThreeBall(generator1);

        BallGenerateStrategy generator2 = () -> new ArrayList<>(Arrays.asList(1, 9, 3));
        ThreeBall balls2 = new ThreeBall(generator2);

        Map<MatchType, Integer> target = new HashMap<>();
        target.put(MatchType.STRIKE, 2);
        target.put(MatchType.BALL, 0);
        target.put(MatchType.NOTHING, 1);

        //when
        MatchResult result1 = threeBall.compareAll(balls1);
        MatchResult result2 = threeBall.compareAll(balls2);

        //then
        assertTrue(result1.getMatch().equals(target));
        assertTrue(result2.getMatch().equals(target));
    }

    @DisplayName("공 번호를 비교하고 결과 반환 - 1 strike, 1 ball, 1 nothing")
    @Test
    public void compareAll_1strike_success() throws Exception {
        //given
        BallGenerateStrategy generator1 = () -> new ArrayList<>(Arrays.asList(2, 4, 3));
        ThreeBall balls1 = new ThreeBall(generator1);

        BallGenerateStrategy generator2 = () -> new ArrayList<>(Arrays.asList(1, 6, 2));
        ThreeBall balls2 = new ThreeBall(generator2);

        Map<MatchType, Integer> target = new HashMap<>();
        target.put(MatchType.STRIKE, 1);
        target.put(MatchType.BALL, 1);
        target.put(MatchType.NOTHING, 1);

        //when
        MatchResult result1 = threeBall.compareAll(balls1);
        MatchResult result2 = threeBall.compareAll(balls2);

        //then
        assertTrue(result1.getMatch().equals(target));
        assertTrue(result2.getMatch().equals(target));
    }

    @DisplayName("공 번호를 비교하고 결과 반환 - 2 ball, 1 nothing")
    @Test
    public void compareAll_2ball_success() throws Exception {
        //given
        BallGenerateStrategy generator1 = () -> new ArrayList<>(Arrays.asList(2, 1, 9));
        ThreeBall balls1 = new ThreeBall(generator1);

        BallGenerateStrategy generator2 = () -> new ArrayList<>(Arrays.asList(8, 3, 1));
        ThreeBall balls2 = new ThreeBall(generator2);

        Map<MatchType, Integer> target = new HashMap<>();
        target.put(MatchType.STRIKE, 0);
        target.put(MatchType.BALL, 2);
        target.put(MatchType.NOTHING, 1);

        //when
        MatchResult result1 = threeBall.compareAll(balls1);
        MatchResult result2 = threeBall.compareAll(balls2);

        //then
        assertTrue(result1.getMatch().equals(target));
        assertTrue(result2.getMatch().equals(target));
    }

    @DisplayName("공 번호를 비교하고 결과 반환 - 3 nothing")
    @Test
    public void compareAll_3nothing_success() throws Exception {
        //given
        BallGenerateStrategy generator1 = () -> new ArrayList<>(Arrays.asList(4, 5, 6));
        ThreeBall balls1 = new ThreeBall(generator1);

        BallGenerateStrategy generator2 = () -> new ArrayList<>(Arrays.asList(7, 8, 9));
        ThreeBall balls2 = new ThreeBall(generator2);

        Map<MatchType, Integer> target = new HashMap<>();
        target.put(MatchType.STRIKE, 0);
        target.put(MatchType.BALL, 0);
        target.put(MatchType.NOTHING, 3);

        //when
        MatchResult result1 = threeBall.compareAll(balls1);
        MatchResult result2 = threeBall.compareAll(balls2);

        //then
        assertTrue(result1.getMatch().equals(target));
        assertTrue(result2.getMatch().equals(target));
    }

}
