package precourse.game;

import static precourse.constant.BaseballSpecification.*;

import java.util.regex.Pattern;

public class BaseballNumberString {

    private static final String VALID_BASEBALL_NUMBER_RANGE = "^[1-9]*$";
    private final String numberString;

    public BaseballNumberString(String numberString) {
        isThreeDigitNumber(numberString);
        this.numberString = numberString;
    }

    private void isThreeDigitNumber(String numberString) {
        if (numberString.length() != MAX_BASEBALLS.getValue() ||
                !Pattern.matches(VALID_BASEBALL_NUMBER_RANGE, numberString)) {
            throw new IllegalArgumentException();
        }
    }

    public String numberString() {
        return numberString;
    }

}
