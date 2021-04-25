package baseball;

import java.util.Arrays;

import util.RandomUtil;
import util.ScannerUtil;

public class GameMain {
    public static void main(String[] args) {
        int[] com = RandomUtil.getRandom3DigitWithoutDuplicates();
        int[] user = ScannerUtil.getUserInputAsArray();

        boolean isAnswer = isAnswer(com, user);
    }

    static boolean isAnswer(int[] com, int[] user) {
        return Arrays.equals(com, user);
    }
}
