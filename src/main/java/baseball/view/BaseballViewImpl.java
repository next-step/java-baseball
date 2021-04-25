package baseball.view;

import baseball.domain.dto.BaseballResultResponse;
import baseball.exceptions.DuplicateBallNumberException;
import baseball.exceptions.InvalidBallNumbersSizeException;
import baseball.exceptions.InvalidInputValueException;

import java.util.List;

public class BaseballViewImpl implements BaseballView {
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
        } catch (InvalidBallNumbersSizeException | DuplicateBallNumberException ie) {
            System.out.println("입력하신 숫자가 유효하지 않습니다. 다시 입력해주세요.");
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
