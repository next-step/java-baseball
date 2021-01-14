import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

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
            numbers.add(Integer.valueOf(numbersString.substring(i, i + 1)));
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
