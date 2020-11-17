package service;

import interfaces.Ball;
import interfaces.Computer;

public class ComputerImplement implements Computer {
    int saveNumber = 0;
    int[] saveNumberArr;
    int strikeCnt = 0;
    int ballCnt = 0;
    int playerNumber = 0;
    int[] playerNumberArr;

    ComputerImplement(){
        this.strikeCnt = 0;
        this.ballCnt = 0;
        this.saveNumberArr =  new int[3];
        this.playerNumber =0;
        this.playerNumberArr = new int[3];
    }
    public int getStrikeCnt() {
        return strikeCnt;
    }

    public void setStrikeCnt(int strikeCnt) {
        this.strikeCnt = strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public void setBallCnt(int ballCnt) {
        this.ballCnt = ballCnt;
    }

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
        this.saveNumber = ball.selectThreeBalls();

        ball.saveShuffleBall();

        this.saveNumberArr = ball.getSaveRandomBallArr();

    }

    @Override
    public void guessNumberResult(int inputNumber) {
        this.setStrikeCnt(0);
        this.setBallCnt(0);
        savePlayerNumberArr(inputNumber);
        for(int i=0;i<saveNumberArr.length;i++){
            comparePlayerNumberAndComputerNumber(saveNumberArr[i],i);
        }
    }
    @Override
    public void saveComputerNumberArr(int inputNumber){
        int index = 2;
        while(inputNumber>0){
            int remain = inputNumber%10;
            inputNumber /=10;
            saveNumberArr[index--] = remain;
        }
    }
    @Override
    public void savePlayerNumberArr(int inputNumber){
        int index = 2;
        while(inputNumber>0){
            int remain = inputNumber%10;
            inputNumber /=10;
            playerNumberArr[index--] = remain;
        }
    }

    @Override
    public void comparePlayerNumberAndComputerNumber(int computerOneNum, int computerOneNumIndex) {
        for(int i=0;i<playerNumberArr.length;i++){
            compareOneNumber(playerNumberArr[i],i,computerOneNum,computerOneNumIndex);
        }
    }
    @Override
    public void compareOneNumber(int playerOneNum,int playerOneNumIndex,int computerOneNum,int computerOneNumIndex){
        if(playerOneNum == computerOneNum && playerOneNumIndex == computerOneNumIndex){
            strikeCnt++;
        }

        if(playerOneNum == computerOneNum && playerOneNumIndex != computerOneNumIndex){
            ballCnt++;
        }
    }


}
