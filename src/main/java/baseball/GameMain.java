package baseball;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.RandomUtil;
import util.ScannerUtil;

public class GameMain {
    public static void main(String[] args) {
        int[] com = RandomUtil.getRandom3DigitWithoutDuplicates();
        int[] user = ScannerUtil.getUserInputAsArray();
        boolean isAnswer = isAnswer(com, user);
        int strikeCount = getStrikeCount(com, user);
        int ballCount = getBallCount(com, user);
    }

    static boolean isAnswer(int[] com, int[] user) {
        return Arrays.equals(com, user);
    }

    static int getStrikeCount(int[] com, int[] user) {
        int strikeCount = 0;
        for (int i=0; i<3 ;i++) {
            strikeCount = isStrike(com[i], user[i]) ? ++strikeCount : strikeCount;
        }
        return strikeCount;
    }

    private static boolean isStrike(int com, int user) {
        return com == user;
    }

    static int getBallCount(int[] com, int[] user) {
        int ballCount = 0;
        for (int i=0; i<3; i++) {
            ballCount = isBall(com, user[i], i) ? ++ballCount : ballCount;
        }
        return ballCount;
    }

    private static boolean isBall(int[] com, int num, int originIndex) {
        for (int i=0; i<3; i++) {
            if (com[i] == num && i != originIndex) {
                return true;
            }
        }
        return false;
    }
}
