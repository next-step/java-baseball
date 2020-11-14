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

    public static Numbers valueOf(int... numbers) {
        List<Number> result = new ArrayList<>();
        for (int number : numbers) {
            result.add(Number.valueOf(number));
        }
        return valueOf(result);
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

    public List<Score> match(Numbers userNumbers) {
        List<Score> resultScores = new ArrayList<>();

        for (int i = 0; i < userNumbers.size(); i++) {
            int matchPoint = checkNumber(userNumbers, i);
            Score score = Score.findScore(matchPoint);
            addScores(resultScores, score);
        }
        resultScores.removeIf(n -> n == Score.NOTHING);
        return resultScores;
    }

    private void addScores(List<Score> resultScores, Score score) {
        if (!Objects.isNull(score)) {
            resultScores.add(score);
        }
    }

    private int checkNumber(Numbers userNumbers, int i) {
        int matchPoint = 0;
        if (isContains(userNumbers, i)) {
            matchPoint++;
        }
        if (isEqualNumber(userNumbers, i)) {
            matchPoint++;
        }
        return matchPoint;
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
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }
}
