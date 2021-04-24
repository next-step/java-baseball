public class BallJudgement implements Judgeable {

    @Override
    public JudgementCountPair addMatchCount(Number answer, Number input, JudgementCountPair hint, int index) {
        if (isBall(answer, input, index)) {
            return hint.createAddedMatchCount(Judgements.BALL);
        }

        return hint;
    }

    private boolean isBall(Number answer, Number input, int index) {
        return answer.haveValue(input, index) && !StrikeJudgement.isStrike(answer, input, index);
    }
}
