import java.util.HashMap;
import java.util.Map;

public class BaseBall {

    public static final int DEFAULT_VALUE = 0;
    public static final int MATCH_COUNT = 1;

    private final Number answer;

    public BaseBall(Number answer) {
        this.answer = answer;
    }

    public Map<Judgements, Integer> play(Number input) {
        Map<Judgements, Integer> hint = new HashMap<>();

        addStrikeCounts(input, hint);
        addBallCounts(input, hint);

        return hint;
    }

    private void addBallCounts(Number input, Map<Judgements, Integer> hint) {
        int sizeOfInput = getSizeOfInput(input);

        for (int index = 0; index < sizeOfInput; index++) {
            addBallCountWhenEqualsOnlyValue(input, hint, index);
        }
    }

    private void addBallCountWhenEqualsOnlyValue(Number input, Map<Judgements, Integer> hint, int index) {
        if (isBall(input, index)) {
            putJudgement(hint, Judgements.BALL);
        }
    }

    private boolean isBall(Number input, int index) {
        return answer.haveValue(input, index) && !isStrike(input, index);
    }

    private void addStrikeCounts(Number input, Map<Judgements, Integer> hint) {
        int sizeOfInput = getSizeOfInput(input);

        for (int index = 0; index < sizeOfInput; index++) {
            addStrikeCountWhenEqualsValueAndPosition(input, hint, index);
        }
    }

    private int getSizeOfInput(Number input) {
        return input.length();
    }

    private void addStrikeCountWhenEqualsValueAndPosition(Number input, Map<Judgements, Integer> hint, int index) {
        if (isStrike(input, index)) {
            putJudgement(hint, Judgements.STRIKE);
        }
    }

    private boolean isStrike(Number input, int index) {
        return answer.isStrike(input, index);
    }

    private void putJudgement(Map<Judgements, Integer> hint, Judgements judgement) {
        hint.put(judgement, addMatchCount(hint, judgement));
    }

    private int addMatchCount(Map<Judgements, Integer> hint, Judgements judgement) {
        return hint.getOrDefault(judgement, DEFAULT_VALUE) + MATCH_COUNT;
    }
}
