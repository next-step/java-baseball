package baseball;

import java.io.IOException;
import java.util.regex.Pattern;

public class Judgment {
    public Judgment() {

    }

    public static int[] separateNumber(int number) {
        int[] separate = new int[3];
        int index = 2;
        while (number >= 1) {
            int digit = number % 10;
            number /= 10;
            separate[index--] = digit;
        }

        return separate;
    }

    public static int[] getHint(int[] separateRandomNumber, int[] separateInputNumber) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            strikeCount += isEqual(separateRandomNumber[i], separateInputNumber[i]);
            ballCount += checkBall(separateRandomNumber[i], i, separateInputNumber);
        }

        int[] hint = new int[2];
        hint[0] = strikeCount;
        hint[1] = ballCount;

        return hint;
    }

    public static int checkBall(int standardNumber, int standardIndex, int[] compareArr) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            cnt += checkBallIndex(standardNumber, standardIndex, compareArr[i], i);
        }

        return cnt;
    }

    public static int checkBallIndex(int standarNumber, int standardIndex, int compareNumber, int compareIndex) {
        if (standardIndex != compareIndex) {
            return isEqual(standarNumber, compareNumber);
        }

        return 0;
    }

    public static int isEqual(int standardNumber, int compareNumber) {
        if (standardNumber == compareNumber) {
            return 1;
        }

        return 0;
    }

    public static boolean isNothing(int[] hint) {
        if (hint[0] == 0 && hint[1] == 0) return true;
        return false;
    }
}
