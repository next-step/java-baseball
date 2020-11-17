package com.demo.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class BallsControllerTest {

    BallsController ballsController;

    @BeforeEach
    public void setBallsController() {
        this.ballsController = new BallsController();
    }

    @Test
    @DisplayName("무작위로 만들어진 숫자 하나가 1~9 사이 값인지 확인")
    public void makeRandomBall() {
        // given
        int randomBall = this.ballsController.makeRandomBall();

        // then
        assertThat(randomBall).isBetween(1, 9);
    }

    @Test
    @DisplayName("randomBalls이 잘 만들어져서 크기가 3인지 확인")
    public void setRandomBalls() {
        // given
        this.ballsController.setRandomBalls();

        // then
        List<Integer> balls = this.ballsController.getRandomBalls().getBalls();
        assertThat(balls).hasSize(3);

    }

    @Test
    @DisplayName("중복 된 값이 있는 경우 0이 리턴되는지 확인")
    public void checkDuplication() {
        // given
        List<Integer> randomBalls = this.ballsController.setRandomBalls();

        // when & then
        int duplication = this.ballsController.checkDuplication(randomBalls.get(1));
        assertThat(duplication).isEqualTo(0);

    }


    @Test
    @DisplayName("제대로 된 값(3자리숫자)을 넣었을 때 값이 잘 나오는지 확인")
    public void checkBalls() {
        try {
            String testBalls = "123";
            String checkedBalls = this.ballsController.checkBalls(testBalls);

            assertThat(checkedBalls).isEqualTo(testBalls);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("이상한 값을 넣었을 때 오류가 제대로 발생하는지 확인")
    public void checkBallsError() {

        assertThatThrownBy(() -> {this.ballsController.checkBalls("a23");})
                .isInstanceOf(Exception.class)
                .hasMessageContaining("입력 값이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("insertBalls에 값이 잘 세팅 되는지 확인")
    public void setInsertBalls() {
        // given
        String balls = "123";
        try {
            this.ballsController.setInsertBalls(balls);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // when & then
        assertThat(this.ballsController.getInsertBalls().getBalls())
                .hasSize(3)
                .contains(1, 2, 3);

    }


}