import java.util.HashSet;
import java.util.Set;

public class NumberMatcher {

    public String matchNumber(String inputNumber, String answerNumber) {
        char[] inputNumbers = inputNumber.toCharArray();
        char[] answerNumbers = answerNumber.toCharArray();

        int totalMatch = getTotalMatch(inputNumbers, answerNumbers);
        int strike = getStrike(inputNumbers, answerNumbers);
        int ball = totalMatch - strike;

        return strike + "" + ball + "" + totalMatch;
    }

    public int getStrike(char[] inputNumbers, char[] answerNumbers) {
        int strike = 0;

        for (int i = 0; i < inputNumbers.length; i++) {
            strike = addStrike(strike, inputNumbers[i], answerNumbers[i]);
        }

        return strike;
    }

    private int addStrike(int strike, int inputNumber, int answerNumber) {
        if (inputNumber == answerNumber) {
            return strike + 1;
        }

        return strike;
    }

    public int getTotalMatch(char[] inputNumbers, char[] answerNumbers) {
        int totalMatch = 0;

        Set<Character> numbers = collectNumbers(inputNumbers);

        for (char answerNumber : answerNumbers) {
            totalMatch = addTotalMatch(totalMatch, numbers, answerNumber);
        }

        return totalMatch;
    }

    private Set<Character> collectNumbers(char[] inputNumbers) {
        Set<Character> numbers = new HashSet<>();
        for (char c : inputNumbers) {
            numbers.add(c);
        }

        return numbers;
    }

    private int addTotalMatch(int totalMatch, Set<Character> numbers, char answerNumber) {
        if (numbers.contains(answerNumber)) {
            return totalMatch + 1;
        }

        return totalMatch;
    }
}