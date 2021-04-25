package baseball;

import util.RandomUtil;
import util.ScannerUtil;

public class GameMain {
    public static void main(String[] args) {
        int[] com = RandomUtil.getRandom3DigitWithoutDuplicates();
        int[] user = ScannerUtil.getUserInputAsArray();
    }
}
