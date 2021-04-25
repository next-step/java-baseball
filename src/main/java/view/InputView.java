package view;

import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String MESSAGE_RENEW_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String EXCEPTION_MESSAGE_WRONG_CONTINUE_ANSWER = "입력값은 1 또는 2 정수여야합니다. (게임이 종료됩니다.)";
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
        int answer;
        try {
            answer = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_WRONG_CONTINUE_ANSWER);
        }

        return answer;
    }
}
