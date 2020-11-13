package com.yebgi83.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class AnswerCreatorTest {
    private final AnswerCreator answerCreator = new AnswerCreator();

    @Test
    @DisplayName("정답을 구성하는 3자리 숫자여야 한다.")
    void answerShouldBeSizeOfThree() {
        String answer = answerCreator.createAnswer();
        assertTrue(answer != null && answer.length() == 3);
    }

    @Test
    @DisplayName("정답을 구성하는 3자리 숫자는 중복이 아니어야 한다.")
    void digitsOfAnswerShouldBeUniqueDigit() {
        String answer = answerCreator.createAnswer();

        if (!digitsOfAnswerShouldBeUniqueDigit(answer)) {
            fail();
        }
    }

    @Test
    @DisplayName("정답은 생성할 때마다 다른 숫자가 나와야 한다.")
    void answerShouldBeCreatedDifferentlyByEachTime() {
        int times = 10;

        if (!answerShouldBeCreatedDifferentlyByEachTime(times)) {
            fail();
        }
    }

    boolean digitsOfAnswerShouldBeUniqueDigit(String answer) {
        Set<Character> digits = new HashSet<>();

        for (Character digit : answer.toCharArray()) {
            if (digits.contains(digit)) {
                return false;
            }

            digits.add(digit);
        }

        return true;
    }

    boolean answerShouldBeCreatedDifferentlyByEachTime(int times) {
        String lastAnswer = null;

        for (int trial = 1; trial <= times; trial++) {
            String answer = answerCreator.createAnswer();

            if (lastAnswer != null) {
                if (answer.equals(lastAnswer)) {
                    return false;
                }
            }

            lastAnswer = answer;
        }

        return true;
    }
}