package baseball.command;

import baseball.BaseBallGame;

public class CommandLineBaseBallGame {

	public static void main(String[] args) {
		new BaseBallGame(new ScannerInput(), new ConsolePresenter()).execute();
	}
}
