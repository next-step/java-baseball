package view;

import domain.Balls;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_BALLS = "숫자를 입력해주세요 : ";
    private static final String PLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART_KEYWORD = "1";
    private static final String FINISH_KEYWORD = "2";
    private static final String KEYWORD_ERROR = "1 혹은 2 를 입력해주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public Balls balls() {
        System.out.print(INPUT_BALLS);
        return new Balls(scanner.nextLine());
    }

    public boolean restart() {
        System.out.println(PLAY_MESSAGE);

        String keyword = scanner.nextLine();
        validRestartKeyword(keyword);

        return RESTART_KEYWORD.equals(keyword);
    }

    private void validRestartKeyword(String keyword) {
        if (!RESTART_KEYWORD.equals(keyword)
                && !FINISH_KEYWORD.equals(keyword)) {
            throw new IllegalArgumentException(KEYWORD_ERROR);
        }
    }
}
