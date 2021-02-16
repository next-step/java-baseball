package baseball.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_BASEBALL_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String FINISH_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int INPUT_FINISH_NUMBER = 2;
    public String inputBaseballNumbers() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print(INPUT_BASEBALL_NUMBER_MESSAGE);

        return scanner.nextLine();
    }

    public boolean inputFinishGame() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(FINISH_GAME_MESSAGE);

        return scanner.nextInt() == INPUT_FINISH_NUMBER;
    }
}
