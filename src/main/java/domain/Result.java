package domain;

import java.util.Collections;
import java.util.List;

public class Result {

    private final List<Score> score;

    public Result(List<Score> score) {
        this.score = Collections.unmodifiableList(score);
    }

    public List<Score> getScores() {
        return new ArrayList<>(score);
    }
}
