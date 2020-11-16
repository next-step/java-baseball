package baseball.domain;

import baseball.exception.IncorrectInputException;
import baseball.view.GameView;

import java.util.Arrays;
import java.util.List;

public class Player {

    public Number inputNumber(GameView gameView) {
        String inputValue = gameView.inputNumber();
        validateInput(inputValue);
        List<Integer> digits = Arrays.asList(
                Character.getNumericValue(inputValue.charAt(0)),
                Character.getNumericValue(inputValue.charAt(1)),
                Character.getNumericValue(inputValue.charAt(2)));
        return new Number(digits);
    }

    private void validateInput(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException nfe) {
            throw new IncorrectInputException("숫가가 아닌 값을 입력하였습니다.");
        }
        if (inputValue.length() != Game.BASEBALL_NUMBER_SIZE) {
            throw new IncorrectInputException("입력한 숫자는 " + Game.BASEBALL_NUMBER_SIZE + "개이어야 합니다.");
        }
    }
}
