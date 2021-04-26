package kr.insup.domain;

import java.util.HashSet;
import java.util.Set;

public class NumberMatcher {

    private int strike = 0;
    private int ball = 0;
    private int totalMatch = 0;
    private char[] inputNumbers;
    private char[] generatedNumbers;

    public NumberMatcher(String inputNumber, String generatedNumber) {
        inputNumbers = inputNumber.toCharArray();
        generatedNumbers = generatedNumber.toCharArray();
    }

    public void matchNumber() {
        totalMatch = calculateTotalMatch();
        strike = calculateStrike();
        ball = totalMatch - strike;
    }

    private int calculateStrike() {
        for (int i = 0; i < inputNumbers.length; i++) {
            strike = addStrike(strike, inputNumbers[i], generatedNumbers[i]);
        }

        return strike;
    }

    private int addStrike(int strike, int inputNumber, int answerNumber) {
        if (inputNumber == answerNumber) {
            return strike + 1;
        }

        return strike;
    }

    private int calculateTotalMatch() {
        Set<Character> numbers = collectNumbers();

        for (char answerNumber : generatedNumbers) {
            totalMatch = addTotalMatch(numbers, answerNumber);
        }

        return totalMatch;
    }

    private Set<Character> collectNumbers() {
        Set<Character> numbers = new HashSet<>();
        for (char c : inputNumbers) {
            numbers.add(c);
        }

        return numbers;
    }

    private int addTotalMatch(Set<Character> numbers, char answerNumber) {
        if (numbers.contains(answerNumber)) {
            return totalMatch + 1;
        }

        return totalMatch;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getTotalMatch() {
        return totalMatch;
    }

    public boolean isFourBall() {
        return totalMatch == 0;
    }

    public boolean isMatch() {
        return strike == GameOptions.HOW_MANY_DIGIT;
    }
}