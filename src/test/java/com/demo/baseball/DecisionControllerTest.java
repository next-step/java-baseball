package com.demo.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class DecisionControllerTest {

    private BallsController ballsController;
    private DecisionController decisionController;

    public DecisionControllerTest() {
        this.ballsController = new BallsController();
        this.decisionController = new DecisionController(this.ballsController);
    }

    @BeforeEach
    public void createSameBallsData() throws Exception {
        // given
        this.ballsController.setRandomBalls();
        this.ballsController.setInsertBalls(this.ballsController.getRandomBalls().getInput());
    }

    @Test
    public void isExist() {
        Integer ball = this.ballsController.getInsertBalls().getBalls().get(1);
        boolean isExist = this.decisionController.isExist(ball);

        assertThat(isExist).isTrue();
    }

    @Test
    public void isSamePosition() {
        Integer ball = this.ballsController.getInsertBalls().getBalls().get(1);
        boolean isSamePosition = this.decisionController.isSamePosition(ball);

        assertThat(isSamePosition).isTrue();
    }

    @Test
    public void addDecision() {
        this.decisionController.addDecision(DecisionBall.STRIKE);
        this.decisionController.addDecision(DecisionBall.BALL);

        assertThat(this.decisionController.getDecision().toString())
                .contains("1 스트라이크")
                .contains("1 볼")
                ;
    }

    @Test
    public void makeDecision() {
        Integer ball = this.ballsController.getInsertBalls().getBalls().get(1);
        DecisionBall decisionBall = this.decisionController.makeDecision(ball);

        assertThat(decisionBall).isEqualTo(DecisionBall.STRIKE);
    }

    @Test
    public void setDecision() {
        this.decisionController.setDecision();

        assertThat(this.decisionController.getDecision().toString())
                .contains("3 스트라이크")
                ;
    }
}