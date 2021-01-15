package features;

public class Validator {
    // Regular Expression to detect unique 3 digit number.
    private static String regex = "(?!.*(.).*\\1)^[1-9]{3}";

    /**
     * Decide given string is validate.
     * @param string any type of string.
     * @return boolean.
     */
    public static boolean isCorrectInput(String userInput) {
        return userInput.matches(regex);
    }
}
