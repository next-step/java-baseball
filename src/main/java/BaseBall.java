public class BaseBall {

    private final Number answer;

    public BaseBall(Number answer) {
        this.answer = answer;
    }

    public JudgementCountPair play(Number input) {
        JudgementCountPair judgementCount = new JudgementCountPair();

        addStrikeCounts(input, judgementCount);
        addBallCounts(input, judgementCount);

        return judgementCount;
    }

    private void addBallCounts(Number input, JudgementCountPair hint) {
        int sizeOfInput = getSizeOfInput(input);

        for (int index = 0; index < sizeOfInput; index++) {
            addBallCountWhenEqualsOnlyValue(input, hint, index);
        }
    }

    private void addBallCountWhenEqualsOnlyValue(Number input, JudgementCountPair hint, int index) {
        if (isBall(input, index)) {
            hint.putJudgement(Judgements.BALL);
        }
    }

    private boolean isBall(Number input, int index) {
        return answer.haveValue(input, index) && !isStrike(input, index);
    }

    private void addStrikeCounts(Number input, JudgementCountPair hint) {
        int sizeOfInput = getSizeOfInput(input);

        for (int index = 0; index < sizeOfInput; index++) {
            addStrikeCountWhenEqualsValueAndPosition(input, hint, index);
        }
    }

    private int getSizeOfInput(Number input) {
        return input.length();
    }

    private void addStrikeCountWhenEqualsValueAndPosition(Number input, JudgementCountPair hint, int index) {
        if (isStrike(input, index)) {
            hint.putJudgement(Judgements.STRIKE);
        }
    }

    private boolean isStrike(Number input, int index) {
        return answer.isStrike(input, index);
    }
}
