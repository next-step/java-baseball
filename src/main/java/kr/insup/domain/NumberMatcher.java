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

    /**
     * 생성자로 받은 사용자 입력 숫자와 생성된 숫자를 비교한다.
     * totalMatch : 순서 상관 없이 몇개의 숫자가 같은지 확인
     * strike : 숫자와 자리까지 같음
     * ball : 숫자는 있지만 자리가 다름
     */
    public void matchNumber() {
        totalMatch = calculateTotalMatch();
        strike = calculateStrike();
        ball = totalMatch - strike;
    }

    private int calculateStrike() {
        for (int i = 0; i < inputNumbers.length; i++) {
            strike = addStrike(inputNumbers[i], generatedNumbers[i]);
        }

        return strike;
    }

    private int addStrike(int inputNumber, int generatedNumber) {
        if (inputNumber == generatedNumber) {
            return strike + 1;
        }

        return strike;
    }

    private int calculateTotalMatch() {
        Set<Character> numbers = collectNumbers();

        for (char generatedNumber : generatedNumbers) {
            totalMatch = addTotalMatch(numbers, generatedNumber);
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

    private int addTotalMatch(Set<Character> numbers, char generatedNumber) {
        if (numbers.contains(generatedNumber)) {
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

    /**
     * 포볼(숫자가 같은 것이 하나도 없음)을 확인
     * @return 포볼이면 true, 포볼이 아니면 false
     */
    public boolean isFourBall() {
        return totalMatch == 0;
    }

    /**
     * 정답을 맞췄는지 확인
     * @return 정답이면 true, 정답이 아니면 false
     */
    public boolean isMatch() {
        return strike == GameOptions.HOW_MANY_DIGIT;
    }
}