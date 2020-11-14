import model.PatternResult;

import java.util.StringJoiner;

public class PatternDisplayFormatter {
    private PatternDisplayFormatter() {
    }

    static public String format(PatternResult patternResult) {
        int strikeCount = patternResult.getStrikeCount();
        int ballCount = patternResult.getBallCount();

        if (strikeCount == 0 && ballCount == 0) {
            return formatForNothing();
        }

        return format(strikeCount, ballCount);
    }

    static private String format(int strikeCount, int ballCount) {
        StringJoiner stringJoiner = new StringJoiner(", ");

        if (strikeCount > 0) {
            stringJoiner.add(String.format("%d 스트라이크", strikeCount));
        }

        if (ballCount > 0) {
            stringJoiner.add(String.format("%d 볼", ballCount));
        }

        return stringJoiner.toString();
    }

    static private String formatForNothing() {
        return "낫싱";
    }
}
