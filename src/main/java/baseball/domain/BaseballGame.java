package baseball.domain;

import baseball.constant.GameStatus;
import baseball.constant.MatchResult;
import baseball.constant.MessageContainer;
import baseball.exception.BaseballException;
import baseball.util.BaseballMatcher;
import baseball.view.BaseballGameView;

public class BaseballGame implements Game {
	protected final int ballCount;
	private GameStatus status;
	private BaseballGameView gameViewer;
	protected BaseballMatcher matcher;

	public BaseballGame(BaseballGameView view) {
		this(view, 3);
	}

	public BaseballGame(BaseballGameView view, int ballCount) {
		this.gameViewer = view;
		this.ballCount = ballCount;
		this.status = GameStatus.PLAYING;
		this.matcher = new BaseballMatcher(new BaseballNumber(ballCount));
	}

	@Override
	public void start() {
		do {
			startWithErrorHandling();
		} while (isPlaying());
		getGameViewer().clearView();
	}

	private boolean isPlaying() {
		return status.equals(GameStatus.PLAYING);
	}

	private void startWithErrorHandling() {
		try {
			String input = this.gameViewer.readInput();
			BaseballNumber guessNumber = new GuessBaseballNumber(input, ballCount);
			MatchResult[] results = this.matcher.match(guessNumber);
			GuessResult guessResult = new GuessResult(results);
			processGuessResult(guessResult);
		} catch (BaseballException e) {
			this.gameViewer.println(e.getMessage());
		}
	}
	// 확장가능 부분: 끝내는 조건
	private void processGuessResult(GuessResult guessResult) {
		if (guessResult.getStrikes() == ballCount) {
			this.gameViewer.println(String.format(MessageContainer.FINISH_MESSAGE, ballCount));
			setStatus(GameStatus.FINISH);
			return;
		}
		this.gameViewer.showGuessResult(guessResult);
	}

	private void setStatus(GameStatus status) {
		this.status = status;
	}

	public BaseballGameView getGameViewer() {
		return gameViewer;
	}
}
