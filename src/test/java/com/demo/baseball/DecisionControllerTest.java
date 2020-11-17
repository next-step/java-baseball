package com.demo.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("입력 값이 randomBalls에 있는지 확인")
    public void isExist() {
        Integer ball = this.ballsController.getInsertBalls().getBalls().get(1);
        boolean isExist = this.decisionController.isExist(ball);

        assertThat(isExist).isTrue();
    }

    @Test
    @DisplayName("입력 값과 같은 값이 randomBalls에 있는 경우 같은 위치에 있는지 확인")
    public void isSamePosition() {
        Integer ball = this.ballsController.getInsertBalls().getBalls().get(1);
        boolean isSamePosition = this.decisionController.isSamePosition(ball);

        assertThat(isSamePosition).isTrue();
    }

    @Test
    @DisplayName("addDecision을 통해 스트라이크 1개, 볼 1개를 추가하는 테스트")
    public void addDecision() {
        this.decisionController.addDecision(DecisionBall.STRIKE);
        this.decisionController.addDecision(DecisionBall.BALL);

        assertThat(this.decisionController.getDecision().toString())
                .contains("1 스트라이크")
                .contains("1 볼")
                ;
    }

    @Test
    @DisplayName("서로 값이 같은 balls의 경우 makeDecision을 통해 DecisionBall 값이 잘 나오는지 확인")
    public void makeDecision() {
        Integer ball = this.ballsController.getInsertBalls().getBalls().get(1);
        DecisionBall decisionBall = this.decisionController.makeDecision(ball);

        assertThat(decisionBall).isEqualTo(DecisionBall.STRIKE);
    }

    @Test
    @DisplayName("서로 값이 같은 balls의 경우 setDecision을 통해 3 스트라이크가 나오는지 확인")
    public void setDecision() {
        this.decisionController.setDecision();

        assertThat(this.decisionController.getDecision().toString())
                .contains("3 스트라이크")
                ;
    }
}