package domain;

import java.util.List;

public class Results {
    private int numberOfStrike;
    private int numberOfBall;
    private int numberOfNothing;

    private Results(List<Result> results) {
        validateResults(results);
        makeStatistics(results);
    }

    public static Results of(List<Result> results) {
        return new Results(results);
    }

    public int getNumberOfStrike() {
        return this.numberOfStrike;
    }

    public int getNumberOfBall() {
        return this.numberOfBall;
    }

    private void validateResults(List<Result> results) {
        if (results == null || results.isEmpty() || results.contains(null)) {
            throw new IllegalArgumentException("결과 값이 존재하지 않습니다.");
        }

        if (results.size() < 3) {
            throw new IllegalArgumentException("");
        }
    }

    private void makeStatistics(List<Result> results) {
        for (Result result : results) {
            countResult(result);
        }
    }

    private void countResult(Result result) {
        if (result.equals(Result.STRIKE)) this.numberOfStrike++;
        if (result.equals(Result.BALL)) this.numberOfBall++;
        if (result.equals(Result.NOTHING)) this.numberOfNothing++;
    }
}
