public class StrikeJudgement implements Judgeable {

    @Override
    public JudgementCountPair addMatchCount(Number answer, Number input, JudgementCountPair hint, int index) {
        if (isStrike(answer, input, index)) {
            return hint.createAddedMatchCount(Judgements.STRIKE);
        }

        return hint;
    }

    static boolean isStrike(Number answer, Number input, int index) {
        return answer.isStrike(input, index);
    }
}
