package baseball.service.game;

import java.util.List;

import baseball.model.Baseball;
import baseball.model.BaseballResult;
import baseball.service.input.ReplayInputService;
import baseball.service.input.UserAnswerInputService;
import baseball.service.output.ResultOutputService;

public class BaseballPlayService implements GameService {

	private final Baseball baseball = new Baseball();
	private final BaseballGameService baseballGameService = new BaseballGameService();
	private final UserAnswerInputService answerInputService = new UserAnswerInputService();
	private final ResultOutputService outputService = new ResultOutputService();
	private final ReplayInputService replayInputService = new ReplayInputService();

	@Override
	public void playGame() {
		do {
			baseball.init();
			guessAnswer();
			outputService.printFinish();
		} while (replayInputService.getUserInput() == 1);
	}

	private void guessAnswer() {
		BaseballResult result;
		do {
			List<Integer> userAnswer = answerInputService.getUserInput();
			result = baseballGameService.getResult(baseball.getAnswer(), userAnswer);
			outputService.printResult(result);
		} while (!result.isAnswer());
	}
}
