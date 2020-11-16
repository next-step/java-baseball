package com.demo.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

}