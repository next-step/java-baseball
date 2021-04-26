package view;

import domain.Balls;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_BALLS = "숫자를 입력해주세요 : ";

    private static Scanner scanner = new Scanner(System.in);

    public Balls balls() {
        System.out.print(INPUT_BALLS);
        return new Balls(scanner.nextLine());
    }
}
