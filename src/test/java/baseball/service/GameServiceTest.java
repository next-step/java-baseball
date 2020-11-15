package baseball.service;

import baseball.domain.MatchResult;
import baseball.domain.MatchType;
import baseball.domain.ThreeBall;
import baseball.domain.strategy.BallGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameServiceTest {

    @DisplayName("정답 공 번호 생성")
    @Test
    public void generateGoal_success() throws Exception {
        //given
        ThreeBall compare = new ThreeBall(Arrays.asList(1, 2, 3));

        BallGenerateStrategy strategy = () -> Arrays.asList(1, 2, 3);
        GameService service = new GameService();

        //when
        ThreeBall goal = service.generateGoal(strategy);

        //then
        assertTrue(goal.equals(compare));
    }

    @DisplayName("정답과 사용자 입력을 비교 - 3스트라이크")
    @Test
    public void compareGoal_success1() throws Exception {
        //given
        ThreeBall goal = new ThreeBall(Arrays.asList(1, 2, 3));
        List<Integer> userinput = Arrays.asList(1, 2, 3);

        //when
        GameService service = new GameService();
        MatchResult matchResult = service.compareGoal(goal, userinput);

        //then
        assertTrue(matchResult.getMatch().get(MatchType.STRIKE) == 3);
    }

    @DisplayName("정답과 사용자 입력을 비교 - 1스트라이크 2볼")
    @Test
    public void compareGoal_success2() throws Exception {
        //given
        ThreeBall goal = new ThreeBall(Arrays.asList(1, 2, 3));
        List<Integer> userinput = Arrays.asList(1, 3, 2);

        //when
        GameService service = new GameService();
        MatchResult matchResult = service.compareGoal(goal, userinput);

        //then
        assertTrue(matchResult.getMatch().get(MatchType.STRIKE) == 1);
        assertTrue(matchResult.getMatch().get(MatchType.BALL) == 2);
    }

    @DisplayName("정답과 사용자 입력을 비교 - 낫싱")
    @Test
    public void compareGoal_success3() throws Exception {
        //given
        ThreeBall goal = new ThreeBall(Arrays.asList(1, 2, 3));
        List<Integer> userinput = Arrays.asList(4, 5, 6);

        //when
        GameService service = new GameService();
        MatchResult matchResult = service.compareGoal(goal, userinput);

        //then
        assertTrue(matchResult.getMatch().get(MatchType.NOTHING) == 3);
    }

}
