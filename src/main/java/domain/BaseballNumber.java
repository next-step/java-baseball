package domain;

import java.util.*;

public class BaseballNumber {
    private static final int NUMBER_LENGTH = 3;
    private final List<Integer> numbers;

    public BaseballNumber(final int number) {
        this.numbers = convertToList(number);
        validateSize();
        validateZero();
    }

    private List<Integer> convertToList(final int number) {
        return new ArrayList<>(removeDuplicate(number));
    }

    private Set<Integer> removeDuplicate(final int number) {
        Set<Integer> numberSet = new LinkedHashSet<>();
        String[] splitNumbers = String.valueOf(number).split("");
        for (String splitNumber : splitNumbers) {
            numberSet.add(Integer.parseInt(splitNumber));
        }
        return numberSet;
    }

    private void validateSize() {
        if (numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("중복되지 않은 숫자 " + NUMBER_LENGTH + "개만 입력해주세요.");
        }
    }

    private void validateZero() {
        if (numbers.contains(0)) {
            throw new IllegalArgumentException("0이 들어있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
