package baseball.view;

import baseball.domain.dto.BaseballResultResponse;
import baseball.exceptions.DuplicateBallNumberException;
import baseball.exceptions.InvalidBallNumberException;
import baseball.exceptions.InvalidBallNumbersSizeException;
import baseball.exceptions.InvalidInputValueException;

import java.util.List;

public class BaseballViewImpl implements BaseballView {
    public static final String REQUIRED_VALID_INPUT_NUMBER = "입력하신 숫자가 유효하지 않습니다. 다시 입력해주세요.";
    private final InputView inputView;
    private final ResultView resultView;

    public BaseballViewImpl(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    @Override
    public List<Integer> questionNumbers() {
        try {
            return inputView.questionNumbers();
        } catch (InvalidBallNumbersSizeException | DuplicateBallNumberException | InvalidBallNumberException ie) {
            System.out.println(REQUIRED_VALID_INPUT_NUMBER);
            return questionNumbers();
        }
    }

    @Override
    public int questionNextProcess() {
        try {
            return inputView.questionNextProcess();
        } catch (InvalidInputValueException ie) {
            return inputView.questionNextProcess();
        }
    }

    @Override
    public void showPitchingResult(BaseballResultResponse response) {
        try {
            resultView.showPitchingResult(response);
        } catch (RuntimeException err) {
            System.out.println(err.getMessage());
        }
    }
}
