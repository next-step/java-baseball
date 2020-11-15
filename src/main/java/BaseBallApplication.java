import baseball.BaseBallGame;

import java.util.Scanner;

/**
 * @author seokrae
 * @since 2020.11.15
 *
 * 야구 게임 시작 클래스
 */
public class BaseBallApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.startGame(sc);
    }
}
