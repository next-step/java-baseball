package com.coderhglee.game.domain;

public class GameGroupsCompareResult {
    private int numberSameScore;
    private int numberAndDigitSameScore;

    public GameGroupsCompareResult(int numberSameCount, int numberAndDigitSameCount) {
        this.numberSameScore = numberSameCount;
        this.numberAndDigitSameScore = numberAndDigitSameCount;
    }

    public int getNumberSameScore() {
        return numberSameScore;
    }

    public int getNumberAndDigitSameScore() {
        return numberAndDigitSameScore;
    }

    @Override
    public int hashCode() {
        int result = numberSameScore;
        result = 31 * result + numberAndDigitSameScore;
        return result;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
