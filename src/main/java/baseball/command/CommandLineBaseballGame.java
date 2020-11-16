package baseball.command;

import baseball.BaseballGame;

public class CommandLineBaseballGame {

	public static void main(String[] args) {
		new BaseballGame(new ScannerInput(), new ConsolePresenter()).execute();
	}
}
