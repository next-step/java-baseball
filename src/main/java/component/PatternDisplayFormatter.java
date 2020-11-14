package component;

import model.PatternResult;

import java.util.StringJoiner;

public class PatternDisplayFormatter {
    private PatternDisplayFormatter() {}

    public static String format(PatternResult patternResult) {
        int strikeCount = patternResult.getStrikeCount();
        int ballCount = patternResult.getBallCount();

        if (strikeCount == 0 && ballCount == 0) {
            return formatForNothing();
        }

        return format(strikeCount, ballCount);
    }

    private static String format(int strikeCount, int ballCount) {
        StringJoiner stringJoiner = new StringJoiner(", ");

        if (strikeCount > 0) {
            stringJoiner.add(String.format("%d 스트라이크", strikeCount));
        }

        if (ballCount > 0) {
            stringJoiner.add(String.format("%d 볼", ballCount));
        }

        return stringJoiner.toString();
    }

    private static String formatForNothing() {
        return "낫싱";
    }
}
