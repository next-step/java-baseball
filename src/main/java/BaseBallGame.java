import util.GeneratorRandomNumbers;

import java.util.Arrays;
import java.util.Scanner;

import static common.Constant.TEXT_GAME_END;
import static common.Constant.TEXT_GAME_RESTART;
import static util.BaseBallGameUtil.playGame;


public class BaseBallGame {


    public static void main(String args[]) {

        run();

    }

    // 실행 메서드
    public static void run() {

        boolean isContinue = true;

        while (isContinue) {
            // 컴퓨터 랜덤값
            int[] computerNumbers = GeneratorRandomNumbers.generatorNumbers();
            System.out.println(Arrays.toString(computerNumbers));
            playGame(computerNumbers);
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
