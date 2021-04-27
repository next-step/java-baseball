package domain;

public class BallJudgement implements Judgeable {

    @Override
    public JudgementCountPair addMatchCount(Numbers answer, Numbers input, JudgementCountPair hint, int index) {
        if (isBall(answer, input, index)) {
            return hint.createAddedMatchCount(Judgements.BALL);
        }

        return hint;
    }

    private boolean isBall(Numbers answer, Numbers input, int index) {
        return answer.haveValue(input, index) && !StrikeJudgement.isStrike(answer, input, index);
    }
}
