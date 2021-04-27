package game;

import java.util.Scanner;

import static game.constant.GameConstant.*;

public class GameRunner {

    private GameRunner() {
        throw new IllegalStateException("Runner Class");
    }

    public static void startGame(Game game) {
        game.start();
    }

    public static boolean checkRestart() {
        Scanner sc = new Scanner(System.in);
        int restartSelect;
        do {
            System.out.println("게임을 새로 시작하려면 " + RESTART + ", 종료하려면 " + FINISH + "를 입력하세요.");
            restartSelect = sc.nextInt();
        } while (!validateRestartSelect(restartSelect));

        if (restartSelect == RESTART) {
            sc.close();
            return true;
        }
        return false;
    }

    private static boolean validateRestartSelect(int restartSelect) {
        if (restartSelect != RESTART && restartSelect != FINISH) {
            System.out.println("잘못된 값을 입력했습니다.");
            return false;
        }

        return true;
    }
}
