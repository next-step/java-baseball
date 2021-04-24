import java.util.HashMap;
import java.util.Map;

public class BaseBall {

    public static final int DEFAULT_VALUE = 0;
    public static final int NOT_CONTAIN_SIGNATURE = -1;
    public static final int MATCH_COUNT = 1;

    private final String answer;

    public BaseBall(String answer) {
        this.answer = answer;
    }

    public Map<Judgements, Integer> play(String input) {
        int sizeOfInput = input.length();

        Map<Judgements, Integer> hint = new HashMap<>();

        addStrikeCounts(input, sizeOfInput, hint);

        addBallCounts(input, sizeOfInput, hint);

        return hint;
    }

    private void addBallCounts(String input, int sizeOfInput, Map<Judgements, Integer> hint) {
        for (int index = 0; index < sizeOfInput; index++) {
            addBallCountWhenEqualsOnlyValue(input, hint, index);
        }
    }

    private void addBallCountWhenEqualsOnlyValue(String input, Map<Judgements, Integer> hint, int index) {
        if (haveValue(input, index) && !isStrike(input, index)) {
            putJudgement(hint, Judgements.BALL);
        }
    }

    private boolean haveValue(String input, int index) {
        return answer.indexOf(input.charAt(index)) != NOT_CONTAIN_SIGNATURE;
    }

    private void addStrikeCounts(String input, int sizeOfInput, Map<Judgements, Integer> hint) {
        for (int index = 0; index < sizeOfInput; index++) {
            addStrikeCountWhenEqualsValueAndPosition(input, hint, index);
        }
    }

    private void addStrikeCountWhenEqualsValueAndPosition(String input, Map<Judgements, Integer> hint, int index) {
        if (isStrike(input, index)) {
            putJudgement(hint, Judgements.STRIKE);
        }
    }

    private boolean isStrike(String input, int index) {
        return answer.charAt(index) == input.charAt(index);
    }

    private void putJudgement(Map<Judgements, Integer> hint, Judgements judgement) {
        hint.put(judgement, addMatchCount(hint, judgement));
    }

    private int addMatchCount(Map<Judgements, Integer> hint, Judgements judgement) {
        return hint.getOrDefault(judgement, DEFAULT_VALUE) + MATCH_COUNT;
    }
}
