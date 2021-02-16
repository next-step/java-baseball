package view;

import domain.Number;
import domain.NumberSet;
import java.util.Scanner;
import java.util.stream.Collectors;
import util.ValidationUtil;

public class InputView {

    public static final String INFO_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String INFO_INPUT_REPLAY_OPTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static NumberSet getPlayerInput() {
        System.out.print(INFO_INPUT_NUMBER);
        char[] userInput = scanner.next().toCharArray();
        try {
            ValidationUtil.validateUserInput(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return new NumberSet(new String(userInput).chars()
            .map(input -> input - '0')
            .mapToObj(Number::new)
            .collect(Collectors.toList()));
    }

    public static int getPlayerReplayInput() {
        System.out.println(INFO_INPUT_REPLAY_OPTION);
        String userInput = scanner.next();
        try {
            ValidationUtil.validateUserReplayInput(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return Integer.parseInt(userInput);
    }

}
