package baseball.service;

import baseball.domain.ThreeBall;
import baseball.domain.strategy.BallGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
}
