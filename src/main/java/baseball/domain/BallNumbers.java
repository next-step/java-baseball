package baseball.domain;

import java.util.*;

public class BallNumbers {
    public static final int NUMBERS_INIT_INDEX = 0;
    public static final int NUMBERS_LIMIT_SIZE = 3;

    private final List<BallNumber> numbers;

    public BallNumbers(List<BallNumber> numbers) {
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public BallNumbers(String numbers) {
        validateNullorEmpty(numbers);
        validateDuplicate(convertToList(numbers));
        this.numbers = convertToList(numbers);
    }

    private void validateNullorEmpty(String numbers) {
        if (numbers == null || numbers.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 값은 넣을 수 없습니다.");
        }
    }

    private String[] splitNumbers(String numbers) {
        String[] splited = numbers.split("");
        return splited;
    }

    private void validateDuplicate(Collection<BallNumber> numbers) {
        Set<BallNumber> validateSet = new HashSet<>(numbers);
        if (validateSet.size() != NUMBERS_LIMIT_SIZE) {
            throw new IllegalArgumentException("숫자는 중복되지 않은 3자리 숫자여야 합니다.");
        }
    }

    private List<BallNumber> convertToList(String numbers) {
        String[] strings = splitNumbers(numbers);
        List<BallNumber> converted = new ArrayList<>();
        for (String number : strings) {
            converted.add(new BallNumber(number));
        }
        return converted;
    }

    public List<BallNumber> getNumbers() {
        return numbers;
    }

    public boolean hasContains(BallNumbers ballNumbers) {
        List<BallNumber> retains = new ArrayList<>(ballNumbers.numbers);
        retains.retainAll(numbers);
        return retains.size() > 0;
    }

    public int size() {
        return numbers.size();
    }

    public boolean contains(BallNumbers ballNumbers, int index) {
        return numbers.contains(ballNumbers.numbers.get(index));
    }

    public BallNumber getIndexNumber(int index) {
        return numbers.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumbers that = (BallNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
