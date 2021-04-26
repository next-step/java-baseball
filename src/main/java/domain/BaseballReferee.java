package domain;


public class BaseballReferee {

    private BaseballNumbers numbers;

    public BaseballReferee(BaseballNumbers numbers) {
        this.numbers = numbers;
    }

    public BaseballResult judge(BaseballNumbers playerScore) {
        BaseballResult baseballResult = new BaseballResult();

        for (int i = 1; i < 4; i++) {
            Pitching pitching = Pitching.create(i, playerScore.numberOfRound(i));
            comparePitching(baseballResult, pitching);
        }

        return baseballResult;
    }

    private void comparePitching(BaseballResult baseballResult, Pitching pitching) {
        if (numbers.contains(pitching.pitching())) {
            pitchingJudge(baseballResult, pitching);
        }
    }

    private void pitchingJudge(BaseballResult baseballResult, Pitching pitching) {
        if (numbers.isSameIndex(pitching)) {
            baseballResult.strike();
            return;
        }
        baseballResult.ball();
    }

}
