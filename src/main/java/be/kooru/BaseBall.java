package be.kooru;

public class BaseBall {

    private int scoreCalculator(int[] cValue, int[] uValue) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < cValue.length; i++) {
            if (verifyStrike(cValue[i], i, uValue)) strike++;
            if (verifyBall(cValue[i], i, uValue)) ball++;
        }

        return strike * 10 + ball;
    }

    private boolean verifyStrike(int cValue, int index, int[] uValue) {
        for (int i = 0; i < uValue.length; i++) {
            if (cValue == uValue[i] && index == i) {
                return true;
            }
        }
        return false;
    }

    private boolean verifyBall(int cValue, int index, int[] uValue) {
        for (int i = 0; i < uValue.length; i++) {
            if (cValue == uValue[i] && index != i) {
                return true;
            }
        }
        return false;
    }

}
