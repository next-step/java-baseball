package baseball;

import java.util.Arrays;

import util.RandomUtil;
import util.ScannerUtil;

public class GameMain {
    public static void main(String[] args) {
        int[] com = RandomUtil.getRandom3DigitWithoutDuplicates();
        int[] user = ScannerUtil.getUserInputAsArray();
        boolean isAnswer = isAnswer(com, user);
        int strikeCount = getStrikeCount(com, user);
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
}
