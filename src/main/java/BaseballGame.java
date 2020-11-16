import ui.Input;
import ui.Output;
import ui.command.GameCommand;
import domain.Opponent;
import domain.Player;
import domain.Referee;
import domain.baseballRule.BaseballNumbers;
import domain.baseballRule.BaseballResult;

public class BaseballGame {
	Player player = new Player();
	Opponent opponent = new Opponent();
	Referee referee = new Referee();

	public void start() {
		String command = GameCommand.RESTART;
		while (command.equals(GameCommand.RESTART)) {
			newGame();
			Input.printRequestRestart();
			command = Input.inputRestart();
		}
	}

	private void newGame() {
		BaseballNumbers opponents = opponent.generateBaseballNumbers();
		Boolean keepGoing = true;
		while (keepGoing) {
			Input.printRequestInput();
			BaseballNumbers players = player.inputBaseballNumbers(Input.inputBaseballNumbers());
			BaseballResult baseballResult = referee.createBaseballResult(players, opponents);
			Output.printBaseballResult(baseballResult);
			keepGoing = baseballResult.isKeepGoing();
		}
	}
}
