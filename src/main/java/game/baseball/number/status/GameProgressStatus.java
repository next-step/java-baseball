package game.baseball.number.status;

import game.baseball.number.exceptions.InvalidRestartOrExitInputException;
import game.baseball.number.utils.ConsoleOutputUtil;
import game.baseball.number.utils.HelperTexts;
import game.baseball.number.utils.ConsoleInputUtil;

public enum GameProgressStatus {

    RESTART(true, 1),
    EXIT(false, 2);

    private final boolean status;
    private final int code;

    GameProgressStatus(boolean status, int code) {
        this.status = status;
        this.code = code;
    }

    private static GameProgressStatus valueOf(int parsedInput) {
        if (parsedInput == RESTART.code) {
            return GameProgressStatus.RESTART;
        }
        if (parsedInput == EXIT.code) {
            return GameProgressStatus.EXIT;
        }
        throw new InvalidRestartOrExitInputException(parsedInput);
    }

    public static String inputRestartOrExit() {
        ConsoleOutputUtil.printNextLine();
        return ConsoleInputUtil.input(HelperTexts.RESTART_OR_EXIT);
    }

    public static boolean checkRestartOrExit(String input) {
        try {
            int parsedInput = Integer.parseInt(input);
            return GameProgressStatus.valueOf(parsedInput).status;
        } catch (RuntimeException e) {
            throw new InvalidRestartOrExitInputException(input, e);
        }
    }
}
