import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Number {

    public static final int INPUT_NUMBER_SIZE = 3;
    public static final int NOT_CONTAIN_SIGNATURE = -1;
    public static final String SPLIT_NUMBER_DELIMITER = "";

    private final String number;

    public Number(String number) {
        validateInputNumberSize(number);
        validateInputNumberDuplicate(number);

        this.number = number;
    }

    private void validateInputNumberDuplicate(String number) {
        List<String> splitNumber = List.of(number.split(SPLIT_NUMBER_DELIMITER));

        Set<String> removedDuplicateNumber = new HashSet<>(splitNumber);
        if (isSizeOfValidNumber(removedDuplicateNumber.size())) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다. : " + number);
        }
    }

    private void validateInputNumberSize(String number) {
        if (isSizeOfValidNumber(number.length())) {
            throw new IllegalArgumentException("입력한 숫자의 길이는 3자리이어야 합니다. : " + number);
        }
    }

    private boolean isSizeOfValidNumber(int inputSize) {
        return inputSize != INPUT_NUMBER_SIZE;
    }

    public int length() {
        return number.length();
    }

    public boolean haveValue(Number input, int index) {
        return number.indexOf(input.charAt(index)) != NOT_CONTAIN_SIGNATURE;
    }

    public boolean isStrike(Number input, int index) {
        return number.charAt(index) == input.charAt(index);
    }

    private char charAt(int index) {
        return number.charAt(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return Objects.equals(number, number1.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
