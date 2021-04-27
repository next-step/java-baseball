package game.baseball.domain.rule;

import game.baseball.domain.Answer;
import game.baseball.domain.Ball;
import game.baseball.domain.Result;

import java.util.List;

public abstract class BaseballGameRule {

    protected int totalBallCount;
    protected char startBallNumber;
    protected char endBallNumber;

    public abstract boolean isValidInput(String input);

    public abstract boolean isOut(Result result);

    public abstract boolean isNothing(Result result);

    public abstract Answer generateAnswers();

    public abstract boolean isSuccess(Result result);

    public abstract boolean isStrike(Ball ball, List<Integer> answers);

    public abstract boolean isBall(Ball ball, List<Integer> answers);

    public abstract void printSuccessMsg();
}
