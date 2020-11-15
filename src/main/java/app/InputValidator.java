package app;

public class InputValidator {

    private static final int MAX_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static boolean isValid(String input) {
        boolean result = true;
        String regExp = "^[0-9]+$";

        if (input.length() > MAX_LENGTH || !input.matches(regExp)) {
            result = false;
        }

        return result;
    }
}
