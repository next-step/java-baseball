package baseball.game.playground;

import baseball.ui.UiSystem;

public class PlayGround {

	private boolean playing = false;
	private UiSystem uiSystem;

	public boolean isPlaying() {
		return playing;
	}

	public void playBall(UiSystem uiSystem) {
		this.playing = true;
		this.uiSystem = uiSystem;

		uiSystem.display("play ball");
	}

}
