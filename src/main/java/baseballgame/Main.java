package baseballgame;

import baseballgame.contract.BaseballContract;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        Scanner sc = new Scanner(System.in);

        System.out.println(BaseballContract.PROG_START);

        boolean retryFlag = true;
        while (retryFlag) {
//            baseballGame.initGame();
//            baseballGame.startGame();

            System.out.println(BaseballContract.GAME_RETRY_NOTI);
            retryFlag = checkRetry(sc.nextLine());
        }

        System.out.println(BaseballContract.PROG_STOP);
    }

    // 게임 재시작 여부 체크
    public static boolean checkRetry(String value) {
        return value.equals(BaseballContract.NEW_GAME);
    }
}
