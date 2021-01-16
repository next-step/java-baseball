package domain;

import util.PrintUtil;
import util.RandomNumberUtil;

import java.util.Scanner;

public class BaseballGame {
    public static final int NUMBER_SIZE = 3;
    public static final int GAME_OVER_CONDITION_STRIKE = 3;

    public void play(Scanner scanner) {
        PrintUtil.printStartInfo();
        int[] userInput = Player.getPlayerInput(scanner);
        int[] systemNum = RandomNumberUtil.getDistinctNumber();
        int strikeCnt = checkStrike(userInput, systemNum);
        checkAnswer(strikeCnt);
        int ballCnt = checkBall(userInput, systemNum);
        checkGameStatus(ballCnt, strikeCnt);
    }

    private static int checkStrike(int[] userNum, int[] systemNum) {
        int strikeCnt = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if(userNum[i] == systemNum[i]) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    private static boolean checkAnswer(int strikeCnt) {
        if (strikeCnt == GAME_OVER_CONDITION_STRIKE) {
            PrintUtil.printStrikeHint(strikeCnt);
            PrintUtil.printGameOver();
            PrintUtil.printAskReplayGame();
            return true;
        } else {
            return false;
        }
    }

    private int checkBall(int[] userInput, int[] systemNum) {
        int ballCnt = 0;
        boolean[] checkSystemNum = new boolean[10];
        for (int sysNum : systemNum) {
            checkSystemNum[sysNum] = true;
        }
        for (int i = 0; i < 3; i++) {
            int tmp = userInput[i];
            if(tmp != systemNum[i] && checkSystemNum[tmp]) {
                ballCnt++;
            }
        }
        return ballCnt;
    }

    private static void checkGameStatus(int ballCnt, int strikeCnt) {
        if (ballCnt == 0 && strikeCnt == 0) {
            PrintUtil.printNothing();
        } else if (ballCnt == 0) {
            PrintUtil.printStrikeHint(strikeCnt);
        } else if (strikeCnt == 0) {
            PrintUtil.printBallHint(ballCnt);
        } else {
            PrintUtil.printBallAndStrike(ballCnt, strikeCnt);
        }
    }

}