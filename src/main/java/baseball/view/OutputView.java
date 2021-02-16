package baseball.view;

public class OutputView {
    private static final String CORRECT_MESSAGE = "정답입니다.";
    private static final String END_GAME = "게임을 종료합니다.";
    private static final String RESTART_GAME = "게임을 재시작 합니다.";

    private OutputView() {}

    private static void showCorrect() {
        System.out.println(CORRECT_MESSAGE);
    }

    public static void showEndGame() {
        System.out.println(END_GAME);
    }

    public static void showRestartGame() {
        System.out.println(RESTART_GAME);
    }
}
