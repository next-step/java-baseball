package domain;

public class StrikeJudgement implements Judgeable {

    @Override
    public JudgementCountPair addMatchCount(Numbers answer, Numbers input, JudgementCountPair hint, int index) {
        if (isStrike(answer, input, index)) {
            return hint.createAddedMatchCount(Judgements.STRIKE);
        }

        return hint;
    }

    static boolean isStrike(Numbers answer, Numbers input, int index) {
        return answer.isStrike(input, index);
    }
}
