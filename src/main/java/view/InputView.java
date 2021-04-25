package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private String numbers;


    public void inputNumbers(){
        System.out.print("숫자를 입력해 주세요 : ");
        this.numbers = SCANNER.nextLine();
    }

    public String getNumbers() {
        return this.numbers;
    }
}
