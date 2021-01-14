import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// TODO: `NumbersTest` 추가 & 생성자 예외발생 테스트
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

    private void validate(String numbersString) {
        if (!isNumeric(numbersString)) {
            throw new IllegalArgumentException("숫자가 아닙니다. 다시 입력해 주세요 : ");
        }
        if (numbersString.length() != 3) {
            throw new IllegalArgumentException("3자리의 정수여야만 합니다. 다시 입력해 주세요 : ");
        }
        Set<String> argNumbers = new LinkedHashSet<>();
        for (int i = 0; i < numbersString.length(); i++) {
            String number = numbersString.substring(i, i + 1);
            if (argNumbers.contains(number)) {
                throw new IllegalArgumentException("각 자리의 수는 서로 달라야 합니다. 다시 입력해 주세요 : ");
            }
            argNumbers.add(String.valueOf(Integer.valueOf(number)));
        }
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
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
