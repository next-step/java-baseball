package com.demo.baseball;

import java.util.List;

public class DecisionController {

    private final BallsController ballsController;

    private Decision decision;

    public DecisionController(BallsController ballsController) {
        this.ballsController = ballsController;
        this.decision = new Decision();
    }

    public Decision getDecision() {
        return decision;
    }

    /**
     * set decision used ballsController insertBalls
     */
    public void setDecision() {
        for (int ball : this.ballsController.getInsertBalls().getBalls()) {
            this.addDecision(makeDecision(ball));
        }
    }

    /**
     * decision initialize
     */
    public void initDecision() {
        this.decision = new Decision();
    }

    /**
     * param compared to ballsController randomBalls's exist value and same position
     * @param ball
     * @return DecisionBall
     */
    public DecisionBall makeDecision(int ball) {
        if (isExist(ball) && isSamePosition(ball)) {
            return DecisionBall.STRIKE;
        }
        if (isExist(ball) && !isSamePosition(ball)) {
            return DecisionBall.BALL;
        }
        return DecisionBall.NONE;
    }

    /**
     * param compared to ballsController randomBalls's exist value
     * @param ball
     * @return boolean isExist
     */
    public boolean isExist(int ball) {
        if (this.ballsController.getRandomBalls().getBalls().contains(ball)) {
            return true;
        }
        return false;
    }

    /**
     * if param exist ballsController randomBalls's value, checked same position
     * @param ball
     * @return boolean isSamePosition
     */
    public boolean isSamePosition(int ball) {
        if (this.ballsController.getRandomBalls().getBalls().indexOf(ball)
                == this.ballsController.getInsertBalls().getBalls().indexOf(ball)) {
            return true;
        }
        return false;
    }

    /**
     * save one decision result
     * @param decisionBall
     */
    public void addDecision(DecisionBall decisionBall) {
        if(decisionBall == DecisionBall.STRIKE) {
            this.decision.addStrike();
        }
        if(decisionBall == DecisionBall.BALL) {
            this.decision.addBall();;
        }
        this.decision.addCount();
    }

}
