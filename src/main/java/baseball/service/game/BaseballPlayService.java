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
		getResult(baseball.getAnswer(), userAnswer);
	}

	private void getResult(List<Integer> answer, List<Integer> userAnswer) {
		baseballGameService.getStrikeCount(answer, userAnswer);
		baseballGameService.getStrikeCount(answer, userAnswer);
	}
}
