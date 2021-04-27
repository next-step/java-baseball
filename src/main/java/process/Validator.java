package process;

import logic.Answer;
import ui.Presentator;

public class Validator {
    enum Type {
        END_GAME,
        INPUT_NUMBER
    }

    public static boolean isValid(Type type, Object input) throws Exception {
        if (type == Type.END_GAME) {
            return isValidEndGameInput((String) input);
        }

        if (type == Type.INPUT_NUMBER) {
            return isValidInputNumber((String) input);
        }
        throw new Exception("존재하지 않는 valid 타입입니다. ");
    }

    private static boolean isValidInputNumber(String inputValue) {
        return inputValue.length() == Answer.ANSWER_SIZE &&
                isInputValueInRange(inputValue, Answer.ANSWER_LOWER_BOUND_NUMBER, Answer.ANSWER_UPPER_BOUND_NUMBER);
    }

    private static boolean isInputValueInRange(String inputValue, int min, int max) {
        String isNumberInRangeRegEx = String.format("^[%d-%d]+$",min,max);
        return inputValue.matches(isNumberInRangeRegEx);
    }

    public static boolean isValidEndGameInput(String inputValue) {
        if (inputValue.equals(Presentator.RESTART)) return true;
        if (inputValue.equals(Presentator.QUIT)) return true;
        return false;
    }

}
