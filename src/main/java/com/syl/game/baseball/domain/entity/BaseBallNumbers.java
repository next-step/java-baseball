package com.syl.game.baseball.domain.entity;

public class BaseBallNumbers {

    private int first;
    private int second;
    private int third;

    public BaseBallNumbers() {}

    public BaseBallNumbers(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public boolean setSecond(int second) {
        if (compareFirst(second)) return true;
        this.second = second;
        return false;
    }

    public int getThird() {
        return third;
    }

    public boolean setThird(int third) {
        if (compareFirst(third) || compareSecond(third)) return true;
        this.third = third;
        return false;
    }

    public int countStrike(BaseBallNumbers inputNumbers) {
        int count = 0;
        if ( compareFirst(inputNumbers.getFirst()) ) count += 1;
        if ( compareSecond(inputNumbers.getSecond()) ) count += 1;
        if ( compareThird(inputNumbers.getThird()) ) count += 1;
        return count;
    }

    public int countBall(BaseBallNumbers inputNumbers) {
        int count = 0;
        if ( !compareFirst(inputNumbers.getFirst()) && ( compareSecond(inputNumbers.getFirst()) || compareThird(inputNumbers.getFirst()) ) ) count += 1;
        if ( !compareSecond(inputNumbers.getSecond()) && ( compareFirst(inputNumbers.getSecond()) || compareThird(inputNumbers.getSecond()) ) ) count += 1;
        if ( !compareThird(inputNumbers.getThird()) && ( compareFirst(inputNumbers.getThird()) || compareSecond(inputNumbers.getThird()) ) ) count += 1;
        return count;
    }

    public int countNothing(BaseBallNumbers inputNumbers) {
        int count = 0;
        if ( !compareFirst(inputNumbers.getFirst()) && !compareSecond(inputNumbers.getFirst()) && !compareThird(inputNumbers.getFirst()) ) count += 1;
        if ( !compareFirst(inputNumbers.getSecond()) && !compareSecond(inputNumbers.getSecond()) && !compareThird(inputNumbers.getSecond()) ) count += 1;
        if ( !compareFirst(inputNumbers.getThird()) && !compareSecond(inputNumbers.getThird()) && !compareThird(inputNumbers.getThird()) ) count += 1;
        return count;
    }

    private boolean compareFirst(int num) {
        return first == num;
    }

    private boolean compareSecond(int num) {
        return second == num;
    }

    private boolean compareThird(int num) {
        return third == num;
    }

    @Override
    public String toString() {
        return "BaseBallNumbers{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
