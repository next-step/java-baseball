package baseball.view;

import baseball.controller.dto.BaseballGameRequest;

import java.util.Scanner;

public class InputView {

    private static final int GAME_START_KEY = 1;
    private static final int GAME_END_KEY = 2;

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public BaseballGameRequest inputGameRequest() {
        return new BaseballGameRequest(inputPitchNumber());
    }

    private String inputPitchNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.next();
    }

    public boolean inputContinue() {
        int input;
        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = scanner.nextInt();
        } while (input != GAME_START_KEY && input != GAME_END_KEY);
        return input == GAME_START_KEY;
    }
}
