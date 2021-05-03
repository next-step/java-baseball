package domain;

import exception.BaseBallGameFailureException;
import exception.ErrorCode;

import java.util.List;
import java.util.StringJoiner;

public class Results {
    private int numberOfStrike;
    private int numberOfBall;
    private int numberOfNothing;

    private static final int MAX_RESULT_COUNT = 3;
    private static final int MIN_RESULT_COUNT = 0;

    private static final String ALL_STRIKE_MESSAGE = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String DELIMITER = " ";


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

    public String createResultMessage() {
        StringJoiner joiner = new StringJoiner(DELIMITER);
        strikeResult(joiner);
        ballResult(joiner);
        return joiner.toString().isEmpty() ? NOTHING_MESSAGE : joiner.toString();
    }

    private void strikeResult(StringJoiner joiner) {
        if (numberOfStrike > MIN_RESULT_COUNT) {
            joiner.add(Integer.toString(numberOfStrike)).add(STRIKE_MESSAGE);
        }
        if (numberOfStrike == MAX_RESULT_COUNT) {
            joiner.add(ALL_STRIKE_MESSAGE);
        }
    }

    private void ballResult(StringJoiner joiner) {
        if (numberOfBall > MIN_RESULT_COUNT) {
            joiner.add(Integer.toString(numberOfBall)).add(BALL_MESSAGE);
        }
    }

    private void validateResults(List<Result> results) {
        if (results == null || results.isEmpty() || results.contains(null)) {
            throw new BaseBallGameFailureException(ErrorCode.RESULT_EMPTY_ERROR_MESSAGE);
        }

        if (results.size() < MAX_RESULT_COUNT) {
            throw new BaseBallGameFailureException(ErrorCode.RESULT_COUNT_ERROR_MESSAGE);
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

    public boolean isAllStrike() {
        return numberOfStrike == MAX_RESULT_COUNT;
    }
}
