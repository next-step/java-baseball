package jito.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CompareBaseBallTest {

    @Test
    @DisplayName("같은 수가 같은 자리에 있으면 [같은 자리 같은 숫자 개수] + \" 스트라이크\" 처리한다.")
    public void strike() {
        //given
        CompareBaseBall compareBaseBall = new CompareBaseBall();
        int[] computer = {1, 4, 6};
        int[] player = {1, 4, 2};

        //when
        String gameResult = compareBaseBall.getGameResult(computer, player);
        compareBaseBall.stopGame();

        //then
        assertEquals(gameResult, "2 스트라이크 ");
    }

    @Test
    @DisplayName("같은 수가 다른 자리에 있으면 [다른 자리 같은 숫자 개수] + \" 볼\" 처리한다.")
    public void ball() {
        //given
        CompareBaseBall compareBaseBall = new CompareBaseBall();
        int[] computer = {4, 1, 6};
        int[] player = {1, 4, 2};

        //when
        String gameResult = compareBaseBall.getGameResult(computer, player);
        compareBaseBall.stopGame();

        //then
        assertEquals(gameResult, "2 볼");
    }

    @Test
    @DisplayName("같은 수가 같은 자리에도 있고, 또 다른 같은 수가 다른 자리에도 있으면 [같은 자리 같은 숫자 개수] + \" 스트라이크 \" + [다른 자리 같은 숫자 개수] + \" 볼\" 처리한다.")
    public void strikeAndBall() {
        //given
        CompareBaseBall compareBaseBall = new CompareBaseBall();
        int[] computer = {4, 1, 2};
        int[] player = {1, 4, 2};

        //when
        String gameResult = compareBaseBall.getGameResult(computer, player);
        compareBaseBall.stopGame();

        //then
        assertEquals(gameResult, "1 스트라이크 2 볼");
    }

    @Test
    @DisplayName("같은 수가 전혀 없으면 \"낫싱\" 처리한다.")
    public void nothing() {
        //given
        CompareBaseBall compareBaseBall = new CompareBaseBall();
        int[] computer = {1, 2, 3};
        int[] player = {4, 5, 6};

        //when
        String gameResult = compareBaseBall.getGameResult(computer, player);
        compareBaseBall.stopGame();

        //then
        assertEquals(gameResult, "낫싱");
    }

    @Test
    @DisplayName("3개의 수가 모두 같은 자리에 있으면 게임을 종료(승리)한다.")
    public void threeStrikeEnd() {
        //given
        CompareBaseBall compareBaseBall = new CompareBaseBall();
        int[] computer = {1, 2, 3};
        int[] player = {1, 2, 3};

        //when
        compareBaseBall.getGameResult(computer, player);
        boolean stopGame = compareBaseBall.stopGame();

        //then
        assertThat(stopGame).isTrue();
    }
}