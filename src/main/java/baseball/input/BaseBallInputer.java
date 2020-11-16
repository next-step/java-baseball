package baseball.input;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BaseBallInputer {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]{3}$");

    public static String input(InputStream in) {
        Scanner input = new Scanner(in);
        String inputValue = input.nextLine();

        if (validation(inputValue)) {
            throw new IllegalArgumentException("입력 형식이 맞지 않습니다. ex) 123 또는 556");
        }

        return inputValue;
    }

    private static boolean validation(String inputValue) {
        return !NUMBER_PATTERN.asPredicate().test(inputValue);
    }

}
