import java.util.HashMap;
import java.util.Map;

public class BaseBall {

    public static final char STRIKE_KEY = 'S';
    public static final char BALL_KEY = 'B';
    public static final int DEFAULT_VALUE = 0;
    public static final int NOT_CONTAIN_SIGNATURE = -1;
    public static final int MATCH_COUNT = 1;

    private final String answer;

    public BaseBall(String answer) {
        this.answer = answer;
    }

    public Map<Character, Integer> play(String input) {
        int sizeOfInput = input.length();

        Map<Character, Integer> hint = new HashMap<>();

        addStrikeCounts(input, sizeOfInput, hint);

        addBallCounts(input, sizeOfInput, hint);

        return hint;
    }

    private void addBallCounts(String input, int sizeOfInput, Map<Character, Integer> hint) {
        for (int index = 0; index < sizeOfInput; index++) {
            addBallCountWhenEqualsOnlyValue(input, hint, index);
        }
    }

    private void addBallCountWhenEqualsOnlyValue(String input, Map<Character, Integer> hint, int index) {
        if (haveValue(input, index) && !isStrike(input, index)) {
            hint.put(BALL_KEY, addMatchCount(hint, BALL_KEY));
        }
    }

    private boolean haveValue(String input, int index) {
        return answer.indexOf(input.charAt(index)) != NOT_CONTAIN_SIGNATURE;
    }

    private void addStrikeCounts(String input, int sizeOfInput, Map<Character, Integer> hint) {
        for (int index = 0; index < sizeOfInput; index++) {
            addStrikeCountWhenEqualsValueAndPosition(input, hint, index);
        }
    }

    private void addStrikeCountWhenEqualsValueAndPosition(String input, Map<Character, Integer> hint, int index) {
        if (isStrike(input, index)) {
            hint.put(STRIKE_KEY, addMatchCount(hint, STRIKE_KEY));
        }
    }

    private boolean isStrike(String input, int index) {
        return answer.charAt(index) == input.charAt(index);
    }

    private int addMatchCount(Map<Character, Integer> hint, Character key) {
        return hint.getOrDefault(key, DEFAULT_VALUE) + MATCH_COUNT;
    }
}
