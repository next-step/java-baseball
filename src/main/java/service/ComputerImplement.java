package service;

import interfaces.Ball;
import interfaces.Computer;

public class ComputerImplement implements Computer {
    int saveNumber = 0;
    int[] saveNumberArr = new int[3];

    public int getSaveNumber() {
        return saveNumber;
    }

    public void setSaveNumber(int saveNumber) {
        this.saveNumber = saveNumber;
    }

    public int[] getSaveNumberArr() {
        return saveNumberArr;
    }

    public void setSaveNumberArr(int[] saveNumberArr) {
        this.saveNumberArr = saveNumberArr;
    }

    @Override
    public void selectGameBall() {
        BallImplement ball = new BallImplement();
        //shuffle Ball
        ball.shuffleBall();
        //select three numbers
        ball.selectThreeBalls();

        ball.saveShuffleBall();

        this.saveNumberArr = ball.getSaveRandomBallArr();
    }

    @Override
    public void guessNumberResult(int inputNumber) {

    }
}
