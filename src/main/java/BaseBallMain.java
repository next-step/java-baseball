import util.BaseBallUtil;

import java.util.Arrays;
import java.util.Scanner;

import static common.Constant.TEXT_GAME_END;
import static common.Constant.TEXT_GAME_RESTART;

public class BaseBallMain
{
    public static void main(String[] args){
        // 게임 시작,종료 판단
        boolean isContinue = true;
        // 컴퓨터 랜덤값
        while (isContinue) {
            BaseBallUtil baseBallUtil = new BaseBallUtil();
            int[] computerNumbers = baseBallUtil.generatorNumbers();
            System.out.println(Arrays.toString(computerNumbers));
            baseBallUtil.playGame(computerNumbers);
            isContinue = gameEndCheck();
        }

    }
    // 게임 계속, 종료 메서드
    private static boolean gameEndCheck() {
        Scanner scanner = new Scanner(System.in);
        int gameFlag = 1;
        boolean gameStatus = false;
        System.out.println(TEXT_GAME_END);
        System.out.println(TEXT_GAME_RESTART);
        int input = scanner.nextInt();
        if (gameFlag == input) {
            gameStatus = true;
        }
        return gameStatus;
    }

}
