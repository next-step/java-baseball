package baseball;

import baseball.game.Balls;
import baseball.game.Game;
import baseball.game.GameScore;
import baseball.input.Input;
import baseball.presenter.Presenter;

public class BaseBallGame {

	private final Input input;
	private final Presenter presenter;
	private boolean isRunning = true;

	public BaseBallGame(Input input, Presenter presenter) {
		this.input = input;
		this.presenter = presenter;
	}

	public void execute() {
		while (this.isRunning) {
			this.isRunning = operate();
		}
		exit();
	}

	private boolean operate() {
		Operation operation = getOperation();
		if (operation == Operation.EXIT) {
			return false;
		}
		if (operation == Operation.START) {
			startGame();
		}
		return true;
	}

	private Operation getOperation() {
		return input.get(
				() -> {
					this.presenter.operate();
					return this.input.getOperation();
				},
				e -> presenter.inputFailed(e.getMessage())
		);
	}

	private void exit() {
		presenter.exit();
		System.exit(0);
	}

	private void startGame() {
		presenter.startGame();
		Game game = new Game();
		boolean isPlaying = true;

		while (isPlaying) {
			Balls balls = getBalls();
			GameScore score = game.play(balls);
			isPlaying = judge(score);
		}
	}

	private Balls getBalls() {
		return input.get(
				() -> {
					this.presenter.playBall();
					return input.getBalls();
				},
				e -> presenter.inputFailed(e.getMessage())
		);
	}

	private boolean judge(GameScore score) {
		this.presenter.score(score);
		if (score.isCleared()) {
			this.presenter.clear();
			return false;
		}
		return true;
	}
}
