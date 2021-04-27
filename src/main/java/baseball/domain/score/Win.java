package baseball.domain.score;

public class Win implements Score {
    private static final String TEXT_WIN = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    @Override
    public String getResult() {
        return TEXT_WIN;
    }
}
