package baseball.service;

import baseball.model.Baseball;

public class BaseballGameService implements GameService {

	private final Baseball baseball = new Baseball();

	@Override
	public void playGame() {
		baseball.init();
	}
}
