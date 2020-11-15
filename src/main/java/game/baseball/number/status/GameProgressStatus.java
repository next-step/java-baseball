package game.baseball.number.status;

import game.baseball.number.exceptions.InvalidUserInputTypingException;

public enum GameProgressStatus {

    RESTART(true),
    EXIT(false);

    private final boolean status;

    GameProgressStatus(boolean status) {
        this.status = status;
    }

    private static GameProgressStatus valueOf(byte progressCodeByUserInput) {
        if (progressCodeByUserInput == 1) {
            return GameProgressStatus.RESTART;
        } else if (progressCodeByUserInput == 2) {
            return GameProgressStatus.EXIT;
        }
        throw new InvalidUserInputTypingException(progressCodeByUserInput);
    }

    public static boolean checkProgressStatus(String input) {
        try {
            byte progressCodeByUserInput = Byte.parseByte(input);
            return GameProgressStatus.valueOf(progressCodeByUserInput).status;
        } catch (RuntimeException e) {
            throw new InvalidUserInputTypingException(input, e);
        }
    }
}