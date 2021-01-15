package features;

public class Validator {
    private static String regex = "(?!.*(.).*\\1)^[1-9]{3}";

    public static boolean isCorrectInput(String userInput) {
        return userInput.matches(regex);
    }
}
