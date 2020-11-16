import UI.Input;
import UI.Output;
import UI.command.GameCommand;
import domain.Opponent;
import domain.Player;
import domain.Referee;
import domain.baseballRule.BaseballNumbers;
import domain.baseballRule.BaseballResult;

public class BaseballGame {
	public void start() {
		String command = GameCommand.RESTART;
		while (command.equals(GameCommand.RESTART)) {
			newGame();
			Input.printRequestRestart();
			command = Input.inputRestart();
		}
	}

	private void newGame() {
		Opponent opponent = new Opponent();
		BaseballNumbers opponents = opponent.generateBaseballNumbers();
		Player player = new Player();
		Referee referee = new Referee();
		while (true) {
			Input.printRequestInput();
			BaseballNumbers players = player.inputBaseballNumbers(Input.inputBaseballNumbers());
			BaseballResult baseballResult = referee.checkBaseballResult(players, opponents);
			Output.printBaseballResult(baseballResult);
			if (baseballResult.isThreeStrike())
				break;
		}
	}
}
