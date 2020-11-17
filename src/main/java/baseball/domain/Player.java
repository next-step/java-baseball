package baseball.domain;

import baseball.exception.IncorrectInputException;
import baseball.view.GameView;

/**
 * 야구 게임에서 플레이어를 의미한다.
 * 플레이어는 숫자를 입력한다.
 *
 * @author  Yonggu Han
 */
public class Player {

    public Number inputNumber(GameView gameView) {
        String inputValue = gameView.inputNumber();
        validateInput(inputValue);
        return new Number(inputValue);
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
