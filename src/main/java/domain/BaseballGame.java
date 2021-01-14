package domain;

import util.PrintUtil;
import util.RandomNumberUtil;

import java.util.Scanner;

public class BaseballGame {
    public static final int INPUT_NUMBER_SIZE = 3;

    public void play(Scanner scanner) {
        PrintUtil.printStartInfo();
        int[] userInput = Player.getPlayerInput(scanner);
        int[] systemNum = RandomNumberUtil.getDistinctNumber();
        int strikeCnt = checkStrike(userInput, systemNum);
        PrintUtil.printStrikeHint(strikeCnt);
    }

    private static int checkStrike(int[] userNum, int[] systemNum) {
        int strikeCnt = 0;
        for (int i = 0; i < 3; i++) {
            if(userNum[i] == systemNum[i]) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

}