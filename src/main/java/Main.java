import baseball.Number;
import baseball.UserInterface;

import java.util.regex.Pattern;

public class Main {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]{3}");

    public static void main(String[] args) {
        String userInput = UserInterface.printGuideAndScanUserInput();

        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            UserInterface.printInvalidInput(userInput);
            return;
        }

        Number number = new Number(userInput);
        UserInterface.printUserNumber(number);
    }
}
