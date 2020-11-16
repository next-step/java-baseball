package com.coderhglee.game.number;

public class GameNumberCompareResult {
    private int numberSameScore;
    private int numberAndDigitSameScore;

    public GameNumberCompareResult(int numberSameCount, int numberAndDigitSameCount) {
        this.numberSameScore = numberSameCount;
        this.numberAndDigitSameScore = numberAndDigitSameCount;
    }

    public int getNumberSameScore() {
        return numberSameScore;
    }

    public int getNumberAndDigitSameScore() {
        return numberAndDigitSameScore;
    }

    public int getAllCompareScore() {
        return numberSameScore + numberAndDigitSameScore;
    }

    @Override
    public int hashCode() {
        int result = numberSameScore;
        result = 31 * result + numberAndDigitSameScore;
        return result;
    }
}
