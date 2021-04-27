package game.baseball.domain.role;

import game.baseball.domain.Ball;
import game.baseball.domain.Result;
import game.baseball.domain.rule.BaseballGameRule;

import java.util.List;

public class BasicReferee implements Referee {
    private Result result = new Result();
    private BaseballGameRule rule;

    public BasicReferee(BaseballGameRule rule) {
        this.rule = rule;
    }

    @Override
    public Result judge(List<Integer> input, List<Integer> answers) {
        result = new Result();

        for (int i = 0; i < input.size(); i++) {
            Ball ball = new Ball(input.get(i), i);

            this.judgeStrike(ball, answers);
            this.judgeBall(ball, answers);
        }

        this.processResult();

        return result;
    }

    @Override
    public void judgeStrike(Ball ball, List<Integer> answers) {
        if (rule.isStrike(ball, answers)) {
            result.increaseStrike();
        }
    }

    @Override
    public void judgeBall(Ball ball, List<Integer> answers) {
        if (rule.isBall(ball, answers)) {
            result.increaseBall();
        }
    }

    @Override
    public void sayResult(Result result) {
        int strikeCount = result.getStrikeCount();
        int ballCount = result.getBallCount();

        if (result.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(getResultMsg(strikeCount, ballCount));
    }

    private String getResultMsg(int strikeCount, int ballCount) {
        StringBuilder resultMsg = new StringBuilder();

        if (strikeCount != 0) {
            resultMsg.append(strikeCount);
            resultMsg.append("스트라이크");
        }

        if (strikeCount != 0 && ballCount != 0) {
            resultMsg.append(" ");
        }

        if (ballCount != 0) {
            resultMsg.append(ballCount);
            resultMsg.append("볼");
        }

        return resultMsg.toString();
    }

    @Override
    public Result getResult() {
        return result;
    }

    private void processResult() {
        if (rule.isOut(result)) {
            result.setOut();
        }

        if (rule.isNothing(result)) {
            result.setNothing();
        }
    }

}
