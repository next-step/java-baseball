package domain;

public class UserNumber {
    private final Integer number;

    public UserNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        validateThreeLengthNumber(number);
    }

    protected static void validateThreeLengthNumber(int randomNumber) {
        String numberString = String.valueOf(randomNumber);
        if (numberString.length() != 3) {
            throw new IllegalArgumentException("입력 숫자는 3자리 수여야 합니다.");
        }
    }
}
