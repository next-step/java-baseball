package baseball.game;

import baseball.game.playground.PlayGround;
import baseball.game.playground.enums.SystemCommand;
import baseball.ui.UiSystem;

public class NumberBaseBall {

	private final UiSystem uiSystem;
	private final PlayGround playGround;

	public NumberBaseBall(UiSystem uiSystem) {
		this.uiSystem = uiSystem;
		this.playGround = new PlayGround();
	}

	public void run() {

		boolean isRunning = true;
		while (isRunning) {

			playGround.playBall(uiSystem);
			isRunning = onUpdate();
		}
		uiSystem.display("game exit");

	}

	private boolean onUpdate() {

		while (true) {
			uiSystem.display("\tagain-다시하기\n\texit-종료하기");

			String input = uiSystem.systemInput();
			String command = input.trim().toLowerCase();
			if (SystemCommand.contains(command)) {
				return SystemCommand.canAgain(command);
			}

			uiSystem.display("알수 없는 명령");
		}
	}
}
