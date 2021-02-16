package game.view;

import java.util.Scanner;

public class InputView {

    private static final String REQUEST_NUM_INPUT = "숫자를 입력해주세요 : ";
    private static final String GAME_RESUMPTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private final Scanner sc = new Scanner(System.in);

    public String requestBallNumber() {
        System.out.print(REQUEST_NUM_INPUT);
        return sc.next();
    }

    public String requestRenewGame() {
        System.out.println(GAME_RESUMPTION);
        return sc.next();
    }
}
