package baseball.view;

import baseball.exceptions.DuplicateBallNumberException;
import baseball.exceptions.InvalidBallNumberException;
import baseball.exceptions.InvalidBallNumbersSizeException;
import baseball.exceptions.InvalidInputValueException;

import java.util.List;

public interface InputView {

    List<Integer> questionNumbers() throws InvalidBallNumbersSizeException, DuplicateBallNumberException, InvalidBallNumberException;

    int questionNextProcess() throws InvalidInputValueException;
}
