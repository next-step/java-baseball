package game.baseball.constant;

public class BaseballConfig {
    private BaseballConfig() {
        throw new IllegalStateException("Constant Class");
    }

    /**
     * 정답의 갯수
     */
    public static final int ANSWER_COUNT = 3;
    /**
     * 정답에 포함되는 숫자의 최솟값
     */
    public static final int ANSWER_NUMBER_MIN = 1;
    /**
     * 정답에 포함되는 숫자의 최대값
     */
    public static final int ANSWER_NUMBER_MAX = 9;
}
