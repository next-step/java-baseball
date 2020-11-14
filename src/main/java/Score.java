import java.util.ArrayList;
import java.util.List;

public enum Score {
    STRIKE("스트라이크", 2),
    BALL("볼", 1),
    NOTHING("낫싱", 0);

    private final String score;
    private final int matchpoint;

    Score(String score, int matchpoint) {
        this.score = score;
        this.matchpoint = matchpoint;
    }

    public static Score findScore(int matchPoint) {
        List<Score> result = new ArrayList<>();

        for (Score score : values()) {
            result.add(score.find(matchPoint));
        } //TODO sort로 할 수 없나?
        result.removeIf(n -> n == NOTHING);
        if (result.size() == 0) {
            return NOTHING;
        }
        return result.get(0);
    }

    private Score find(int matchPoint) {
        if (this.matchpoint == matchPoint) {
            return this;
        }
        return NOTHING;
    }
}
