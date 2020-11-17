package com.demo.baseball;

import org.junit.jupiter.api.BeforeEach;
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
    public void makeRandomBall() {
        // given
        int randomBall = this.ballsController.makeRandomBall();

        // then
        assertThat(randomBall).isBetween(1, 9);
    }

    @Test
    public void setRandomBalls() {
        // given
        this.ballsController.setRandomBalls();

        // then
        List<Integer> balls = this.ballsController.getRandomBalls().getBalls();
        assertThat(balls).hasSize(3);

    }

    @Test
    public void checkDuplication() {
        // given
        List<Integer> randomBalls = this.ballsController.setRandomBalls();

        // when & then
        int duplication = this.ballsController.checkDuplication(randomBalls.get(1));
        assertThat(duplication).isEqualTo(0);

    }


    @Test
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
    public void checkBallsError() {

        assertThatThrownBy(() -> {this.ballsController.checkBalls("a23");})
                .isInstanceOf(Exception.class)
                .hasMessageContaining("입력 값이 올바르지 않습니다.");
    }

    @Test
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