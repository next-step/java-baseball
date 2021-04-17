package view;

import java.util.Scanner;

public class Input {
    private static final String INPUT_NUMBER = "숫자를 입력해 주세요 : ";

    public String startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_NUMBER);
        return scanner.nextLine();
    }
}
