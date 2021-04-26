package baseball.game.playground;

import baseball.game.playground.gameball.GameBall;
import baseball.game.playground.hitter.Hitter;
import baseball.game.playground.pitcher.Pitcher;
import baseball.game.playground.referee.Referee;
import baseball.game.playground.referee.ScoreBoard;
import baseball.ui.UiSystem;

public class PlayGround {

	private boolean playing = false;
	private UiSystem uiSystem;

	private Pitcher pitcher;
	private Hitter hitter;
	private Referee referee;

	public boolean isPlaying() {
		return playing;
	}

	public void playBall(UiSystem uiSystem) {

		this.playing = true;
		this.uiSystem = uiSystem;
		init();
	}

	private void init() {
		this.pitcher = new Pitcher(uiSystem);
		this.hitter = new Hitter(GameBall.create());
		this.referee = new Referee();
	}

	public void update() {

		while (isPlaying()) {

			String pitcherNum = this.pitcher.throwing();
			String hitterNum = this.hitter.swing();

			ScoreBoard scoreBoard = this.referee.judgement(pitcherNum, hitterNum);
			scoreBoard.display(uiSystem);

			this.playing = this.referee.nextPlay();
		}

	}
}
