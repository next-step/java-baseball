package edu.example.numberbaseball.player;

import edu.example.numberbaseball.common.Ball;
import edu.example.numberbaseball.common.Inning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("야구게임을 즐기는 `Player`에 대한 테스트")
class PlayerTest {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int VALID_BALL_SIZE_FOR_INNING = 3;

    @DisplayName("`Player`는 3개 `Ball`을 가진 `Inning`으로 생성된다.")
    @Test
    void createValidPlayer() {
        List<Ball> inputBallList = new ArrayList<>(Arrays.asList(new Ball(ONE), new Ball(TWO), new Ball(THREE)));
        Inning inputInning = new Inning(inputBallList);
        Player player = new Player(inputInning);
        List<Integer> inningBallNumberList = player.getBallNumberList();
        int ballNumberListSize = inningBallNumberList.size();

        assertEquals(VALID_BALL_SIZE_FOR_INNING, ballNumberListSize);
    }

    @DisplayName("`Player`가 생성되면, 상태는 INACTIVE에서 ACTIVE로 변경된다.")
    @Test
    void checkActivePlayer() {
        List<Ball> inputBallList = new ArrayList<>(Arrays.asList(new Ball(ONE), new Ball(TWO), new Ball(THREE)));
        Inning inputInning = new Inning(inputBallList);
        Player player = new Player(inputInning);

        assertEquals(PlayerStatus.ACTIVE, player.getStatus());
    }
}
