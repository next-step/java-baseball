package com.kakaocorp.baseball.utils;

public class GameLogicManager {
    protected final static int REQUIRED_DIGIT_CNT_FOR_GAME = 3;
    private int balls;
    private int computerPick;
    private int playerPick;
    private int strikes;

    public void setComputerPick(int computerPick) {
        this.computerPick = computerPick;
    }

    public void setPlayerPick(int playerPick) {
        this.playerPick = playerPick;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public boolean hasRoundFinished() {
        checkBallsAndStrikes();
        return playerRespondedWithCorrectAnswer();
    }

    protected void checkBallsAndStrikes() {
        strikes = 0;
        balls = 0;
        for (int i = 0, t1 = computerPick; i < REQUIRED_DIGIT_CNT_FOR_GAME; t1 /= 10, i++) {
            for (int j = 0, t2 = playerPick; j < REQUIRED_DIGIT_CNT_FOR_GAME; t2 /= 10, j++) {
                if ((t1 % 10) == (t2 % 10)) {
                    if (i == j) {
                        strikes++;
                    } else {
                        balls++;
                    }
                }
            }
        }

//        int idx;
//        int playerPickBackup;
//        int comparingDigitOfPlayerPick;
//
//        idx = 0;
//        playerPickBackup = playerPick;
//
//        while (hasRemainingDigit(playerPickBackup)) {
//            comparingDigitOfPlayerPick = nextUnitPlaceDigit(playerPickBackup);
//            playerPickBackup = removeUnitPlaceDigit(playerPickBackup);
//
//            checkBallsDigitIdx(comparingDigitOfPlayerPick, idx);
//            checkStrikesDigitIdx(comparingDigitOfPlayerPick, idx);
//        }
    }

    private boolean playerRespondedWithCorrectAnswer() {
        return strikes == REQUIRED_DIGIT_CNT_FOR_GAME;
    }

    private boolean hasRemainingDigit(int num) {
        DigitCounter counter = new DigitCounter(num);
        return counter.getDigitCnt() > 0;
    }

    private int nextUnitPlaceDigit(int num) {
        return num % 10;
    }

    private int removeUnitPlaceDigit(int num) {
        return num / 10;
    }

    private void checkBallsDigitIdx(int digit, int playerPickIdx) {
        int computerPickIdx;
        int comparingDigitOfComputerPick;
        int computerPickBackup;

        computerPickIdx = 0;
        computerPickBackup = computerPick;

        while (hasRemainingDigit(computerPickBackup)) {
            comparingDigitOfComputerPick =
                    nextUnitPlaceDigit(computerPickBackup);
            computerPickBackup = removeUnitPlaceDigit(computerPickBackup);


        }
    }

    private void checkStrikesDigitIdx(int digit, int playerPickIdx) {

    }
}
