package baseball.domain.score;

public class Nothing implements Score {

    public static final String TEXT_NO_COUNT = "낫씽";

    @Override
    public String getResult() {
        return TEXT_NO_COUNT;
    }
}
