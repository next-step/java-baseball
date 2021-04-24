public class BaseBall {

    private final Number answer;

    public BaseBall(Number answer) {
        this.answer = answer;
    }

    public JudgementCountPair play(Number input) {
        JudgementCountPair hint = new JudgementCountPair();

        hint = addStrikeCounts(input, hint);
        hint = addBallCounts(input, hint);

        return hint;
    }

    private JudgementCountPair addBallCounts(Number input, JudgementCountPair hint) {
        int sizeOfInput = getSizeOfInput(input);

        for (int index = 0; index < sizeOfInput; index++) {
            hint = addBallCountWhenEqualsOnlyValue(input, hint, index);
        }

        return hint;
    }

    private JudgementCountPair addBallCountWhenEqualsOnlyValue(Number input, JudgementCountPair hint, int index) {
        if (isBall(input, index)) {
            return hint.createAddedMatchCount(Judgements.BALL);
        }

        return hint;
    }

    private boolean isBall(Number input, int index) {
        return answer.haveValue(input, index) && !isStrike(input, index);
    }

    private JudgementCountPair addStrikeCounts(Number input, JudgementCountPair hint) {
        int sizeOfInput = getSizeOfInput(input);

        for (int index = 0; index < sizeOfInput; index++) {
            hint = addStrikeCountWhenEqualsValueAndPosition(input, hint, index);
        }

        return hint;
    }

    private int getSizeOfInput(Number input) {
        return input.length();
    }

    private JudgementCountPair addStrikeCountWhenEqualsValueAndPosition(Number input, JudgementCountPair hint, int index) {
        if (isStrike(input, index)) {
            return hint.createAddedMatchCount(Judgements.STRIKE);
        }

        return hint;
    }

    private boolean isStrike(Number input, int index) {
        return answer.isStrike(input, index);
    }
}
