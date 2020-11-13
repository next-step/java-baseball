package com.yebgi83.baseball;

import com.yebgi83.baseball.model.PatternResult;
import com.yebgi83.baseball.model.ThreeDigits;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class PatternAnalyzerTest {
    @Test
    @DisplayName("모든 숫자가 위치와 숫자가 같으면, 3개의 스트라이크가 나와야 한다.")
    void getThreeStrikeIfThreeDigitsHasSameByPositionAndValue() {
        PatternResult patternResult = analyze("123", "123");

        assertSame(patternResult.getStrikeCount(), 3);
        assertSame(patternResult.getBallCount(), 0);
    }

    @Test
    @DisplayName("2개의 숫자가 위치와 숫자가 같으면, 2개의 스트라이크가 나와야 한다.")
    void getTwoStrikeIfTwoDigitsHasSameByPositionAndValue() {
        PatternResult patternResult = analyze("123", "125");

        assertSame(patternResult.getStrikeCount(), 2);
        assertSame(patternResult.getBallCount(), 0);
    }

    @Test
    @DisplayName("1개의 숫자가 위치와 숫자만 같으면, 1개의 스트라이크가 나와야 한다.")
    void getOneStrikeIfOneDigitHaveSameByPositionAndValue() {
        PatternResult patternResult = analyze("173", "195");

        assertSame(patternResult.getStrikeCount(), 1);
        assertSame(patternResult.getBallCount(), 0);
    }

    @Test
    @DisplayName("모든 숫자가 위치만 같고 숫자가 다르면, 3개의 볼이 나와야 한다.")
    void getThreeBallIfThreeDigitsHasSameByValueNotPosition() {
        PatternResult patternResult = analyze("123", "312");

        assertSame(patternResult.getStrikeCount(), 0);
        assertSame(patternResult.getBallCount(), 3);
    }

    @Test
    @DisplayName("2개의 숫자가 위치만 같고 숫자가 다르면, 2개의 볼이 나와야 한다.")
    void getTwoBallIfThreeDigitsHasSameByValueNotPosition() {
        PatternResult patternResult = analyze("723", "312");

        assertSame(patternResult.getStrikeCount(), 0);
        assertSame(patternResult.getBallCount(), 2);
    }

    @Test
    @DisplayName("1개의 숫자가 위치만 같고 숫자가 다르면, 1개의 볼이 나와야 한다.")
    void getOneBallIfThreeDigitsHasSameByValueNotPosition() {
        PatternResult patternResult = analyze("793", "312");

        assertSame(patternResult.getStrikeCount(), 0);
        assertSame(patternResult.getBallCount(), 1);
    }

    @Test
    @DisplayName("모든 숫자가 위치와 숫자까지 다르면, 0개의 스트라이크와 볼이 나와야 한다.")
    void getZeroBallAndStrikeIfAllDigitsAreDifferent() {
        PatternResult patternResult = analyze("795", "312");

        assertSame(patternResult.getStrikeCount(), 0);
        assertSame(patternResult.getBallCount(), 0);
    }

    PatternResult analyze(String actual, String expected) {
        ThreeDigits actualThreeDigits = ThreeDigits.createFrom(actual);
        ThreeDigits expectedThreeDigits = ThreeDigits.createFrom(expected);

        return PatternAnalyzer.analyze(actualThreeDigits, expectedThreeDigits);
    }
}
