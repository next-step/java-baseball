package domain;

import java.util.*;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers valueOf(Collection<Number> numbers) {
        validateNumbers(numbers);
        validateNumbersDuplicate(numbers);
        return new Numbers(new ArrayList<>(numbers));
    }

    private static void validateNumbers(Collection<Number> numbers) {
        if (Objects.isNull(numbers) || numbers.isEmpty()) {
            throw new IllegalArgumentException("숫자값은 비어있으면 안됩니다.");
        }
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("숫자값은 반드시 3개 있어야 합니다.");
        }
    }

    private static void validateNumbersDuplicate(Collection<Number> numbers) {
        Set<Number> convertedSet = new HashSet(numbers);
        if (numbers.size() != convertedSet.size()) {
            throw new IllegalArgumentException("숫자야구에서는 중복되는 값이 올 수 없습니다.");
        }
    }

    public static Numbers valueOf(int... numbers) {
        return valueOf(convertToNumberList(numbers));
    }

    public static Numbers valueOf(String numbers) {
        return valueOf(convertToIntArray(numbers));
    }

    private static List<Number> convertToNumberList(int[] numbers) {
        List<Number> result = new ArrayList<>();
        for (int number : numbers) {
            result.add(Number.valueOf(number));
        }
        return result;
    }

    private static int [] convertToIntArray(String numbers) {
        String [] splitString = numbers.split("");
        return parseInt(splitString);
    }

    private static int [] parseInt(String[] splitString) {
        int [] array = new int [splitString.length];
        for (int i = 0; i < splitString.length; i ++) {
            array[i] = Integer.parseInt(splitString[i]);
        }
        return array;
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int size() {
        return numbers.size();
    }

    public boolean isContain(Numbers users) {
        List<Number> userNumbers = new ArrayList(users.numbers);
        userNumbers.retainAll(numbers);
        return userNumbers.size() > 0;
    }

    public Result match(Numbers userNumbers) {
        Result result = new Result();
        for (int i = 0; i < userNumbers.size(); i++) {
            Score score = checkScore(userNumbers, i);
            result.put(score);
        }
        return result;
    }

    private Score checkScore(Numbers userNumbers, int i) {
        int matchPoint = 0;
        if (isContains(userNumbers, i)) {
            matchPoint++;
        }
        if (isEqualNumber(userNumbers, i)) {
            matchPoint++;
        }
        return Score.findScore(matchPoint);
    }

    private boolean isEqualNumber(Numbers userNumbers, int i) {
        return Objects.equals(numbers.get(i), userNumbers.numbers.get(i));
    }

    private boolean isContains(Numbers userNumbers, int i) {
        return numbers.contains(userNumbers.numbers.get(i));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "domain.Numbers{" +
                "numbers=" + numbers +
                '}';
    }
}
