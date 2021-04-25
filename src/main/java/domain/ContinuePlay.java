package domain;

public class ContinuePlay {

    private static final String EXCEPTION_MESSAGE_INVALID_CONTINUE_ANSWER = "입력값은 1 또는 2 이여야 합니다. (게임이 종료됩니다)";

    private int continueAnswer;

    private ContinuePlay(int continueAnswer) {
        this.continueAnswer = continueAnswer;
    }

    public static ContinuePlay create(int continueAnswer) {
        if (continueAnswer > 0 && continueAnswer < 3) {
            return new ContinuePlay(continueAnswer);
        }

        throw new IllegalArgumentException(EXCEPTION_MESSAGE_INVALID_CONTINUE_ANSWER);
    }

    public boolean isContinuePlay() {
        return continueAnswer == 1;
    }
}
