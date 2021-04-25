package view;

import java.util.Scanner;

public class InputView {

    private String numbers;
    private String continueNumber;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String INPUT_CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료 하려면 2를 입력하세요.";

    public void inputNumbers(){
        System.out.print(INPUT_NUMBER_MESSAGE);
        this.numbers = SCANNER.nextLine();
    }

    public void inputContinueNumber() {
        System.out.println(INPUT_CONTINUE_MESSAGE);
        this.continueNumber = SCANNER.nextLine();
    }

    public String getNumbers() {
        return this.numbers;
    }

    public String getContinueNumber() {
        return continueNumber;
    }
}
