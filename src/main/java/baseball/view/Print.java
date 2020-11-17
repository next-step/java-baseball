package baseball.view;

import java.util.Scanner;

public class Print {

    private static final String REQUEST_USER_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String INFROMATION_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private static final String REQUEST_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static final Scanner scanner = new Scanner(System.in);

    public static void requestUserNumbers() {
        System.out.println(REQUEST_USER_NUMBERS);
    }

    public static void showCurrentBallCount(String current) { System.out.println(current); }

    public static void infromGameEnd() { System.out.println(INFROMATION_GAME_END); }

    public static void requestRestart() { System.out.println(REQUEST_RESTART); }
}
