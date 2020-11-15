package baseballgame.ui.output;

public class ConsoleOutput implements Output {
    private static final String SENTENCES_INPUT_USER_SCORE = "숫자를 입력해주세요: ";

    @Override
    public void demandingUserScore() {
        System.out.print(SENTENCES_INPUT_USER_SCORE);
    }
}
