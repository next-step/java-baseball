package view;

import java.util.Scanner;

public class InputView {

    private static final String GET_PLAYERS_NUMBERS_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final Scanner scanner = new Scanner(System.in);

    public InputView() {
    }

    public String getPlayersNumbers() {
        System.out.print(GET_PLAYERS_NUMBERS_MESSAGE);
        return scanner.nextLine();

    }

    public int getRestartInput() {
        System.out.println(RESTART_MESSAGE);
        return parseToInt(scanner.nextLine());
    }

    public int parseToInt(String input) throws IllegalArgumentException{
        int userInput = Integer.parseInt(input);
        if(userInput != 1 && userInput != 2) {
            throw new IllegalArgumentException("1 or 2를 입력해주세요.");
        }
        return userInput;
    }
}
