package com.study.domain;

import java.util.Random;

/**
 * @author Jaedoo Lee
 */
public class BaseballGame {

    private int answer;

    public BaseballGame() {
        this.answer = generateAnswer();
    }

    public void generateNewGame() {
        this.answer = generateAnswer();
    }

    public int getAnswer() {
        return answer;
    }

    public boolean isCorrect(int input) {
        if (answer == input) {
            System.out.println(BaseballGameConstants.GAME_CONTINUE);
            return true;
        }
        return false;
    }

    private int generateAnswer() {
        Random random = new Random();

        int n = random.nextInt(8) + 1;
        int nn = checkRandomNum(n, (random.nextInt(8) + 1));
        int nnn = checkRandomNum(nn, checkRandomNum(n, (random.nextInt(8) + 1)));

        return n * 100 + nn * 10 + nnn;
    }

    private int checkRandomNum(int n1, int n2) {
        if (n1 == n2) {
            return checkNumberNine(++n2);
        }
        return checkNumberNine(n2);
    }

    private int checkNumberNine(int n) {
        if (n == 9) return 0;
        return n;
    }
}
