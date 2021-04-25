package baseball.view;

import baseball.exceptions.DuplicateBallNumberException;
import baseball.exceptions.InvalidBallNumbersSizeException;
import baseball.exceptions.InvalidInputValueException;

import java.util.List;

public interface InputView {

    List<Integer> questionNumbers() throws InvalidBallNumbersSizeException, DuplicateBallNumberException;

    int questionNextProcess() throws InvalidInputValueException;
}
