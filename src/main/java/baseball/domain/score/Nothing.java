package baseball.domain.score;

/**
 * 아무것도 맞추지 못한 상태.
 */
public class Nothing implements Score {
    public static final String TEXT_NO_COUNT = "낫씽";

    @Override
    public String getResult() {
        return TEXT_NO_COUNT;
    }
}
