package baseball.view;

import baseball.domain.BallNumbers;

import java.util.Scanner;

public class InputView {

    private static InputView inputView;
    private final Scanner scanner;

    private InputView() {
        this.scanner = new Scanner(System.in);
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public BallNumbers getUserNumbers() {
        System.out.println("숫자를 입력해 주세요 : ");
        return new BallNumbers(scanner.nextLine());
    }

    public String getGameStart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        return scanner.nextLine();
    }
}
