import component.PatternAnalyzer;
import component.ThreeDigitsFactory;
import model.PatternResult;
import model.ThreeDigits;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class PatternAnalyzerTest {
    @Test
    @DisplayName("모든 숫자가 위치와 숫자가 같으면, 3개의 스트라이크가 나와야 한다.")
    void getThreeStrike_IfThreeDigitsAreSame() {
        PatternResult patternResult = analyze("123", "123");

        assertSame(patternResult.getStrikeCount(), 3);
        assertSame(patternResult.getBallCount(), 0);
    }

    @Test
    @DisplayName("2개의 숫자가 위치와 숫자가 같으면, 2개의 스트라이크가 나와야 한다.")
    void getTwoStrike_IfTwoDigitsAreSame() {
        PatternResult patternResult = analyze("123", "125");

        assertSame(patternResult.getStrikeCount(), 2);
        assertSame(patternResult.getBallCount(), 0);
    }

    @Test
    @DisplayName("1개의 숫자가 위치와 숫자만 같으면, 1개의 스트라이크가 나와야 한다.")
    void getOneStrike_IfOneDigitAreSame() {
        PatternResult patternResult = analyze("173", "195");

        assertSame(patternResult.getStrikeCount(), 1);
        assertSame(patternResult.getBallCount(), 0);
    }

    @Test
    @DisplayName("모든 숫자가 위치만 같고 숫자가 다르면, 3개의 볼이 나와야 한다.")
    void getThreeBall_IfThreeDigitsAreContainedNotSame() {
        PatternResult patternResult = analyze("123", "312");

        assertSame(patternResult.getStrikeCount(), 0);
        assertSame(patternResult.getBallCount(), 3);
    }

    @Test
    @DisplayName("2개의 숫자가 위치만 같고 숫자가 다르면, 2개의 볼이 나와야 한다.")
    void getTwoBall_IfTwoDigitsAreContainedNotSame() {
        PatternResult patternResult = analyze("723", "312");

        assertSame(patternResult.getStrikeCount(), 0);
        assertSame(patternResult.getBallCount(), 2);
    }

    @Test
    @DisplayName("1개의 숫자가 위치만 같고 숫자가 다르면, 1개의 볼이 나와야 한다.")
    void getOneBall_IfOneDigitAreContainedNotSame() {
        PatternResult patternResult = analyze("793", "312");

        assertSame(patternResult.getStrikeCount(), 0);
        assertSame(patternResult.getBallCount(), 1);
    }

    @Test
    @DisplayName("모든 숫자가 위치와 숫자까지 다르면, 0개의 스트라이크와 볼이 나와야 한다.")
    void getZeroBallAndStrike_IfAllDigitsAreDifferent() {
        PatternResult patternResult = analyze("795", "312");

        assertSame(patternResult.getStrikeCount(), 0);
        assertSame(patternResult.getBallCount(), 0);
    }

    @Test
    @DisplayName("1개의 숫자가 위치와 숫자가 같고, 2개는 숫자와 위치가 다르면, 1개의 스트라이크와 2개의 볼이 나와야 한다.")
    void getOneStrikeAndTwoBall_IfTwoDigitsAreSameButTheOtherIsContained() {
        PatternResult patternResult = analyze("312", "321");

        assertSame(patternResult.getStrikeCount(), 1);
        assertSame(patternResult.getBallCount(), 2);
    }

    PatternResult analyze(String actual, String expected) {
        ThreeDigits actualThreeDigits = ThreeDigitsFactory.createFrom(actual);
        ThreeDigits expectedThreeDigits = ThreeDigitsFactory.createFrom(expected);

        return new PatternAnalyzer(actualThreeDigits, expectedThreeDigits).analyze();
    }
}
