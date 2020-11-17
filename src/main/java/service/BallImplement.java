package service;

import interfaces.Ball;

import java.util.Random;

public class BallImplement implements Ball {
    int[] ballArr;
    int[] saveRandomBallArr;
    int saveRandomNumber;
    BallImplement(){
        ballArr = new int[9];
        saveRandomBallArr = new int[3];
        this.saveRandomNumber = 0;
        //ballArr 초기화(1,2,3...9)
        initBallArr();
    }


    @Override
    public void initBallArr() {
        for(int i=0; i<ballArr.length;i++){
            ballArr[i] = i+1;
        }
    }

    @Override
    public void shuffleBall() {
       Random random = new Random();
       random.setSeed(System.currentTimeMillis());
       //shuffle Ball
       for(int i=0; i<ballArr.length;i++){
            int result = random.nextInt(8)+1;
            int tmp = ballArr[result];
            ballArr[result] = ballArr[i];
            ballArr[i] = tmp;
       }
    }

    @Override
    public int selectThreeBalls() {
        this.saveRandomNumber = mergeNumber();
        return this.saveRandomNumber;
    }

    @Override
    public void saveShuffleBall() {
        for(int i=0;i<saveRandomBallArr.length;i++){
            saveRandomBallArr[i] = ballArr[i];
        }
    }

    @Override
    public int mergeNumber() {
        int hundred = ballArr[0]*100;
        int ten = ballArr[1]*10;
        int one = ballArr[2];
        return hundred + ten + one;
    }


    public int[] getBallArr() {
        return ballArr;
    }

    public void setBallArr(int[] ballArr) {
        this.ballArr = ballArr;
    }

    public int[] getSaveRandomBallArr() {
        return saveRandomBallArr;
    }

    public void setSaveRandomBallArr(int[] saveRandomBallArr) {
        this.saveRandomBallArr = saveRandomBallArr;
    }

    public int getSaveRandomNumber() {
        return saveRandomNumber;
    }

    public void setSaveRandomNumber(int saveRandomNumber) {
        this.saveRandomNumber = saveRandomNumber;
    }
}
