package baseball.service.game;

import java.util.List;

import baseball.model.Baseball;
import baseball.service.input.UserAnswerInputService;

public class BaseballPlayService implements GameService {

	private final Baseball baseball = new Baseball();
	private final BaseballGameService baseballGameService = new BaseballGameService();
	private final UserAnswerInputService userAnswerInputService = new UserAnswerInputService();

	@Override
	public void playGame() {
		baseball.init();
		List<Integer> userAnswer = userAnswerInputService.getUserInput();
		BaseballResult result = baseballGameService.getResult(baseball.getAnswer(), userAnswer);
		resultOutputService.printResult(result);
	}
}
