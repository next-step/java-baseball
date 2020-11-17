import result.MatchResult;
import result.Strike;

import java.util.ArrayList;
import java.util.List;

public class NumberCheckResult {

    private static final String NOT_MATCHED_TEXT = "아무것도 맞추지 못하셧습니다";
    private static final String ALL_MATCHED_TEXT = "모두 맞추셨습니다";

    private List<MatchResult> matchResults;
    private int correctStrikeCount;

    public NumberCheckResult(int correctStrikeCount) {
        this.matchResults = new ArrayList<>();
        this.correctStrikeCount = correctStrikeCount;
    }

    public boolean correct() {
        MatchResult strikes = getInstance(Strike.class);
        return strikes != null && strikes.getCount() == correctStrikeCount;
    }

    public String toString() {
        if (correct()) {
            return ALL_MATCHED_TEXT;
        }
        if (matchResults.size() == 0) {
            return NOT_MATCHED_TEXT;
        }
        return getMatchResultText();
    }

    public <T extends MatchResult> void add(T t) {
        MatchResult result = getInstance(t.getClass());
        if (result == null) {
            result = t;
            this.matchResults.add(t);
        }
        result.plus();
    }

    private String getMatchResultText() {
        StringBuilder stringBuilder = new StringBuilder();
        for (MatchResult result : matchResults) {
            stringBuilder.append(result.toString());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private MatchResult getInstance(Class<? extends MatchResult> clazz) {
        for (MatchResult e : matchResults) {
            if (clazz.isInstance(e)) {
                return e;
            }
        }
        return null;
    }


}
