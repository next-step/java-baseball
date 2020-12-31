package com.kakaocorp.baseball.utils;

class DigitWithIdx {
    public int digit;
    public int idx;

    public DigitWithIdx(int digit, int idx) {
        this.digit = digit;
        this.idx = idx;
    }
}

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
        clearPreviousWork();
        checkBallsAndStrikes();
        return playerGuessedCorrectNum();
    }

    protected void checkBallsAndStrikes() {
        for (int i = 0; i < REQUIRED_DIGIT_CNT_FOR_GAME; i++) {
            DigitWithIdx computerIthDigit =
                    new DigitWithIdx(getIthDigitOf(computerPick, i), i);

            compareFromPlayerNumTo(computerIthDigit);
        }
    }

    private void clearPreviousWork() {
        strikes = 0;
        balls = 0;
    }

    private boolean playerGuessedCorrectNum() {
        return strikes == REQUIRED_DIGIT_CNT_FOR_GAME;
    }

    private int getIthDigitOf(int value, int idx) {
        int oneBasedIdx = idx + 1;
        int factor = (int) Math.pow(10, oneBasedIdx);
        int ithToFirst = value % factor;
        int leftmostDigit = ithToFirst / (factor / 10);

        return leftmostDigit;
    }

    private void compareFromPlayerNumTo(DigitWithIdx computerIthDigit) {
        for (int i = 0; i < REQUIRED_DIGIT_CNT_FOR_GAME; i++) {
            DigitWithIdx playerIthDigit =
                    new DigitWithIdx(getIthDigitOf(playerPick, i), i);

            compareDigitsOfComputerPlayer(computerIthDigit, playerIthDigit);
        }
    }

    private void compareDigitsOfComputerPlayer(DigitWithIdx computer, DigitWithIdx player) {
        if (digitValuesMatch(computer.digit, player.digit)) {
            increaseCounterOfStrikesOrBallsBasedOnIdx(computer.idx, player.idx);
        }
    }

    private boolean digitValuesMatch(int d1, int d2) {
        return d1 == d2;
    }

    private void increaseCounterOfStrikesOrBallsBasedOnIdx(int idx1, int idx2) {
        if (idx1 == idx2) {
            strikes++;
            return;
        }

        balls++;
    }
}
