package service;

import model.Score;

class RuleService {

    Score checkScore(int[] botNumber, int[] userNumber) {
        Score score = new Score();

        int strike = countStrike(botNumber, userNumber);
        int ball = countBall(botNumber, userNumber);

        score.setStrike(strike);
        score.setBall(ball - strike);
        return score;
    }

    int countStrike(int[] botNumber, int[] userNumber) {
        int count = 0;
        for (int i = 0; i < botNumber.length; i++) {
            if (botNumber[i] == userNumber[i]) {
                count++;
            }
        }
        return count;
    }

    int countBall(int[] botNumber, int[] userNumber) {
        int count = 0;
        for (int i : userNumber) {
            if (isOverlap(botNumber, i)) {
                count++;
            }
        }
        return count;
    }

    boolean isOverlap(int[] arr, int newNumber) {
        for (int number : arr) {
            if (number == newNumber) {
                return true;
            }
        }
        return false;
    }
}
