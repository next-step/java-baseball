package domain;

public class BaseBall {

    private final Numbers answer;

    public BaseBall(Numbers answer) {
        this.answer = answer;
    }

    public JudgementCountPair play(Numbers input) {
        return addCountByAllJudge(input, new JudgementCountPair());
    }

    private JudgementCountPair addCountByAllJudge(Numbers input, JudgementCountPair hint) {
        hint = addCountByJudge(input, hint, new StrikeJudgement());
        hint = addCountByJudge(input, hint, new BallJudgement());

        return hint;
    }

    private JudgementCountPair addCountByJudge(Numbers input, JudgementCountPair hint, Judgeable judgeable) {
        int sizeOfInput = getSizeOfInput(input);

        for (int index = 0; index < sizeOfInput; index++) {
            hint = judgeable.addMatchCount(answer, input, hint, index);
        }

        return hint;
    }

    private int getSizeOfInput(Numbers input) {
        return input.length();
    }
}
