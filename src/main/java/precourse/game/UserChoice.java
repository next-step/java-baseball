package precourse.game;

import java.util.regex.Pattern;

public class UserChoice {

    private static final String VALID_CHOICE_NUMBER_RANGE = "^[1|2]*$";
    private static final int START_NEW_GAME = 1;
    private static final int QUIT_GAME = 2;
    private final String choice;

    public UserChoice(String choice) {
        isOneDigitNumber(choice);
        this.choice = choice;
    }

    public boolean isStartNewGame() {
        return Integer.parseInt(choice) == START_NEW_GAME;
    }

    public boolean isQuitGame() {
        return Integer.parseInt(choice) == QUIT_GAME;
    }

    private void isOneDigitNumber(String choice) {
        if (choice.length() != 1
                || !Pattern.matches(VALID_CHOICE_NUMBER_RANGE, choice)) {
            throw new IllegalArgumentException();
        }
    }

}
