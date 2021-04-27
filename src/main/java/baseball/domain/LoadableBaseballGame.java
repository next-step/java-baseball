package baseball.domain;

import baseball.util.BaseballMatcher;
import baseball.view.BaseballGameView;

public class LoadableBaseballGame extends BaseballGame {

	BaseballMatcher tempMatcher;

	public LoadableBaseballGame(BaseballGameView view) {
		super(view);
		tempMatcher = this.matcher;
	}

	@Override
	public void start() {
		loadPrevGame();
		super.start();
	}

	private void loadPrevGame() {
		try {
			this.matcher = new BaseballMatcher(new GuessBaseballNumber(getGameViewer().readInput(),ballCount));
		} catch (Exception e) {
			this.matcher = tempMatcher;
			// not loadable
			getGameViewer().getOutputWriter().println(tempMatcher.getTarget());
		}
	}
}
