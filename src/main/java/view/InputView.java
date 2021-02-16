package view;

import java.util.Scanner;

public class InputView {

    private static final String GET_PLAYERS_NUMBERS_MESSAGE = "숫자를 입력해 주세요 : ";
    private final Scanner scanner = new Scanner(System.in);

    public InputView() {
    }

    public String getPlayersNumbers() {
        System.out.println(GET_PLAYERS_NUMBERS_MESSAGE);
        return scanner.nextLine();

    }
}
