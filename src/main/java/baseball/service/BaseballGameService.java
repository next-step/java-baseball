package baseball.service;

import baseball.model.Baseball;
import baseball.service.input.UserAnswerInputService;

public class BaseballGameService implements GameService {

	private final Baseball baseball = new Baseball();
	private final UserAnswerInputService userAnswerInputService = new UserAnswerInputService();

	@Override
	public void playGame() {
		baseball.init();
		userAnswerInputService.getUserInput();
	}
}
