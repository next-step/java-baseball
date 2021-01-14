import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // FIXME: 684 입력 -> 54, 56, 52
    public Numbers(String numbersString) {
        validate(numbersString);
        this.numbers = convertStringToCollectionOfIntegers(numbersString);
    }

    // TODO: validation method 완성
    private void validate(List<Integer> numbers) {

    }

    // TODO: validation method 완성
    private void validate(String numbersString) {

    }

    private List<Integer> convertStringToCollectionOfIntegers(String numbersString) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numbersString.length(); i++) {
            numbers.add((int) numbersString.charAt(i));
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public BallCount getBallCount(Numbers anotherNumbers) {
        return new BallCount(this, anotherNumbers);
    }
}
