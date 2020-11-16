package com.woowa.baseball;

public class Referee {

    String number;

    public Referee() {}

    public Referee(String number) {
        this.number = number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int checkStrike(String input) {
        int strike = 0;
        for (int i = 0; i < number.length(); i++) {
            strike += isStrikeAt(input, i);
        }
        return strike;

    }

    private int isStrikeAt(String input, int i) {
        if (number.charAt(i) == input.charAt(i)) {
            return 1;
        }
        return 0;
    }

    public int checkBall(String input) {
        int ball = 0;
        for (int i = 0; i < number.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                ball += isBall(input, i, j);
            }
        }
        return ball;
    }

    private int isBall(String input, int i, int j) {
        if (i != j && number.charAt(i) == input.charAt(j)) {
            return 1;
        }
        return 0;
    }

    public boolean checkGameOut(int strike) {
        if (strike == 3) {
            return true;
        }
        return false;
    }

}
