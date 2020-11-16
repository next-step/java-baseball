package baseball.validate;

import java.util.regex.Pattern;

public class BaseBallInputValidator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]{3}$");

    public static void validate(String inputValue) {
        if (validation(inputValue)) {
            throw new IllegalArgumentException("입력 형식이 맞지 않습니다. ex) 123 또는 556");
        }
    }

    private static boolean validation(String inputValue) {
        return !NUMBER_PATTERN.asPredicate().test(inputValue);
    }

}
