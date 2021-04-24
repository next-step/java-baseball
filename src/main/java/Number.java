import java.util.Objects;

public class Number {

    public static final int INPUT_NUMBER_SIZE = 3;
    public static final int NOT_CONTAIN_SIGNATURE = -1;

    private final String number;

    public Number(String number) {
        validateInputNumberSize(number);

        this.number = number;
    }

    private void validateInputNumberSize(String number) {
        if (number.length() != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
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
