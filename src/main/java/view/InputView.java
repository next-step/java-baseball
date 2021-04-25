package view;

import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String MESSAGE_RENEW_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String inputNumber() {
        System.out.print(MESSAGE_INPUT_NUMBER);
        return scanner.nextLine();
    }

    public int isContinue() {
        System.out.println(MESSAGE_RENEW_OR_END);
        return Integer.parseInt(scanner.nextLine());
    }
}
