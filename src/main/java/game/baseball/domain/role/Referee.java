package game.baseball.domain.role;

import game.baseball.domain.Ball;
import game.baseball.domain.Result;

import java.util.List;

public interface Referee {
    Result judge(List<Integer> input, List<Integer> answers);

    void judgeStrike(Ball ball, List<Integer> answers);

    void judgeBall(Ball ball, List<Integer> answers);

    void sayResult(Result result);

    Result getResult();
}
