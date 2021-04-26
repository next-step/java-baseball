package baseball.game;

import baseball.game.playground.PlayGround;
import baseball.game.playground.enums.SystemCommand;
import baseball.ui.UiSystem;

public class NumberBaseBall {

	private static final String SYSTEM_COMMENT = String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요",
		SystemCommand.AGAIN.getCommand(),
		SystemCommand.EXIT.getCommand());

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
			playGround.update();

			isRunning = onSystemUpdate();
		}
		uiSystem.display("게임을 종료합니다");
	}

	private boolean onSystemUpdate() {

		while (true) {
			uiSystem.display(SYSTEM_COMMENT);

			String inputString = uiSystem.gameInput().trim().toLowerCase();
			SystemCommand cmd = SystemCommand.parse(inputString);
			if (SystemCommand.canAgain(cmd)) {
				return true;
			}

			if (SystemCommand.canExit(cmd)) {
				return false;
			}
			uiSystem.display(SystemCommand.UNKNOWN.name());
		}
	}
}
