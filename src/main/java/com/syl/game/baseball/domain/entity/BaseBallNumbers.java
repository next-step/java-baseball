package com.syl.game.baseball.domain.entity;

public class BaseBallNumbers {

    private int first;
    private int second;
    private int third;

    public BaseBallNumbers(int numbers) {
        if ( 123 <= numbers && numbers <= 987 ) {
            this.first = numbers / 100;
            this.second = (numbers % 100) / 10;
            this.third = (numbers % 100) % 10;
        }
    }

    public int getFirst() {
        return first;
    }

    public boolean setFirst(int first) {
        if (isValidNumber(first)) {
            this.first = first;
            return false;
        }
        return true;
    }

    public int getSecond() {
        return second;
    }

    public boolean setSecond(int second) {
        if (isValidNumber(second)) {
            this.second = second;
            return false;
        }
        return true;
    }

    public int getThird() {
        return third;
    }

    public boolean setThird(int third) {
        if (isValidNumber(third)) {
            this.third = third;
            return false;
        }
        return true;
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

    private boolean isValidNumber(int num) {
        return !compareFirst(num) && !compareSecond(num) && !compareThird(num);
    }

    public boolean isValidStatus() {
        return first != 0 && second != 0 && third != 0;
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
