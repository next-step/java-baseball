package view;

import domain.UserInputBaseballNumber;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String START_MESSAGE = "야구 숫자를 입력하세요 : ";
    private static final String NEW_GAME_OR_QUIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static int getNewGameOrQuitNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(NEW_GAME_OR_QUIT_MESSAGE);
        return scanner.nextInt();
    }

    public static List<Integer> inputNumbers() {
        System.out.print(START_MESSAGE);
        Scanner scanner = new Scanner(System.in);인
        try {
            String numbers = scanner.next();
            return UserInputBaseballNumber.userBaseballNumber(numbers);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return inputNumbers();
        }
    }
}
