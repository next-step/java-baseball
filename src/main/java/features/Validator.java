package features;

public class Validator {

    /**
     * Decide given string is validate.
     * @param string any type of string.
     * @return boolean.
     */
    public static boolean isCorrectInput(String userInput) {
        String unique = "^(?!.*(.).*\\1)";     // Find string only contains unique character.
        String number = "[1-9]";               // Find string contains 1-9.
        String length = "{3}";                 // Check string has length of 3.
        return userInput.matches(unique + number + length);
    }

    /**
     * Decide given user option is validate.
     * @param string any type of string.
     * @return boolean.
     */
    public static boolean isCorrectOption(String userOption) {
        String number = "^[1-2]";              // Find string contains 1 or 2.
        String length = "{1}";                 // Check string has length of 1.
        return userOption.matches(number + length);
    }
}
