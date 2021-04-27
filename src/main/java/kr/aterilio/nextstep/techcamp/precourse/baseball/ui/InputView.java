package kr.aterilio.nextstep.techcamp.precourse.baseball.ui;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {

    private static final String SPLIT_BY = "";
    private static final int REQUIRED_LENGTH = 3;

    private static final String MSG_INPUT = "숫자를 입력해 주세요 : ";
    private static final String MSG_IS_NEW_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final int CMD_NOTHING = -1;
    private static final int CMD_NEW_GAME = 1;
    private static final int CMD_EXIT = 2;

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public void finalize() {
        scanner.close();
    }

    public ArrayList<Integer> input() {

        String inputString = "";
        do {
            System.out.print(MSG_INPUT);
            inputString = scanner.next();
        } while ( !isValid(inputString) );

        return parse(inputString);
    }

    private ArrayList<Integer> parse(String inputString) {
        ArrayList<Integer> inputs = new ArrayList<>();
        for (String str : inputString.split(SPLIT_BY)) {
            inputs.add(Integer.valueOf(str));
        }
        return inputs;
    }

    private boolean isValid(String inputString) {
        return inputString.length() == REQUIRED_LENGTH;
    }

    public boolean isNewGame() {

        int command = CMD_NOTHING;
        do {
            System.out.println(MSG_IS_NEW_GAME);
            command = scanner.nextInt();
        } while(command != CMD_NEW_GAME && command != CMD_EXIT);

        return command == CMD_NEW_GAME;
    }
}
