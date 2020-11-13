package com.yebgi83.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PatternAnalyzerTest {
    @Test
    @DisplayName("모든 숫자가 위치와 숫자가 같으면, 3개의 스트라이크가 나와야 한다.")
    void getThreeStrikeIfThreeDigitsHasSameByPositionAndValue() {
    }

    @Test
    @DisplayName("2개의 숫자가 위치와 숫자가 같으면, 2개의 스트라이크가 나와야 한다.")
    void getTwoStrikeIfTwoDigitsHasSameByPositionAndValue() {
    }

    @Test
    @DisplayName("1개의 숫자가 위치와 숫자만 같으면, 1개의 스트라이크가 나와야 한다.")
    void getOneStrikeIfOneDigitHaveSameByPositionAndValue() {
    }

    @Test
    @DisplayName("모든 숫자가 위치만 같고 숫자가 다르면, 3개의 볼이 나와야 한다.")
    void getThreeBallIfThreeDigitsHasSameByValueNotPosition() {
    }

    @Test
    @DisplayName("2개의 숫자가 위치만 같고 숫자가 다르면, 2개의 볼이 나와야 한다.")
    void getTwoBallIfThreeDigitsHasSameByValueNotPosition() {
    }

    @Test
    @DisplayName("1개의 숫자가 위치만 같고 숫자가 다르면, 1개의 볼이 나와야 한다.")
    void getOneBallIfThreeDigitsHasSameByValueNotPosition() {
    }

    @Test
    @DisplayName("모든 숫자가 위치와 숫자까지 다르면, 0개의 스트라이크와 볼이 나와야 한다.")
    void getZeroBallAndStritelIfAllDigitsAreDifferent() {
    }
}
