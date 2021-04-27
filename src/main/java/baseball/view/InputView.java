package baseball.view;

import baseball.domain.BallNumber;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static String NUMBER_QUESTION = "숫자를 입력해주세요:";
    private static String REPLAY_QUESTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static List<BallNumber> askBatInput() {
        System.out.println(NUMBER_QUESTION);
        return BallNumber.convertBallNumber(scanner.next());
    }

    public static int askReplay() {
        System.out.println(REPLAY_QUESTION);
        return scanner.nextInt();
    }
}
