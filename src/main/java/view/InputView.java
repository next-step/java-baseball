package view;

import java.util.Scanner;

public class InputView {

    private String numbers;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";

    public void inputNumbers(){
        System.out.print(INPUT_NUMBER_MESSAGE);
        this.numbers = SCANNER.nextLine();
    }

    public String getNumbers() {
        return this.numbers;
    }
}
