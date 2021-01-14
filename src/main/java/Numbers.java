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
            numbers.add((int) numbersString.charAt(i));
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    // TODO: 다른 `Numbers`를 인자로 받아 두 `Numbers`에 대해 볼카운트를 알려주는 public 메서드 완성
    // TODO: BallCount라는 별도 객체를 만들지 고민 필요
    public String getBallCount(Numbers anotherNumbers) {
        return null;
    }
}
