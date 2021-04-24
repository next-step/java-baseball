public class BaseBall {

    private final Number answer;

    public BaseBall(Number answer) {
        this.answer = answer;
    }

    public JudgementCountPair play(Number input) {
        return addCountByAllJudge(input, new JudgementCountPair());
    }

    private JudgementCountPair addCountByAllJudge(Number input, JudgementCountPair hint) {
        hint = addCountByJudge(input, hint, new StrikeJudgement());
        hint = addCountByJudge(input, hint, new BallJudgement());

        return hint;
    }

    private JudgementCountPair addCountByJudge(Number input, JudgementCountPair hint, Judgeable judgeable) {
        int sizeOfInput = getSizeOfInput(input);

        for (int index = 0; index < sizeOfInput; index++) {
            hint = judgeable.addMatchCount(answer, input, hint, index);
        }

        return hint;
    }

    private int getSizeOfInput(Number input) {
        return input.length();
    }
}
