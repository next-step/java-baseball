import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// TODO: exception message를 담은 enum 추가
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

    private void validate(List<Integer> numbers) {
        if (numbers.size() < 3) {
            throw new IllegalArgumentException("내용이 충분하지 않습니다. 다시 입력해 주세요 : ");
        }
        StringBuilder numbersString = new StringBuilder();
        for (int num : numbers) {
            numbersString.append(num);
        }
        validate(numbersString.toString());
    }

    private void validate(String numbersString) {
        if (!isNumeric(numbersString)) {
            throw new IllegalArgumentException("숫자가 아닙니다. 다시 입력해 주세요 : ");
        }
        if (numbersString.length() != 3) {
            throw new IllegalArgumentException("3자리의 정수여야만 합니다. 다시 입력해 주세요 : ");
        }
        Set<Integer> argNumbers = new LinkedHashSet<>();
        for (int i = 0; i < numbersString.length(); i++) {
            String digitString = numbersString.substring(i, i + 1);
            Integer digit = Integer.valueOf(digitString);
            if (digit == 0) {
                throw new IllegalArgumentException("0이 포함된 수는 사용할 수 없습니다. 다시 입력해 주세요 : ");
            }
            if (argNumbers.contains(digit)) {
                throw new IllegalArgumentException("각 자리의 수는 모두 달라야 합니다. 다시 입력해 주세요 : ");
            }
            argNumbers.add(digit);
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
